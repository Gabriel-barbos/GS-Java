package app;

import service.OcorrenciaService;
import service.RelatorioService;
import util.Menu;

public class Main {
    public static void main(String[] args) {
        OcorrenciaService ocorrenciaService = new OcorrenciaService();
        RelatorioService relatorioService = new RelatorioService();
        Menu menu = new Menu(ocorrenciaService, relatorioService);

        menu.exibir();
    }
}
