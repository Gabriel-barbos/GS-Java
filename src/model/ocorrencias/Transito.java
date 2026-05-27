package model.ocorrencias;

import abstracts.Ocorrencia;

public class Transito extends Ocorrencia {
    private String tipoBloqueio;

    public Transito(String local, String nivelRisco, boolean urgente, String tipoBloqueio) {
        super(local, nivelRisco, urgente);
        this.tipoBloqueio = tipoBloqueio;
    }

    public String getTipoBloqueio() {
        return tipoBloqueio;
    }

    public void setTipoBloqueio(String tipoBloqueio) {
        this.tipoBloqueio = tipoBloqueio;
    }

    @Override
    public String gerarRelatorio() {
        return "Transito #" + getId()
                + " | Local: " + getLocal()
                + " | Risco: " + getNivelRisco()
                + " | Bloqueio: " + tipoBloqueio
                + " | Status: " + getStatus();
    }
}
