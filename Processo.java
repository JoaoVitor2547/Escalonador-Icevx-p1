public class Processo{
    int id;
    String nome;
    int prioridade;
    int ciclosNecessarios;
    String recursosNecessarios;
    public boolean jaBloqueado;

    public Processo (int id, String nome, int prioridade, int ciclosNecessarios, String recursosNecessarios){
    this.id = id;
    this.nome = nome;
    this.prioridade = prioridade;
    this.ciclosNecessarios = ciclosNecessarios;
    this.recursosNecessarios = recursosNecessarios;
    this.jaBloqueado = jaBloqueado;
}
@Override
    public String toString() {
        return "[P" + id + " - " + nome + " | Prioridade: " + prioridade + " | Ciclos: " + ciclosNecessarios + "]";
    }
}

