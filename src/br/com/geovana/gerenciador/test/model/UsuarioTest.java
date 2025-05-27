package br.com.geovana.gerenciador.test.model;

import br.com.geovana.gerenciador.model.Usuario;

public class UsuarioTest {
    public static void main(String[] args) {
        System.out.println("Iniciando teste da classe Usuario...\n");

        Usuario usuario = new Usuario("Geovana", "geovana@email.com");

        System.out.println("Nome esperado: Geovana | Nome obtido: " + usuario.getNome());
        System.out.println("Email esperado: geovana@email.com | Email obtido: " + usuario.getEmail());

        System.out.println("\nTestando toString:");
        System.out.println("Saída esperada: Usuário: Geovana | Email: geovana@email.com");
        System.out.println("Saída obtida: " + usuario.toString());
    }
}
