package src;
public class Scheduler {
    private ListaDeProcessos lista_alta_prioridade = new ListaDeProcessos();
    private ListaDeProcessos lista_media_prioridade = new ListaDeProcessos();
    private ListaDeProcessos lista_baixa_prioridade = new ListaDeProcessos();
    private ListaDeProcessos lista_bloqueados = new ListaDeProcessos();
    private int contador_ciclos_alta_prioridade = 0;

    // Adiciona processo na lista correspondente
    public void adicionarProcesso(Processo p) {
        if (p.prioridade == 1) {
            lista_alta_prioridade.inserirNoFim(p);
        } else if (p.prioridade == 2) {
            lista_media_prioridade.inserirNoFim(p);
        } else {
            lista_baixa_prioridade.inserirNoFim(p);
        }
    }

    // Executa um ciclo de CPU
    public void executarCicloDeCPU() {
        // 1. Desbloquear processo, se houver
        Processo desbloqueado = lista_bloqueados.removerDoInicio();
        if (desbloqueado != null) {
            System.out.println("Desbloqueando " + desbloqueado);
            desbloqueado.jaBloqueado = true;
            desbloqueado.prioridade = desbloqueado.prioridadeOriginal;

            // volta para a lista da prioridade original
            if (desbloqueado.prioridadeOriginal == 1) {
                lista_alta_prioridade.inserirNoFim(desbloqueado);
            } else if (desbloqueado.prioridadeOriginal == 2) {
                lista_media_prioridade.inserirNoFim(desbloqueado);
            } else {
                lista_baixa_prioridade.inserirNoFim(desbloqueado);
            }
        }

        // 2. Escolher próximo processo
        Processo atual = null;

        // Regra de prevenção de inanição
        if (contador_ciclos_alta_prioridade >= 5) {
            atual = lista_media_prioridade.removerDoInicio();
            if (atual == null) {
                atual = lista_baixa_prioridade.removerDoInicio();
            }
            contador_ciclos_alta_prioridade = 0;
        }

        // Execução padrão
        if (atual == null) {
            if (!lista_alta_prioridade.estaVazia()) {
                atual = lista_alta_prioridade.removerDoInicio();
                contador_ciclos_alta_prioridade++;
            } else if (!lista_media_prioridade.estaVazia()) {
                atual = lista_media_prioridade.removerDoInicio();
            } else if (!lista_baixa_prioridade.estaVazia()) {
                atual = lista_baixa_prioridade.removerDoInicio();
            }
        }

        // 3. Se não tem processo
        if (atual == null) {
            System.out.println("Nenhum processo para executar neste ciclo.");
            return;
        }

        // 4. Verificar recurso "DISCO"
        if ("DISCO".equals(atual.recursosNecessarios) && !atual.jaBloqueado) {
            System.out.println("Processo " + atual + " precisa de DISCO. Movido para a lista de bloqueados.");
            atual.jaBloqueado = true;
            lista_bloqueados.inserirNoFim(atual);
            return;
        }

        // 5. Executar processo
        atual.ciclosNecessarios--;
        System.out.println("Executando: " + atual.nome + " | Ciclos restantes: " + atual.ciclosNecessarios);

        // Se ainda tem ciclos, volta para o fim da sua lista de prioridade
        if (atual.ciclosNecessarios > 0) {
            adicionarProcesso(atual);
        } else {
            System.out.println("Processo " + atual.nome + " terminou.");
        }
    }

    // 6. Mostrar estado das listas
    public void mostrarEstado() {
        System.out.println("\n--- ESTADO ATUAL ---");
        lista_alta_prioridade.imprimirLista("Alta Prioridade");
        lista_media_prioridade.imprimirLista("Média Prioridade");
        lista_baixa_prioridade.imprimirLista("Baixa Prioridade");
        lista_bloqueados.imprimirLista("Bloqueados");
    }
}
