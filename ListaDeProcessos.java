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
    public Processo removerDoInicio() {
        if (estaVazia()) {
            return null;
        }
        Processo p = inicio.processo;
        inicio = inicio.next;
        if (inicio == null) {
            fim = null;
        }
        tamanho--;
        return p;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void imprimirLista(String nomeLista) {
        if (estaVazia()) {
            System.out.println(nomeLista + ": [Lista vazia] (Tamanho: 0)");
            return;
        }
        System.out.print(nomeLista + ": ");
        Node atual = inicio;
        while (atual != null) {
         System.out.print((atual.processo != null ? atual.processo : "null") + " -> ");            
         atual = atual.next;
        }
        System.out.println("null (Tamanho: " + tamanho + ")");
    }
}
