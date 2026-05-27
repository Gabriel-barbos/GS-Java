package model.infraestrutura;

import interfaces.Notificavel;

public class Sensor implements Notificavel {
    private String codigo;
    private String local;
    private boolean ativo;

    public Sensor(String codigo, String local) {
        this.codigo = codigo;
        this.local = local;
        this.ativo = true;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public void enviarNotificacao(String mensagem) {
        if (ativo) {
            System.out.println("[ALERTA - Sensor " + codigo + " / " + local + "] " + mensagem);
        } else {
            System.out.println("Sensor " + codigo + " inativo. Notificacao nao enviada.");
        }
    }
}
