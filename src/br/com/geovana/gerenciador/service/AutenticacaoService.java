package br.com.geovana.gerenciador.service;

// Classe responsável por autenticar o usuário com senha + 2FA

import br.com.geovana.gerenciador.model.Credencial;
import br.com.geovana.gerenciador.repository.CredencialRepository;


public class AutenticacaoService {
    private CredencialRepository repository;

    public AutenticacaoService(CredencialRepository repository) {
        this.repository = repository;
    }

    public boolean autenticar(String usuario, String senhaDigitada) {
        Credencial credencial = repository.buscarPorUsuario(usuario);

        if (credencial == null) {
            System.out.println("Usuário não encontrado.");
            return false;
        }

        String hashSalvo = credencial.getSenhaCriptografada(); // formato BCrypt
        boolean senhaValida = CriptografiaService.verificarSenha(senhaDigitada, hashSalvo);

        if (!senhaValida) {
            System.out.println("Senha incorreta.");
        }

        return senhaValida;
    }
}
