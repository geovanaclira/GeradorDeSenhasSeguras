package br.com.geovana.gerenciador.test.service;

import br.com.geovana.gerenciador.model.Credencial;
import br.com.geovana.gerenciador.repository.ArquivoRepository;
import br.com.geovana.gerenciador.repository.CredencialRepository;
import br.com.geovana.gerenciador.service.AutenticacaoService;
import br.com.geovana.gerenciador.service.CriptografiaService;

public class AutenticacaoServiceTest {
    public static void main(String[] args) {
        // Criar o repositório e adicionar uma credencial com senha criptografada
        CredencialRepository repo = new ArquivoRepository("credenciais.txt");
        String senhaOriginal = "1234";
        String senhaCriptografada = CriptografiaService.gerarHash(senhaOriginal);
        Credencial admin = new Credencial("PainelAdmin", "admin", senhaCriptografada);
        repo.adicionar(admin);

        // Instanciar o serviço de autenticação
        AutenticacaoService auth = new AutenticacaoService(repo);

        System.out.println("Testando autenticação com dados corretos:");
        boolean resultado1 = auth.autenticar("admin", "1234");
        System.out.println("Esperado: true | Resultado: " + resultado1);

        System.out.println("\nTestando autenticação com senha incorreta:");
        boolean resultado2 = auth.autenticar("admin", "senhaErrada");
        System.out.println("Esperado: false | Resultado: " + resultado2);

        System.out.println("\nTestando autenticação com usuário incorreto:");
        boolean resultado3 = auth.autenticar("usuarioErrado", "1234");
        System.out.println("Esperado: false | Resultado: " + resultado3);

        System.out.println("\nTestando autenticação com ambos incorretos:");
        boolean resultado4 = auth.autenticar("usuarioErrado", "senhaErrada");
        System.out.println("Esperado: false | Resultado: " + resultado4);
    }
}
