package br.com.geovana.gerenciador.service;

// Classe responsável por adicionar, remover, buscar, listar credenciais e autenticar o usuário

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

    // Adiciona uma credencial
    public void adicionar(String servico, String usuario, String senha) {
        String senhaCriptografada = CriptografiaService.gerarHash(senha);
        Credencial credencial = new Credencial(servico, usuario, senhaCriptografada);
        repositorio.adicionar(credencial);
    }

    // Remove uma credencial a partir do nome do serviço
    public boolean remover(String servico) {
        return repositorio.remover(servico);
    }

    // Busca credencial a partir do nome do serviço
    public Credencial buscar(String servico) {
        return repositorio.buscar(servico);
    }

    // Lista todas as credenciais salvas
    public List<Credencial> listarTodas() {
        return repositorio.listarTodas();
    }

    // Autentica o usuário verificando serviço, nome de usuário e senha
    public boolean autenticarUsuario(String servico, String usuario, String senhaDigitada) {
        Credencial credencial = repositorio.buscar(servico);
        if (credencial == null) return false;

        return credencial.getUsuario().equals(usuario)
                && CriptografiaService.verificarSenha(senhaDigitada, credencial.getSenhaCriptografada());
    }

    // Busca uma credencial pelo nome do usuário
    public Credencial buscarPorUsuario(String usuario) {
        return repositorio.buscarPorUsuario(usuario);
    }

    // Valida a senha digitada comparando com o hash criptografado
    public boolean validarSenha(String senhaDigitada, String senhaCriptografada) {
        return CriptografiaService.verificarSenha(senhaDigitada, senhaCriptografada);
    }

}
