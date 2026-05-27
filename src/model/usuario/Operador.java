package model.usuario;

public class Operador {
    private String nome;
    private String matricula;

    public Operador(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void exibirIdentificacao() {
        System.out.println("Operador: " + nome + " | Matricula: " + matricula);
    }
}
