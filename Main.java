public class Main {
    public static void main(String[] args) {
        Controlador controlador = new Controlador();

        // Carrega os processos do arquivo CSV
        LeitorDeProcessos.carregarArquivo("processos.csv", controlador);

        // Executa 15 ciclos de CPU
        for (int i = 0; i < 15; i++) {
            System.out.println("\n=== CICLO " + (i+1) + " ===");
            controlador.executarCicloDeCPU();
            controlador.mostrarEstado();
        }
    }
}

