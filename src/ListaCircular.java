package src;
public class ListaCircular {
    private Node atual;
    private int tamanho;

    public ListaCircular() {
        atual = null;
        tamanho = 0;
    }

    public boolean estaVazia() {
        return atual == null;
    }

    public void inserir(Processo p) {
        Node novo = new Node(p);
        if (atual == null) {
            atual = novo;
            atual.next = atual;
        } else {
            novo.next = atual.next;
            atual.next = novo;
        }
        tamanho++;
    }

    public Processo proximo() {
        if (estaVazia()) return null;
        atual = atual.next;
        return atual.processo;
    }

    public void remover(Processo p) {
        if (estaVazia()) return;
        Node before = atual;
        Node curr = atual.next;
        for (int i = 0; i < tamanho; i++) {
            if (curr.processo == p) {
                before.next = curr.next;
                if (curr == atual) atual = before;
                tamanho--;
                if (tamanho == 0) atual = null;
                return;
            }
            before = curr;
            curr = curr.next;
        }
    }

    public void imprimirLista(String nomeLista) {
        System.out.print(nomeLista + ": ");
        if (estaVazia()) {
            System.out.println("[Lista vazia] (Tamanho: 0)");
            return;
        }
        Node start = atual;
        Node curr = atual.next;
        do {
            System.out.print(curr.processo + " -> ");
            curr = curr.next;
        } while (curr != start.next);
        System.out.println("(circular, Tamanho: " + tamanho + ")");
    }
}