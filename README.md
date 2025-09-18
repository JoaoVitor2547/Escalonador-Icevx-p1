# Escalonador de Processos com Prevenção de Inanição

**Disciplina:** Algoritmos e Estrutura de Dados I  
**Professor:** Dimmy Magalhães  
**Avaliação:** P1 (40% da nota)  

---

## Integrantes do Grupo

- João Vitor Fernandes de Sousa – 0030696  
- José Torres de Araujo Neto – 0030575  
- Octávio Alves Freire – 0030681  

---

## Descrição do Projeto

Este projeto implementa um **escalonador de processos com múltiplos níveis de prioridade e prevenção de inanição**, como parte da avaliação da disciplina Algoritmos e Estrutura de Dados I.

O escalonador decide qual processo usa a CPU a cada ciclo, garantindo justiça na execução e impedindo que processos de baixa prioridade sofram **inanição (starvation)**.  
Também há **gerenciamento de bloqueio de recursos (DISCO)**, simulando entrada e saída de processos que precisam esperar por E/S.

---

## Estruturas de Dados Utilizadas

Todas as listas foram implementadas manualmente, manipulando diretamente nós (`Node`) e referências, conforme exigido no enunciado.  

As filas foram divididas assim:

| Fila                   | Estrutura utilizada          |
|------------------------|------------------------------|
| Alta prioridade        | `ListaDuplamente`            |
| Média prioridade       | `ListaDuplamente`            |
| Baixa prioridade       | `ListaDeProcessos` (simples) |
| Bloqueados             | `ListaDuplamente`            |

-Decisão de design: As filas de alta, média e bloqueados usam `ListaDuplamente` por permitirem remoções intermediárias e navegação nos dois sentidos, enquanto a de baixa usa `ListaDeProcessos` (simples) por ser mais leve e funcionar como FIFO (primeiro a entrar, primeiro a sair).

---

## Como Compilar e Executar

### 1. Clonar o repositório

```bash
git clone https://github.com/SEU-USUARIO/seu-repositorio.git

cd seu-repositorio
