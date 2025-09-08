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
    this.recursosNecessarios = recursosNecessarios;}

    public void imprimir(){
        System.out.println("nome:" + nome + 
                                       ",ID: " + id +
                                       ",Prioridade: " + prioridade +
                                       ",Ciclos: " + ciclosNecessarios +
                                       ",Recurso: " +recursosNecessarios);
    }

}