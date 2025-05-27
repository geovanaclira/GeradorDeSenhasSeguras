package br.com.geovana.gerenciador.repository;

// Classe responsável por salvar e ler credenciais do disco

import br.com.geovana.gerenciador.model.Credencial;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArquivoRepository implements CredencialRepository {
    private String nomeArquivo;

    public ArquivoRepository(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
        criarArquivoSeNaoExistir();
    }

    private void criarArquivoSeNaoExistir() {
        try {
            File file = new File(nomeArquivo);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            System.err.println("Erro ao criar o arquivo: " + e.getMessage());
        }
    }

    @Override
    public void adicionar(Credencial credencial) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            writer.write(credencial.getServico() + ";" + credencial.getUsuario() + ";" + credencial.getSenhaCriptografada());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Erro ao salvar a credencial: " + e.getMessage());
        }
    }

    @Override
    public boolean remover(String servico) {
        List<Credencial> todas = listarTodas();
        boolean removido = todas.removeIf(c -> c.getServico().equalsIgnoreCase(servico));
        if (removido) {
            sobrescreverArquivo(todas);
        }
        return removido;
    }

    @Override
    public Credencial buscar(String servico) {
        List<Credencial> todas = listarTodas();
        return todas.stream()
                .filter(c -> c.getServico().equalsIgnoreCase(servico))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Credencial> listarTodas() {
        List<Credencial> lista = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 3) {
                    Credencial credencial = new Credencial(partes[0], partes[1], partes[2]);
                    lista.add(credencial);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return lista;
    }

    private void sobrescreverArquivo(List<Credencial> lista) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Credencial c : lista) {
                writer.write(c.getServico() + ";" + c.getUsuario() + ";" + c.getSenhaCriptografada());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao sobrescrever o arquivo: " + e.getMessage());
        }
    }

    @Override
    public Credencial buscarPorUsuario(String usuario) {
        List<Credencial> todas = listarTodas();
        return todas.stream()
                .filter(c -> c.getUsuario().equalsIgnoreCase(usuario))
                .findFirst()
                .orElse(null);
    }
}
