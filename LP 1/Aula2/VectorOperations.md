# Algoritmos de Ordenação e Busca (`VectorOperations`)

Este script funciona como uma biblioteca pessoal contendo implementações puras dos principais algoritmos básicos de estrutura de dados ensinados em computação.

## Algoritmos Disponíveis
* **Linear Search (`linearSearch`):** Percorre o vetor da esquerda para a direita em tempo linear O(N). Retorna o índice da primeira ocorrência encontrada.
* **Linear Search Invertida (`linearSearchLast`):** Percorre o vetor da direita para a esquerda. Útil quando sabemos que elementos repetidos existem e queremos a última ocorrência registrada.
* **Busca Binária (`binarySearch`):** Um algoritmo de divisão e conquista de tempo logarítmico O(log N). Requer como precondição que o vetor já esteja completamente ordenado.
* **Bubble Sort (`bubbleSort`):** Ordena os elementos em tempo quadrático O(N²), "flutuando" os maiores elementos progressivamente para o fim do array.
