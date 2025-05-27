package br.com.geovana.gerenciador.test.service;

import br.com.geovana.gerenciador.service.CriptografiaService;

public class CriptografiaServiceTest {
    public static void main(String[] args) {
        String senhaOriginal = "minhaSenha123";
        String senhaErrada = "senhaIncorreta";

        // Gerar hash (criptografar)
        String hash = CriptografiaService.gerarHash(senhaOriginal);
        System.out.println("Hash gerado (criptografado): " + hash);

        // Teste 1: senha correta
        boolean testeCorreto = CriptografiaService.verificarSenha(senhaOriginal, hash);
        System.out.println("\nTeste com senha correta:");
        System.out.println("Esperado: true | Resultado: " + testeCorreto);

        // Teste 2: senha incorreta
        boolean testeErrado = CriptografiaService.verificarSenha(senhaErrada, hash);
        System.out.println("\nTeste com senha incorreta:");
        System.out.println("Esperado: false | Resultado: " + testeErrado);

        // Teste 3: tentativa de verificar com hash nulo
        System.out.println("\nTeste com hash nulo:");
        boolean testeHashNulo = CriptografiaService.verificarSenha(senhaOriginal, null);
        System.out.println("Esperado: false | Resultado: " + testeHashNulo);

        // Teste 4: tentativa de gerar hash de senha nula
        System.out.println("\nTeste de geração de hash com senha nula:");
        String hashNulo = CriptografiaService.gerarHash(null);
        System.out.println("Esperado: null | Resultado: " + hashNulo);
    }

}
