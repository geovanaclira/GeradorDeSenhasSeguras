package br.com.geovana.gerenciador.service;

// Classe responsável por adicionar, remover e listar credenciais

import br.com.geovana.gerenciador.model.Credencial;
import br.com.geovana.gerenciador.repository.ArquivoRepository;
import br.com.geovana.gerenciador.repository.CredencialRepository;

import java.util.List;

public class GerenciadorSenhaService {
    private CredencialRepository repositorio;

    private static final String NOME_ARQUIVO = "credenciais.txt";

    public GerenciadorSenhaService() {
        this.repositorio = new ArquivoRepository(NOME_ARQUIVO);
    }

    public void adicionar(String servico, String usuario, String senha) {
        String senhaCriptografada = CriptografiaService.gerarHash(senha);
        Credencial credencial = new Credencial(servico, usuario, senhaCriptografada);
        repositorio.adicionar(credencial);
    }

    public boolean remover(String servico) {
        return repositorio.remover(servico);
    }

    public Credencial buscar(String servico) {
        return repositorio.buscar(servico);
    }

    public List<Credencial> listarTodas() {
        return repositorio.listarTodas();
    }
}
