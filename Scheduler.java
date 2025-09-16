public class Scheduler {
    private ListaDeProcessos alta = new ListaDeProcessos();
    private ListaDeProcessos media = new ListaDeProcessos();
    private ListaDeProcessos baixa = new ListaDeProcessos();
    private ListaDeProcessos bloqueados = new ListaDeProcessos();
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
        Processo desbloqueado = bloqueados.removerDoInicio();
        if (desbloqueado != null) {
            System.out.println("🔓 Desbloqueando " + desbloqueado);
            desbloqueado.jaBloqueado = true;
            desbloqueado.prioridade = desbloqueado.prioridadeOriginal;
            adicionarProcesso(desbloqueado);
        }

        Processo atual = null;

        if (contadorAlta >= 5) {
            atual = media.removerDoInicio();
            if (atual == null) {
                atual = baixa.removerDoInicio();
            }
            contadorAlta = 0;
        }

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

        if ("DISCO".equals(atual.recursosNecessarios) && !atual.jaBloqueado) {
            System.out.println("💽 Processo " + atual + " precisa de DISCO → indo para bloqueados.");
            atual.jaBloqueado = true;
            bloqueados.inserirNoFim(atual);
            return;
        }

        atual.ciclosNecessarios--;
        System.out.println("⚙️ Executando " + atual);

        if (atual.ciclosNecessarios > 0) {
            adicionarProcesso(atual);
        } else {
            System.out.println("✅ Processo " + atual.nome + " terminou!");
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
