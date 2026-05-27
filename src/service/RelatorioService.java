package service;

import abstracts.Ocorrencia;

import java.util.List;

public class RelatorioService {
    public void gerarRelatorioGeral(List<Ocorrencia> ocorrencias) {
        int total = ocorrencias.size();
        int criticas = 0;
        int resolvidas = 0;

        for (Ocorrencia ocorrencia : ocorrencias) {
            if ("critico".equalsIgnoreCase(ocorrencia.getNivelRisco()) || ocorrencia.isUrgente()) {
                criticas++;
            }

            if (ocorrencia.isResolvida()) {
                resolvidas++;
            }
        }

        System.out.println("\n--- Relatorio SmartCity Alert ---");
        System.out.println("Total de ocorrencias: " + total);
        System.out.println("Ocorrencias criticas: " + criticas);
        System.out.println("Ocorrencias resolvidas: " + resolvidas);
        System.out.println("Ocorrencias em aberto: " + (total - resolvidas));
    }
}
