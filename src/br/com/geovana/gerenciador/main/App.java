package br.com.geovana.gerenciador.main;

//Classe principal da Aplicação

import br.com.geovana.gerenciador.model.Credencial;
import br.com.geovana.gerenciador.service.GerenciadorSenhaService;
import br.com.geovana.gerenciador.util.VerificadorVazamentoUtil;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {
    private static final String CODIGO_2FA = gerarCodigo2FA();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorSenhaService gerenciador = new GerenciadorSenhaService();

        System.out.println("Bem-vindo ao Gerenciador de Senhas Seguras!");

        // 2FA SIMPLES
        System.out.println("Código de autenticação (2FA): " + CODIGO_2FA);
        System.out.print("Digite o código de autenticação: ");
        String codigoDigitado = scanner.nextLine();

        if (!codigoDigitado.equals(CODIGO_2FA)) {
            System.out.println("Código incorreto. Acesso negado!");
            return;
        }

        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Cadastrar nova credencial");
            System.out.println("2. Buscar credencial por serviço");
            System.out.println("3. Remover credencial");
            System.out.println("4. Listar todas as credenciais");
            System.out.println("5. Gerar senha segura");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // consumir quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome do serviço: ");
                    String servico = scanner.nextLine();
                    System.out.print("Nome de usuário: ");
                    String usuario = scanner.nextLine();
                    System.out.print("Senha: ");
                    String senha = scanner.nextLine();

                    // Verifica se a senha já foi vazada
                    if (VerificadorVazamentoUtil.senhaFoiVazada(senha)) {
                        System.out.println("Atenção: Essa senha já foi encontrada em vazamentos de dados.");
                        System.out.print("Deseja continuar mesmo assim? (s/n): ");
                        String resposta = scanner.nextLine();
                        if (resposta.equalsIgnoreCase("n")) {
                            System.out.println("Cadastro cancelado.");
                            break;
                        }
                    }

                    gerenciador.adicionar(servico, usuario, senha);
                    System.out.println("Credencial adicionada com sucesso.");
                    break;

                case 2:
                    System.out.print("Nome do serviço: ");
                    String nomeBusca = scanner.nextLine();
                    Credencial encontrada = gerenciador.buscar(nomeBusca);
                    if (encontrada != null) {
                        System.out.println("Usuário: " + encontrada.getUsuario());
                        System.out.println("Senha criptografada: " + encontrada.getSenhaCriptografada());
                    } else {
                        System.out.println("Credencial não encontrada.");
                    }
                    break;

                case 3:
                    System.out.print("Nome do serviço a remover: ");
                    String nomeRemover = scanner.nextLine();
                    boolean removido = gerenciador.remover(nomeRemover);
                    if (removido) {
                        System.out.println("Credencial removida com sucesso.");
                    } else {
                        System.out.println("Credencial não encontrada.");
                    }
                    break;

                case 4:
                    List<Credencial> todas = gerenciador.listarTodas();
                    if (todas.isEmpty()) {
                        System.out.println("Nenhuma credencial salva.");
                    } else {
                        System.out.println("Credenciais salvas:");
                        for (Credencial c : todas) {
                            System.out.println("Serviço: " + c.getServico());
                            System.out.println("Usuário: " + c.getUsuario());
                            System.out.println("Senha criptografada: " + c.getSenhaCriptografada());
                            System.out.println("-----------");
                        }
                    }
                    break;

                case 5:
                    String senhaSegura = gerarSenhaSegura(12);
                    System.out.println("Senha sugerida: " + senhaSegura);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }

    // Geração de código 2FA simples
    private static String gerarCodigo2FA() {
        Random random = new Random();
        int codigo = 100000 + random.nextInt(900000);
        return String.valueOf(codigo);
    }

    // Gerador de senha segura aleatória
    private static String gerarSenhaSegura(int tamanho) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%&*";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }
}


