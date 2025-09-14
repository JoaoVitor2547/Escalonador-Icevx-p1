import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeitorDeProcessos {

    public static void carregarArquivo(String caminho, Scheduler Scheduler) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length < 5) continue;

                int id = Integer.parseInt(partes[0]);
                String nome = partes[1];
                int prioridade = Integer.parseInt(partes[2]);
                int ciclos = Integer.parseInt(partes[3]);
                String recurso = partes[4].equals("-") ? null : partes[4];

                Processo p = new Processo(id, nome, prioridade, ciclos, recurso, false);
                Scheduler.adicionarProcesso(p);
            }
            System.out.println("Processos carregados com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
