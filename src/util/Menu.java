package util;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public void exibir() {
        int opcao;

        do {
            imprimirOpcoes();
            opcao = lerInteiro("Escolha uma opcao: ");
            executarOpcao(opcao);
        } while (opcao != 5);
    }

    private void imprimirOpcoes() {
        System.out.println("\n=== SmartCity Alert ===");
        System.out.println("1 - Registrar ocorrencia");
        System.out.println("2 - Listar ocorrencias");
        System.out.println("3 - Resolver ocorrencia");
        System.out.println("4 - Gerar relatorio");
        System.out.println("5 - Sair");
    }

    private void executarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                System.out.println("Funcionalidade de cadastro em desenvolvimento.");
                break;
            case 2:
                System.out.println("Funcionalidade de listagem em desenvolvimento.");
                break;
            case 3:
                System.out.println("Funcionalidade de resolucao em desenvolvimento.");
                break;
            case 4:
                System.out.println("Funcionalidade de relatorio em desenvolvimento.");
                break;
            case 5:
                System.out.println("Encerrando o SmartCity Alert.");
                break;
            default:
                System.out.println("Opcao invalida. Tente novamente.");
                break;
        }
    }

    private int lerInteiro(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine().trim();

            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException exception) {
                System.out.println("Digite um numero inteiro valido.");
            }
        }
    }
}
