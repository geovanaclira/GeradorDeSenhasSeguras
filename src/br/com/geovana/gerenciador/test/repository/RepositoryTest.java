package br.com.geovana.gerenciador.test.repository;

import br.com.geovana.gerenciador.model.Credencial;
import br.com.geovana.gerenciador.repository.ArquivoRepository;
import br.com.geovana.gerenciador.repository.CredencialRepository;

import java.util.List;

public class RepositoryTest {
    public static void main(String[] args) {
        CredencialRepository repositorio = new ArquivoRepository("NOME_ARQUIVO");

        // Criando e adicionando duas credenciais
        Credencial c1 = new Credencial("Netflix", "joao@netflix.com", "senha123");
        Credencial c2 = new Credencial("GitHub", "joao@github.com", "senha456");

        repositorio.adicionar(c1);
        repositorio.adicionar(c2);

        // Listando credenciais
        System.out.println("\n--- Todas as credenciais ---");
        List<Credencial> lista = repositorio.listarTodas();
        for (Credencial c : lista) {
            System.out.println(c);
        }

        // Buscando uma específica por serviço
        System.out.println("\n--- Buscar por serviço: GitHub ---");
        Credencial buscada = repositorio.buscar("GitHub");
        System.out.println(buscada != null ? buscada : "Não encontrada");

        // Buscando por usuário
        System.out.println("\n--- Buscar por usuário: joao@netflix.com ---");
        Credencial buscadaUsuario = repositorio.buscarPorUsuario("joao@netflix.com");
        System.out.println(buscadaUsuario != null ? buscadaUsuario : "Não encontrada");

        // Removendo uma credencial
        System.out.println("\n--- Remover serviço: Netflix ---");
        boolean removido = repositorio.remover("Netflix");
        System.out.println(removido ? "Removido com sucesso" : "Não encontrado");

        // Listando após remoção
        System.out.println("\n--- Lista após remoção ---");
        for (Credencial c : repositorio.listarTodas()) {
            System.out.println(c);
        }
    }
}
