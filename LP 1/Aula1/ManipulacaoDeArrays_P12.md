# Gerenciador Interativo de Coleções em Java (Problema 12):

Este programa simula o comportamento de uma lista dinâmica utilizando arrays estáticos primitivos do Java. Ele permite ao usuário definir o tamanho de uma coleção e realizar operações diversas através de um menu no terminal.

## Funcionalidades Principais
* **Adição de Elementos:** Permite inserir números no final da lista ou em posições específicas (deslocando os demais).
* **Remoção de Elementos:** Exclui valores com base no índice fornecido ou remove todas as ocorrências de um determinado valor.
* **Consultas:** Verifica a existência de um número no array e identifica sua posição.
* **Soma de Pares (Two Sum):** Uma implementação simples que verifica se existem dois números distintos no array cuja soma resulta em um valor procurado pelo usuário.

## Estrutura do Código
O algoritmo lida com a restrição de tamanho fixo do array `int[]`. Para controlar os espaços "vazios", o código assume o valor `0` como ausência de dados, utilizando a função `contarElementosNaoNulos()` para descobrir o limite atual de elementos preenchidos antes de aplicar deslocamentos lógicos de inserção ou remoção.
