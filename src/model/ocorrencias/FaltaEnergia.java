package model.ocorrencias;

import abstracts.Ocorrencia;

public class FaltaEnergia extends Ocorrencia {
    private int clientesAfetados;

    public FaltaEnergia(String local, String nivelRisco, boolean urgente, int clientesAfetados) {
        super(local, nivelRisco, urgente);
        this.clientesAfetados = clientesAfetados;
    }

    public int getClientesAfetados() {
        return clientesAfetados;
    }

    public void setClientesAfetados(int clientesAfetados) {
        this.clientesAfetados = clientesAfetados;
    }

    @Override
    public String gerarRelatorio() {
        return "Falta de energia #" + getId()
                + " | Local: " + getLocal()
                + " | Risco: " + getNivelRisco()
                + " | Clientes afetados: " + clientesAfetados
                + " | Status: " + getStatus();
    }
}
