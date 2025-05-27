package br.com.geovana.gerenciador.test.util;

import br.com.geovana.gerenciador.util.VerificadorVazamentoUtil;

public class VerificadorVazamentoUtilTest {
    public static void main(String[] args) {
        String senhaVazada = "123456"; // Essa senha certamente está vazada
        String senhaSegura = "SenhaUnicaSegura2025!@#"; // Pouco provável de estar vazada

        System.out.println("Verificando se a senha '123456' foi vazada:");
        System.out.println("Resultado: " + VerificadorVazamentoUtil.senhaFoiVazada(senhaVazada));

        System.out.println("\nVerificando se a senha segura foi vazada:");
        System.out.println("Resultado: " + VerificadorVazamentoUtil.senhaFoiVazada(senhaSegura));
    }
}
