package br.com.geovana.gerenciador.util;

// Classe que verifica se uma senha foi exposta em vazamentos (usando API externa)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;

public class VerificadorVazamentoUtil {
    public static boolean senhaFoiVazada(String senha) {
        try {
            String hash = gerarSHA1(senha).toUpperCase();
            String prefixo = hash.substring(0, 5);
            String sufixo = hash.substring(5);

            URL url = new URL("https://api.pwnedpasswords.com/range/" + prefixo);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (linha.startsWith(sufixo)) {
                    reader.close();
                    return true; // senha foi vazada
                }
            }

            reader.close();
        } catch (java.net.UnknownHostException e) {
            System.err.println("Sem conexão com a internet. Não foi possível verificar vazamento.");
            return false; // assume que não foi vazada para não bloquear o usuário
        } catch (Exception e) {
            System.err.println("Erro ao verificar vazamento: " + e.getMessage());
        }

        return false; // senha não encontrada nos vazamentos
    }

    private static String gerarSHA1(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] hashBytes = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar SHA-1", e);
        }
    }

    private static boolean temConexaoInternet() {
        try {
            URL url = new URL("https://www.google.com/");
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setConnectTimeout(3000);
            conexao.connect();
            return conexao.getResponseCode() == 200;
        } catch (Exception e) {
            return false;
        }
    }
}
