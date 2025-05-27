package br.com.geovana.gerenciador.test.model;

import br.com.geovana.gerenciador.model.Credencial;

public class CredencialTest {
    public static void main(String[] args) {
        // Criando uma credencial de exemplo
        Credencial credencial = new Credencial("Gmail", "geovana@gmail.com", "senhaCriptografada123");

        // Testando os métodos getters
        System.out.println("Serviço: " + credencial.getServico());
        System.out.println("Usuário: " + credencial.getUsuario());
        System.out.println("Senha Criptografada: " + credencial.getSenhaCriptografada());

        // Testando os métodos setters
        credencial.setServico("Instagram");
        credencial.setUsuario("geovana@insta.com");
        credencial.setSenhaCriptografada("novaSenhaCriptografada456");

        // Imprimindo novamente após alteração
        System.out.println("\n--- Após alteração ---");
        System.out.println("Serviço: " + credencial.getServico());
        System.out.println("Usuário: " + credencial.getUsuario());
        System.out.println("Senha Criptografada: " + credencial.getSenhaCriptografada());

        // Testando o método toString()
        System.out.println("\nRepresentação toString:");
        System.out.println(credencial);
    }
}
