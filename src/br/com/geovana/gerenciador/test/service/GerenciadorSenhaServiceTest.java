package br.com.geovana.gerenciador.test.service;

import br.com.geovana.gerenciador.model.Credencial;
import br.com.geovana.gerenciador.service.GerenciadorSenhaService;

import java.util.List;

public class GerenciadorSenhaServiceTest {
    public static void main(String[] args) {
        GerenciadorSenhaService service = new GerenciadorSenhaService();

        System.out.println("Adicionando credenciais:");
        service.adicionar("Gmail", "joao@gmail.com", "minhaSenha123");
        service.adicionar("Facebook", "joao.fb", "outraSenha456");

        System.out.println("\n Listando todas:");
        List<Credencial> lista = service.listarTodas();
        for (Credencial c : lista) {
            System.out.println("Serviço: " + c.getServico() + ", Usuário: " + c.getUsuario() + ", Senha (criptografada): " + c.getSenhaCriptografada());
        }

        System.out.println("\n🔍 Buscando credencial para 'Gmail':");
        Credencial gmail = service.buscar("Gmail");
        if (gmail != null) {
            System.out.println("Encontrado: " + gmail.getUsuario() + " | Senha: " + gmail.getSenhaCriptografada());
        } else {
            System.out.println("Não encontrado.");
        }

        System.out.println("\n Removendo 'Facebook':");
        boolean removido = service.remover("Facebook");
        System.out.println("Remoção bem-sucedida? " + removido);

        System.out.println("\n Listando novamente após remoção:");
        lista = service.listarTodas();
        for (Credencial c : lista) {
            System.out.println("Serviço: " + c.getServico() + ", Usuário: " + c.getUsuario() + ", Senha (criptografada): " + c.getSenhaCriptografada());
        }
    }
}
