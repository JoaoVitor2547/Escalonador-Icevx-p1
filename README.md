# Projeto: Escalonador de Processos com Prevenção de Inanição

**Disciplina:** Algoritmos e Estrutura de Dados I  
**Professor:** Dimmy Magalhães  
**Integrantes:**

- João Vitor Fernandes de Sousa – 0030696
- José Torres de Araujo Neto – 0030575
- Octávio Alves Freire – 0030681

---

# Descrição do Projeto

Este projeto implementa um **escalonador de processos com múltiplos níveis de prioridade e prevenção de inanição**, como parte da avaliação P1 da disciplina de Algoritmos e Estrutura de Dados I.

O escalonador é responsável por decidir qual processo utiliza a CPU a cada ciclo, garantindo justiça na execução e impedindo que processos de baixa prioridade sofram **inanição (starvation)**.

---

# Estrutura de Dados Utilizadas

Todas as listas foram implementadas manualmente com **nós (`Node`) e referências**.

As filas de processos foram divididas assim:

- **Alta prioridade:** `ListaDuplamente`
- **Média prioridade:** `ListaDuplamente`
- **Baixa prioridade:** `ListaDeProcessos` (lista simplesmente encadeada)
- **Bloqueados:** `ListaDuplamente`

> Decisão de design: As filas de alta, média e bloqueados usam `ListaDuplamente` para permitir navegação em ambos os sentidos, enquanto a de baixa usa `ListaDeProcessos` por ser mais simples e leve.  
> Essa escolha foi feita propositalmente para comparar o comportamento das duas estruturas no mesmo projeto.
