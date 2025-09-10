public class ListaDeProcessos {
    private Node inicio;
    private Node fim;
    private int tamanho;

    public ListaDeProcessos() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public boolean estaVazia() {
        return inicio == null;
    }

    public void inserirNoFim(Processo processo) {
        Node novo = new Node(processo);
        if (estaVazia()) {
            inicio = novo;
            fim = novo;
        } else {
            fim.next = novo;
            fim = novo;
        }
        tamanho++;
    }
    
}

