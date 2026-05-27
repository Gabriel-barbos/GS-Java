package service;

import abstracts.Ocorrencia;
import model.infraestrutura.Sensor;
import model.ocorrencias.Enchente;
import model.ocorrencias.FaltaEnergia;
import model.ocorrencias.Transito;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OcorrenciaService {
    private List<Ocorrencia> ocorrencias;
    private Sensor sensorCentral;

    public OcorrenciaService() {
        this.ocorrencias = new ArrayList<>();
        this.sensorCentral = new Sensor("SC-001", "Central SmartCity");
    }

    public void cadastrarOcorrencia(String local) {
        cadastrarOcorrencia(local, "Baixo", false);
    }

    public void cadastrarOcorrencia(String local, String risco) {
        cadastrarOcorrencia(local, risco, false);
    }

    public void cadastrarOcorrencia(String local, String risco, boolean urgente) {
        cadastrarOcorrencia(new Transito(local, risco, urgente, "Fluxo lento"));
    }

    public void cadastrarOcorrencia(Ocorrencia ocorrencia) {
        ocorrencias.add(ocorrencia);

        if (ocorrencia.isUrgente() || "critico".equalsIgnoreCase(ocorrencia.getNivelRisco())) {
            sensorCentral.enviarNotificacao("Ocorrencia critica registrada em " + ocorrencia.getLocal());
        }
    }

    public void cadastrarEnchente(String local, String risco, boolean urgente, double nivelAgua) {
        cadastrarOcorrencia(new Enchente(local, risco, urgente, nivelAgua));
    }

    public void cadastrarFaltaEnergia(String local, String risco, boolean urgente, int clientesAfetados) {
        cadastrarOcorrencia(new FaltaEnergia(local, risco, urgente, clientesAfetados));
    }

    public void cadastrarTransito(String local, String risco, boolean urgente, String tipoBloqueio) {
        cadastrarOcorrencia(new Transito(local, risco, urgente, tipoBloqueio));
    }

    public List<Ocorrencia> listarOcorrencias() {
        return Collections.unmodifiableList(ocorrencias);
    }

    public Ocorrencia buscarPorId(int id) {
        for (Ocorrencia ocorrencia : ocorrencias) {
            if (ocorrencia.getId() == id) {
                return ocorrencia;
            }
        }

        return null;
    }

    public boolean resolverOcorrencia(int id) {
        Ocorrencia ocorrencia = buscarPorId(id);

        if (ocorrencia == null) {
            return false;
        }

        ocorrencia.resolver();
        return true;
    }
}
