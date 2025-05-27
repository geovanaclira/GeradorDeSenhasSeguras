package br.com.geovana.gerenciador.test.util;

import br.com.geovana.gerenciador.util.GeradorSenhaUtil;

public class GeradorSenhaUtilTest {
    public static void main(String[] args) {
        System.out.println("Teste do GeradorSenhaUtil\n");

        String senha1 = GeradorSenhaUtil.gerarSenha();
        String senha2 = GeradorSenhaUtil.gerarSenha();

        System.out.println("Senha 1: " + senha1);
        System.out.println("Senha 2: " + senha2);

        System.out.println("\nTestando características:");
        System.out.println("Comprimento esperado: 12 | Senha 1: " + senha1.length() + " | Senha 2: " + senha2.length());
        System.out.println("Senhas são diferentes entre si? " + !senha1.equals(senha2));
    }
}
