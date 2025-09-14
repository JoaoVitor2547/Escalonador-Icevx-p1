public class Main {
    public static void main(String[] args) {
        Scheduler Scheduler = new Scheduler();

        // Carrega os processos do arquivo CSV
        LeitorDeProcessos.carregarArquivo("processos.csv", Scheduler);

        // Executa 15 ciclos de CPU
        for (int i = 0; i < 15; i++) {
            System.out.println("\n=== CICLO " + (i+1) + " ===");
            Scheduler.executarCicloDeCPU();
            Scheduler.mostrarEstado();
        }
    }
}

