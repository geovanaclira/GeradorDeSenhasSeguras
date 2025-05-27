package br.com.geovana.gerenciador.util;

import java.security.SecureRandom;

// Classe que gera senhas aleatórias e seguras
public class GeradorSenhaUtil {
    private static final String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%&*";
    private static final int TAMANHO_PADRAO = 12;
    private static final SecureRandom random = new SecureRandom();

    public static String gerarSenha() {
        StringBuilder senha = new StringBuilder();
        for (int i = 0; i < TAMANHO_PADRAO; i++) {
            int index = random.nextInt(CARACTERES.length());
            senha.append(CARACTERES.charAt(index));
        }
        return senha.toString();
    }
}
