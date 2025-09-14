public class Processo{
    int id;
    String nome;
    int prioridade;
    int ciclosNecessarios;
    String recursosNecessarios;

    public Processo (int id, String nome, int prioridade, int ciclosNecessarios, String recursosNecessarios){
    this.id = id;
    this.nome = nome;
    this.prioridade = prioridade;
    this.ciclosNecessarios = ciclosNecessarios;
    this.recursosNecessarios = recursosNecessarios;
}
@Override
    public String toString() {
        return "[P" + id + " - " + nome + " | Prioridade: " + prioridade + " | Ciclos: " + ciclosNecessarios + "]";
    }
}

