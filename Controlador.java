public class Controlador {
    ListaDuplamente alta = new ListaDuplamente();
    ListaDuplamente media = new ListaDuplamente();
    ListaDuplamente bloqueados = new ListaDuplamente();
    ListaCircular baixa = new ListaCircular();
    int contadorAlta = 0;

    public void adicionarProcesso(Processo p) {
        if (p.prioridade == 1) alta.inserirNoFim(p);
        else if (p.prioridade == 2) media.inserirNoFim(p);
        else baixa.inserir(p);
    }

    public void executarCicloDeCPU() {
        // Desbloqueio
        Processo desbloqueado = bloqueados.removerDoInicio();
        if (desbloqueado != null) {
            System.out.println("Desbloqueando " + desbloqueado);
            adicionarProcesso(desbloqueado);
        }

        Processo atual = null;

        // Anti-inanição
        if (contadorAlta >= 5) {
            atual = media.removerDoInicio();
            if (atual == null) atual = baixa.proximo();
            contadorAlta = 0;
        }

        // Execução normal
        if (atual == null) {
            if (!alta.estaVazia()) {
                atual = alta.removerDoInicio();
                contadorAlta++;
            } else if (!media.estaVazia()) {
                atual = media.removerDoInicio();
            } else if (!baixa.estaVazia()) {
                atual = baixa.proximo();
            }
        }

        if (atual == null) {
            System.out.println("Nenhum processo para executar neste ciclo.");
            return;
        }

        // Verifica recurso DISCO
        if ("DISCO".equals(atual.recursosNecessarios) && !atual.jaBloqueado) {
            System.out.println("Processo " + atual + " precisa de DISCO, indo para bloqueados.");
            atual.jaBloqueado = true;
            bloqueados.inserirNoFim(atual);
            return;
        }

        // Executa ciclo
        atual.ciclosNecessarios--;
        System.out.println("Executando " + atual);

        if (atual.ciclosNecessarios > 0) {
            adicionarProcesso(atual);
        } else {
            System.out.println("Processo " + atual.nome + " terminou!");
            if (atual.prioridade == 3) {
                baixa.remover(atual);
            }
        }
    }

    public void mostrarEstado() {
        alta.imprimirLista("Alta");
        media.imprimirLista("Média");
        baixa.imprimirLista("Baixa");
        bloqueados.imprimirLista("Bloqueados");
    }
}
