package src;
public class ListaDuplamente {
    private NodeDuplo head;
    private NodeDuplo tail;
    private int tamanho;

    public ListaDuplamente() {
        head = null;
        tail = null;
        tamanho = 0;
    }

    public boolean estaVazia() {
        return head == null;
    }

    public void inserirNoFim(Processo p) {
        NodeDuplo novo = new NodeDuplo(p);
        if (estaVazia()) {
            head = novo;
            tail = novo;
        } else {
            tail.next = novo;
            novo.before = tail;
            tail = novo;
        }
        tamanho++;
    }

    public Processo removerDoInicio() {
        if (estaVazia())
            return null;
        Processo p = head.processo;
        head = head.next;
        if (head != null)
            head.before = null;
        else
            tail = null;
        tamanho--;
        return p;
    }

    public void imprimirLista(String nomeLista) {
        System.out.print(nomeLista + ": ");
        if (estaVazia()) {
            System.out.println("[Lista vazia] (Tamanho: 0)");
            return;
        }
        NodeDuplo atual = head;
        while (atual != null) {
            System.out.print(atual.processo + " <-> ");
            atual = atual.next;
        }
        System.out.println("null (Tamanho: " + tamanho + ")");
    }
}