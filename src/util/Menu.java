package util;

import abstracts.Ocorrencia;
import service.OcorrenciaService;
import service.RelatorioService;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private OcorrenciaService ocorrenciaService;
    private RelatorioService relatorioService;
    private Scanner scanner;

    public Menu(OcorrenciaService ocorrenciaService, RelatorioService relatorioService) {
        this.ocorrenciaService = ocorrenciaService;
        this.relatorioService = relatorioService;
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

    //menu
    private void imprimirOpcoes() {
        System.out.println("\n=== SmartCity Alert ----");
        System.out.println("1 - Registrar ocorrencia");
        System.out.println("2 - Listar ocorrencias");
        System.out.println("3 - Resolver ocorrencia");
        System.out.println("4 - Gerar relatorio");
        System.out.println("5 - Sair");
    }


    //executando opção
    private void executarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                registrarOcorrencia();
                break;
            case 2:
                listarOcorrencias();
                break;
            case 3:
                resolverOcorrencia();
                break;
            case 4:
                relatorioService.gerarRelatorioGeral(ocorrenciaService.listarOcorrencias());
                break;
            case 5:
                System.out.println("Encerrando o SmartCity Alert.");
                break;
            default:
                System.out.println("Opcao invalida. Tente novamente.");
                break;
        }
    }

    private void registrarOcorrencia() {
        System.out.println("\nTipo de ocorrencia:");
        System.out.println("1 - Enchente");
        System.out.println("2 - Falta de energia");
        System.out.println("3 - Transito");

        int tipo = lerInteiro("Escolha o tipo: ");
        String local = lerTexto("Local: ");
        String risco = lerTexto("Nivel de risco (Baixo, Medio, Alto, Critico): ");
        boolean urgente = lerBooleano("Ocorrencia urgente? (s/n): ");

        switch (tipo) {
            case 1:
                double nivelAgua = lerDouble("Nivel da agua em metros: ");
                ocorrenciaService.cadastrarEnchente(local, risco, urgente, nivelAgua);
                break;
            case 2:
                int clientesAfetados = lerInteiro("Quantidade de clientes afetados: ");
                ocorrenciaService.cadastrarFaltaEnergia(local, risco, urgente, clientesAfetados);
                break;
            case 3:
                String tipoBloqueio = lerTexto("Tipo de bloqueio: ");
                ocorrenciaService.cadastrarTransito(local, risco, urgente, tipoBloqueio);
                break;
            default:
                System.out.println("Tipo invalido. Ocorrencia nao cadastrada.");
                return;
        }

        System.out.println("Ocorrencia cadastrada com sucesso.");
    }

    private void listarOcorrencias() {
        List<Ocorrencia> ocorrencias = ocorrenciaService.listarOcorrencias();

        if (ocorrencias.isEmpty()) {
            System.out.println("Nenhuma ocorrencia cadastrada.");
            return;
        }

        System.out.println("\n--- Ocorrencias cadastradas ---");
        for (Ocorrencia ocorrencia : ocorrencias) {
            System.out.println(ocorrencia.gerarRelatorio());
        }
    }

    private void resolverOcorrencia() {
        int id = lerInteiro("Informe o ID da ocorrencia: ");
        boolean resolvida = ocorrenciaService.resolverOcorrencia(id);

        if (resolvida) {
            System.out.println("Ocorrencia resolvida com sucesso.");
        } else {
            System.out.println("Ocorrencia nao encontrada.");
        }
    }

    private String lerTexto(String mensagem) {
        System.out.print(mensagem);
        String valor = scanner.nextLine().trim();

        while (valor.isEmpty()) {
            System.out.println("Valor obrigatorio.");
            System.out.print(mensagem);
            valor = scanner.nextLine().trim();
        }

        return valor;
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

    private double lerDouble(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine().trim().replace(",", ".");

            try {
                return Double.parseDouble(entrada);
            } catch (NumberFormatException exception) {
                System.out.println("Digite um numero decimal valido.");
            }
        }
    }

    private boolean lerBooleano(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine().trim();

            if ("s".equalsIgnoreCase(entrada) || "sim".equalsIgnoreCase(entrada)) {
                return true;
            }

            if ("n".equalsIgnoreCase(entrada) || "nao".equalsIgnoreCase(entrada)) {
                return false;
            }

            System.out.println("Digite s para sim ou n para nao.");
        }
    }
}
