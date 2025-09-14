public class NodeDuplo {
    Processo processo;
    NodeDuplo next;
    NodeDuplo before;

    public NodeDuplo(Processo processo) {
        this.processo = processo;
        this.next = null;
        this.before = null;
    }
}
