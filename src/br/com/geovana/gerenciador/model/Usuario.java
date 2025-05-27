package br.com.geovana.gerenciador.model;

// Classe responsável por representar o usuário do sistema

public class Usuario {
    private String nome;
    private String email;

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Usuário: " + nome + " | Email: " + email;
    }
}
