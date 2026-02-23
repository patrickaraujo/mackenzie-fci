# Problema: Piscina e Baldes (Inversões e Paridade)

Este programa consome funções do pacote `Aula1` para gerar e imprimir vetores, e implementa uma lógica de jogo baseada no clássico algoritmo de ordenação **Bubble Sort**.

## Como o jogo funciona?
A regra é simples: o jogo conta quantas permutações (trocas ou inversões) são necessárias para ordenar perfeitamente um vetor desordenado. 
A decisão do vencedor é baseada puramente na **paridade** das permutações registradas:
* Se o número de trocas for **Par** (ou zero), o jogador **Carlos** ganha.
* Se o número de trocas for **Ímpar**, o jogador **Marcelo** ganha.

## Conceitos Aplicados
* **Importação Estática:** Reutilização de métodos utilitários (`generateVector`, `printVector`) de outro pacote (`Aula1`) sem a necessidade de instanciar objetos.
* **Bubble Sort Modificado:** Em vez de retornar um array ordenado, a função foi alterada para retornar um tipo primitivo `int` atuando como um "contador de inversões".
