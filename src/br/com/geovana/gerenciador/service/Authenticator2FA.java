package br.com.geovana.gerenciador.service;

// Classe responsável por gerar o código de Autenticação

import java.util.Random;
import java.util.Scanner;

public class Authenticator2FA {
    public static boolean autenticar() {
        String codigo = gerarCodigo();
        Scanner scanner = new Scanner(System.in);
        int tentativas = 3;

        while (tentativas > 0) {
            System.out.println("Seu código de autenticação é: " + codigo);
            System.out.print("Digite o código: ");
            String entrada = scanner.nextLine();

            if (entrada.isEmpty()) {
                System.out.println("Código não pode estar vazio. Tente novamente.");
                continue; // Não consome tentativa
            }

            if (codigo.equals(entrada)) {
                System.out.println("Autenticação bem-sucedida.");
                return true;
            } else {
                tentativas--;
                System.out.println("Código incorreto. Tentativas restantes: " + tentativas);
            }
        }

        System.out.println("Acesso negado. Número de tentativas excedido.");
        return false;
    }

    private static String gerarCodigo() {
        Random random = new Random();
        int codigo = 100000 + random.nextInt(900000); // Gera um número de 6 dígitos
        return String.valueOf(codigo);
    }
}
