public class Main {
    public static void main(String[] args) {
        System.out.println("Simulador de Escalonamento de Processos - Lista Encadeada");
    }
}
public class Main {
    public static void main(String[] args) {
        Controlador controlador = new Controlador();

        // Lê os processos do arquivo CSV
        LeitorDeProcessos.carregarArquivo("processos.csv", controlador);

        // Executa 10 ciclos de CPU para teste
        for (int i = 0; i < 10; i++) {
            System.out.println("\n--- CICLO " + (i+1) + " ---");
            controlador.executarCicloDeCPU();
            controlador.mostrarEstado();
        }
    }
}
