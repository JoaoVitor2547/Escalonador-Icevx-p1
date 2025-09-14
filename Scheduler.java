    public class Scheduler {
    private ListaDuplamente alta = new ListaDuplamente();
    private ListaDuplamente media = new ListaDuplamente();
    private ListaDuplamente bloqueados = new ListaDuplamente();
    private ListaDeProcessos baixa = new ListaDeProcessos();
    private int contadorAlta = 0;

    public void adicionarProcesso(Processo p) {
        if (p.prioridade == 1) {
            alta.inserirNoFim(p);
        } else if (p.prioridade == 2) {
            media.inserirNoFim(p);
        } else {
            baixa.inserirNoFim(p);
        }
    }

    public void executarCicloDeCPU() {
        // Primeiro: desbloqueia um processo, se houver
        Processo desbloqueado = bloqueados.removerDoInicio();
        if (desbloqueado != null) {
            System.out.println("🔓 Desbloqueando " + desbloqueado);
            adicionarProcesso(desbloqueado);
        }

        Processo atual = null;

        // Regra de anti-inanição: força execução de média/baixa após 5 de alta
        if (contadorAlta >= 5) {
            atual = media.removerDoInicio();
            if (atual == null) {
                atual = baixa.removerDoInicio();
            }
            contadorAlta = 0;
        }

        // Execução normal (alta > média > baixa)
        if (atual == null) {
            if (!alta.estaVazia()) {
                atual = alta.removerDoInicio();
                contadorAlta++;
            } else if (!media.estaVazia()) {
                atual = media.removerDoInicio();
            } else if (!baixa.estaVazia()) {
                atual = baixa.removerDoInicio();
            }
        }

        if (atual == null) {
            System.out.println("⛔ Nenhum processo para executar neste ciclo.");
            return;
        }

        // Verifica se precisa de DISCO e ainda não foi bloqueado
        if ("DISCO".equals(atual.recursosNecessarios) && !atual.jaBloqueado) {
            System.out.println("💽 Processo " + atual + " precisa de DISCO → indo para bloqueados.");
            atual.jaBloqueado = true;
            bloqueados.inserirNoFim(atual);
            return;
        }

        // Executa um ciclo do processo
        atual.ciclosNecessarios--;
        System.out.println("⚙️ Executando " + atual);

        // Se ainda restam ciclos, volta para a fila de origem
        if (atual.ciclosNecessarios > 0) {
            adicionarProcesso(atual);
        } else {
            System.out.println("✅ Processo " + atual.nome + " terminou!");
            if (atual.prioridade == 3) {
            }
        }
    }

    public void mostrarEstado() {
        System.out.println("\n--- 📝 ESTADO ATUAL ---");
        alta.imprimirLista("Alta");
        media.imprimirLista("Média");
        baixa.imprimirLista("Baixa");
        bloqueados.imprimirLista("Bloqueados");
    }
}

