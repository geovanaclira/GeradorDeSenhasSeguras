package br.com.geovana.gerenciador.service;

// Classe responsável por gerar o código de Autenticação

import java.util.Random;
import java.util.Scanner;

public class Authenticator2FA {
    public static boolean autenticar() {
        String codigo = gerarCodigo();
        System.out.println("Seu código de autenticação é: " + codigo);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o código enviado: ");
        String entrada = scanner.nextLine();

        return codigo.equals(entrada);
    }

    private static String gerarCodigo() {
        Random random = new Random();
        int codigo = 100000 + random.nextInt(900000); // Gera um número de 6 dígitos
        return String.valueOf(codigo);
    }
}
