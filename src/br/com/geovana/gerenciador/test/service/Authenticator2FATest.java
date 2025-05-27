package br.com.geovana.gerenciador.test.service;

import br.com.geovana.gerenciador.service.Authenticator2FA;

public class Authenticator2FATest {
    public static void main(String[] args) {
        System.out.println("Testando autenticação 2FA:");
        boolean sucesso = Authenticator2FA.autenticar();

        if (sucesso) {
            System.out.println("Autenticação bem-sucedida.");
        } else {
            System.out.println("Autenticação falhou.");
        }
    }
}
