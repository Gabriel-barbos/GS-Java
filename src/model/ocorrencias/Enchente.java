package model.ocorrencias;

import abstracts.Ocorrencia;

public class Enchente extends Ocorrencia {
    private double nivelAgua;

    public Enchente(String local, String nivelRisco, boolean urgente, double nivelAgua) {
        super(local, nivelRisco, urgente);
        this.nivelAgua = nivelAgua;
    }

    public double getNivelAgua() {
        return nivelAgua;
    }

    public void setNivelAgua(double nivelAgua) {
        this.nivelAgua = nivelAgua;
    }

    @Override
    public String gerarRelatorio() {
        return "Enchente #" + getId()
                + " | Local: " + getLocal()
                + " | Risco: " + getNivelRisco()
                + " | Nivel da agua: " + nivelAgua + "m"
                + " | Status: " + getStatus();
    }
}
