# 🛒 Sistema de Comparação de Preços em Java

## 🎯 Objetivo

Criar um sistema que:

1. Lê uma matriz de preços de um arquivo `.txt`
2. Cada linha representa um **produto**
3. Cada coluna representa um **estabelecimento**
4. O usuário informa a quantidade desejada de cada produto
5. O sistema calcula:

   * Preço × Quantidade
   * Melhor estabelecimento para cada produto
   * Custo total da compra

---

# 📂 Estrutura do Arquivo `precos.txt`

Arquivo utilizado: 

Conteúdo:

```text
20	15	30	40	68
35	18	35	35	60
40	12	27	70	50
```

## 📊 Interpretação

| Produto | Est1 | Est2 | Est3 | Est4 | Est5 |
| ------- | ---- | ---- | ---- | ---- | ---- |
| P1      | 20   | 15   | 30   | 40   | 68   |
| P2      | 35   | 18   | 35   | 35   | 60   |
| P3      | 40   | 12   | 27   | 70   | 50   |

* Cada linha → um produto
* Cada coluna → um estabelecimento
* Valores separados por TAB (`\t`)

---

# 🧠 Estrutura de Dados Utilizada

## 📌 Matriz Bidimensional

```java
int[][] precos;
```

Representação interna:

```text
precos[produto][estabelecimento]
```

Exemplo:

```text
precos[0][1] → preço do Produto 1 no Estabelecimento 2
```

---

# 🏗 Organização do Código

O código foi dividido em blocos lógicos:

1. 📂 Leitura do Arquivo
2. 🖨 Impressão da Matriz
3. 🔢 Cálculo (Preço × Quantidade)
4. 🔍 Busca do menor preço
5. 📊 Resultado final
6. 🚀 Método `main`

Essa divisão melhora:

* Clareza
* Manutenção
* Didática
* Reutilização de código

---

# 📂 1️⃣ Leitura da Matriz do Arquivo

```java
public static int[][] lerMatrizArquivo(String nomeArquivo) throws IOException
```

### Etapas realizadas:

1. Conta o número de linhas do arquivo
2. Reabre o arquivo
3. Cria a matriz
4. Divide cada linha usando `split("\t")`
5. Converte String → int com `Integer.parseInt`

### Conceitos trabalhados:

* `BufferedReader`
* `FileReader`
* Tratamento de exceção (`throws IOException`)
* Split de String
* Conversão de tipos

---

# 🖨 2️⃣ Impressão da Matriz

```java
public static void imprimirMatriz(int[][] matriz)
```

### O que faz?

* Imprime cabeçalho com Est1, Est2...
* Percorre linhas e colunas
* Formata saída para ficar visualmente organizada

### Conceito importante

Percorrer matriz:

```java
for (int i = 0; i < matriz.length; i++)
    for (int j = 0; j < matriz[i].length; j++)
```

---

# 🔢 3️⃣ Cálculo: Preço × Quantidade

```java
public static int[][] calcularTotal(int[][] matriz, int[] quantidades)
```

### Lógica

Cada produto tem uma quantidade informada pelo usuário.

Fazemos:

```text
novoValor = precoOriginal × quantidade
```

### Importante

Criamos uma nova matriz para:

✔ Não alterar a original
✔ Manter separação de responsabilidades

---

# 🔍 4️⃣ Encontrando o Menor Preço

## 🔹 Encontrar menor elemento

```java
public static int menorElemento(int[] vetor)
```

Percorre o vetor e guarda o menor valor encontrado.

---

## 🔹 Encontrar índice do menor

```java
public static int indiceMenor(int[] vetor)
```

Retorna a posição do menor valor.

---

## 🔹 Comparar estabelecimentos

```java
public static int[] compararEstabelecimentos(int[][] matriz)
```

Para cada produto:

1. Busca o menor valor
2. Guarda o índice do estabelecimento

Resultado:

```text
melhores[produto] = estabelecimento mais barato
```

---

# 📊 5️⃣ Resultado Final

```java
public static void imprimirResultado(int[][] matriz, int[] melhores)
```

Para cada produto:

* Mostra onde comprar
* Soma custo total

---

# 🚀 6️⃣ Método `main`

Fluxo completo:

```text
1. Ler arquivo
2. Imprimir tabela original
3. Pedir quantidades
4. Calcular preço total
5. Imprimir nova tabela
6. Encontrar melhores estabelecimentos
7. Mostrar custo total
```

---

# 📌 Código Completo Documentado

```java
package Aula3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Sistema que:
 * - Lê matriz de preços
 * - Calcula preço total por quantidade
 * - Identifica melhor estabelecimento
 */
public class Krika {

    public static int[][] lerMatrizArquivo(String nomeArquivo) throws IOException {

        BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo));

        int linhas = 0;
        String linha;

        while ((linha = leitor.readLine()) != null) {
            linhas++;
        }

        leitor.close();
        leitor = new BufferedReader(new FileReader(nomeArquivo));

        int[][] matriz = new int[linhas][];

        int i = 0;
        while ((linha = leitor.readLine()) != null) {

            String[] valores = linha.split("\t");
            matriz[i] = new int[valores.length];

            for (int j = 0; j < valores.length; j++) {
                matriz[i][j] = Integer.parseInt(valores[j]);
            }

            i++;
        }

        leitor.close();
        return matriz;
    }

    public static void imprimirMatriz(int[][] matriz) {

        System.out.print("\t");
        for (int j = 0; j < matriz[0].length; j++) {
            System.out.print("Est" + (j + 1) + "\t");
        }
        System.out.println();

        for (int i = 0; i < matriz.length; i++) {
            System.out.print("P" + (i + 1) + ":\t");
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] calcularTotal(int[][] matriz, int[] quantidades) {

        int[][] resultado = new int[matriz.length][matriz[0].length];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                resultado[i][j] = matriz[i][j] * quantidades[i];
            }
        }

        return resultado;
    }

    public static int menorElemento(int[] vetor) {
        int menor = vetor[0];
        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i] < menor) {
                menor = vetor[i];
            }
        }
        return menor;
    }

    public static int indiceMenor(int[] vetor) {
        int menor = menorElemento(vetor);

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == menor) {
                return i;
            }
        }

        return -1;
    }

    public static int[] compararEstabelecimentos(int[][] matriz) {

        int[] melhores = new int[matriz.length];

        for (int i = 0; i < matriz.length; i++) {
            melhores[i] = indiceMenor(matriz[i]);
        }

        return melhores;
    }

    public static void imprimirResultado(int[][] matriz, int[] melhores) {

        int somaTotal = 0;

        for (int i = 0; i < melhores.length; i++) {

            System.out.println("Produto P" + (i + 1) +
                    " comprar no Estabelecimento " + (melhores[i] + 1));

            somaTotal += matriz[i][melhores[i]];
        }

        System.out.println("Custo total da compra: " + somaTotal);
    }

    public static void main(String[] args) throws IOException {

        Scanner entrada = new Scanner(System.in);

        int[][] precos = lerMatrizArquivo("precos.txt");

        System.out.println("Tabela de Preços:");
        imprimirMatriz(precos);

        int[] quantidades = new int[precos.length];

        for (int i = 0; i < quantidades.length; i++) {
            System.out.print("Quantidade do Produto P" + (i + 1) + ": ");
            quantidades[i] = entrada.nextInt();
        }

        int[][] total = calcularTotal(precos, quantidades);

        System.out.println("\nTabela (Preço x Quantidade):");
        imprimirMatriz(total);

        int[] melhores = compararEstabelecimentos(total);

        System.out.println("\nMelhores opções:");
        imprimirResultado(total, melhores);

        entrada.close();
    }
}
```

---

# 🎓 Conceitos Ensinados

* Matrizes bidimensionais
* Leitura de arquivos
* Conversão de tipos
* Busca do menor elemento
* Modularização
* Separação de responsabilidades
* Algoritmo de varredura
* Entrada de usuário
* Acumulação de soma
