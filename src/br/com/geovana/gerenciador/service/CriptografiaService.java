package br.com.geovana.gerenciador.service;

// Classe que cuida da criptografia
import org.mindrot.jbcrypt.BCrypt;

public class CriptografiaService {
    // Gera um hash seguro da senha usando BCrypt
    public static String gerarHash(String senha) {
        try {
            return BCrypt.hashpw(senha, BCrypt.gensalt(12));
        } catch (Exception e) {
            System.err.println("Erro ao gerar hash com BCrypt: " + e.getMessage());
            return null;
        }
    }

    // Compara uma senha com um hash existente
    public static boolean verificarSenha(String senha, String hash) {
        try {
            return BCrypt.checkpw(senha, hash);
        } catch (Exception e) {
            System.err.println("Erro ao verificar hash com BCrypt: " + e.getMessage());
            return false;
        }
    }
}
