package br.com.geovana.gerenciador.model;
// Classe responsável por armazenar os dados de login e senha de um serviço

public class Credencial {
    private String servico;
    private String usuario;
    private String senhaCriptografada;

    public Credencial(String servico, String usuario, String senhaCriptografada) {
        this.servico = servico;
        this.usuario = usuario;
        this.senhaCriptografada = senhaCriptografada;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenhaCriptografada() {
        return senhaCriptografada;
    }

    public void setSenhaCriptografada(String senhaCriptografada) {
        this.senhaCriptografada = senhaCriptografada;
    }

    // Metodo para exibir os dados da credencial de maneira legível — sem mostrar a senha real
    @Override
    public String toString() {
        return "Serviço: " + servico + "\n" +
                "Usuário: " + usuario + "\n" +
                "Senha (criptografada): " + senhaCriptografada;
    }
}
