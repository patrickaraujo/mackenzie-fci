# Algoritmo Merge Sort (Iterativo)

Este documento descreve a implementação da variante iterativa do algoritmo de ordenação **Merge Sort** em Java.

## Visão Geral do Algoritmo
O Merge Sort clássico é um algoritmo de divisão e conquista que geralmente utiliza a recursividade (abordagem *Top-Down*) para dividir o array ao meio sucessivamente. A implementação **Iterativa** (também conhecida como *Bottom-Up*), faz exatamente o caminho oposto.



Em vez de começar dividindo o vetor grande em pedaços pequenos, a abordagem iterativa parte do princípio de que **cada elemento isolado do vetor já é um subvetor ordenado de tamanho 1**. A partir daí, o algoritmo usa laços de repetição (loops `while`) para fundir (intercalar) pares adjacentes:
1. Intercala vetores de tamanho 1 para formar vetores de tamanho 2.
2. Intercala vetores de tamanho 2 para formar vetores de tamanho 4.
3. Repete o processo dobrando o tamanho dos blocos até que o vetor principal inteiro esteja em ordem.

## Estrutura do Código

### 1. `intercalacao(int[] v, int inicio, int meio, int fim)`
É o coração lógico do Merge Sort. Esta função não ordena por conta própria, mas recebe **dois blocos vizinhos que já estão ordenados** e os funde perfeitamente em um único bloco contínuo ordenado.
* Ela utiliza um array auxiliar (`vetorAuxiliar`) criado temporariamente na memória.
* Percorre ambas as metades originais através de dois ponteiros (`i` e `j`), selecionando sempre o menor número disponível.
* Ao final, devolve os números do array auxiliar para o array principal.

### 2. `mergeSort(int[] v)`
A função principal que coordena o tamanho dos blocos que serão passados para a `intercalacao`.
* A variável `tamanhoSubvetor` controla o agrupamento (começando em 1, depois 2, 4, 8...).
* Internamente, utiliza um ponteiro `inicio` para saltar pelo vetor garantindo que todos os pares disponíveis naquele nível de tamanho sejam processados.

### 3. Métodos Auxiliares
* **`generateVector(int n)`:** Popula automaticamente um array de tamanho `n` com números aleatórios (entre 0 e 299) utilizando a biblioteca `Math.random()`.
* **`printVector(int[] v)`:** Função estética para exibir no console a posição e os valores de forma formatada.
