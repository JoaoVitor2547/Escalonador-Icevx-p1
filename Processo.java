public class Processo{
    int id;
    String nome;
    int prioridade; // 1 = Alta, 2 = Média, 3 = Baixa
    int ciclosNecessarios;
    String recursosNecessarios;
    public boolean jaBloqueado;
    int prioridadeOriginal; 

    public Processo(int id, String nome, int prioridade, int ciclosNecessarios, String recursosNecessarios, boolean jaBloqueado) {
        this.id = id;
        this.nome = nome;
        this.prioridade = prioridade;
        this.ciclosNecessarios = ciclosNecessarios;
        this.recursosNecessarios = recursosNecessarios;
        this.jaBloqueado = jaBloqueado;
        this.prioridadeOriginal = prioridade; 
    }

    @Override
    public String toString() {
        return "[P" + id + " - " + nome + " | Prioridade: " + prioridade + " | Ciclos: " + ciclosNecessarios + "]";
    }
}

