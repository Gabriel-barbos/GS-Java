package abstracts;

public abstract class Ocorrencia {
    private static int proximoId = 1;

    private int id;
    private String local;
    private String nivelRisco;
    private boolean resolvida;
    private boolean urgente;

    public Ocorrencia(String local, String nivelRisco, boolean urgente) {
        this.id = proximoId++;
        this.local = local;
        this.nivelRisco = nivelRisco;
        this.urgente = urgente;
        this.resolvida = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getNivelRisco() {
        return nivelRisco;
    }

    public void setNivelRisco(String nivelRisco) {
        this.nivelRisco = nivelRisco;
    }

    public boolean isResolvida() {
        return resolvida;
    }

    public void setResolvida(boolean resolvida) {
        this.resolvida = resolvida;
    }

    public boolean isUrgente() {
        return urgente;
    }

    public void setUrgente(boolean urgente) {
        this.urgente = urgente;
    }

    public String getStatus() {
        return resolvida ? "Resolvida" : "Aberta";
    }

    public void resolver() {
        this.resolvida = true;
    }

    public abstract String gerarRelatorio();
}
