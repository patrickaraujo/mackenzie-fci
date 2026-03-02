# 🎮 Jogo da Velha em Java

## 📌 Objetivo

Implementar um jogo da velha utilizando:

* Matrizes bidimensionais (`String[][]`)
* Estruturas de repetição
* Estruturas condicionais
* Modularização
* Validação de entrada
* Separação de responsabilidades

---

# 🧠 Conceito Principal: Matriz Bidimensional

O tabuleiro é representado por:

```java
String[][] tabuleiro = new String[3][3];
```

Visualmente:

```
(0,0)  (0,1)  (0,2)
(1,0)  (1,1)  (1,2)
(2,0)  (2,1)  (2,2)
```

Cada posição pode conter:

* `"."` → posição vazia
* `"X"` → jogada do jogador X
* `"O"` → jogada do jogador O

---

# 🏗 Organização do Código

O código está dividido em blocos lógicos:

1. Inicialização
2. Impressão do tabuleiro
3. Lógica de verificação
4. Controle das jogadas
5. Método `main`

Essa separação melhora:

* Legibilidade
* Manutenção
* Reuso
* Clareza pedagógica

---

# 🔹 1️⃣ Inicialização do Tabuleiro

```java
public static void inicializarTabuleiro(String[][] tabuleiro) {
    for (int linha = 0; linha < 3; linha++) {
        for (int coluna = 0; coluna < 3; coluna++) {
            tabuleiro[linha][coluna] = ".";
        }
    }
}
```

### O que acontece aqui?

* Percorremos todas as posições da matriz
* Preenchemos com `"."`
* Isso representa um tabuleiro vazio

---

# 🔹 2️⃣ Impressão do Tabuleiro

```java
public static void imprimirTabuleiro(String[][] tabuleiro) {
    System.out.println("\nTabuleiro:");
    for (int linha = 0; linha < 3; linha++) {
        for (int coluna = 0; coluna < 3; coluna++) {
            System.out.print(tabuleiro[linha][coluna] + " ");
        }
        System.out.println();
    }
}
```

### Conceito Trabalhado

* Percorrer matriz com dois `for`
* Formatação de saída
* Representação visual de estrutura bidimensional

---

# 🔹 3️⃣ Verificar se o Tabuleiro Está Cheio

```java
public static boolean tabuleiroCheio(String[][] tabuleiro) {
    for (int linha = 0; linha < 3; linha++) {
        for (int coluna = 0; coluna < 3; coluna++) {
            if (".".equals(tabuleiro[linha][coluna])) {
                return false;
            }
        }
    }
    return true;
}
```

### Lógica

* Se encontrar `"."`, ainda há espaço → retorna `false`
* Se não encontrar nenhuma posição vazia → retorna `true`

---

# 🔹 4️⃣ Verificação de Vencedor

```java
public static int verificarVencedor(String[][] tabuleiro)
```

### Retornos possíveis:

| Valor | Significado    |
| ----- | -------------- |
| 0     | Ninguém venceu |
| 1     | X venceu       |
| 2     | O venceu       |

---

## ✔ Verificação de Linhas

```
X X X
```

---

## ✔ Verificação de Colunas

```
X
X
X
```

---

## ✔ Verificação de Diagonais

```
X . .
. X .
. . X
```

ou

```
. . X
. X .
X . .
```

---

# 🔹 5️⃣ Controle das Jogadas

```java
public static void jogar(boolean jogador1EhX, String[][] tabuleiro)
```

### Fluxo do jogo:

```
Enquanto o jogo estiver ativo:
    Determina jogador atual
    Solicita linha e coluna
    Valida posição
    Marca jogada
    Imprime tabuleiro
    Verifica vencedor
    Verifica empate
```

---

## 🧠 Alternância de Jogador

```java
String jogadorAtual = (turno % 2 == 0) ? simboloJ1 : simboloJ2;
```

Aqui usamos:

* Operador ternário
* Conceito de módulo `%`
* Alternância por paridade do turno

---

# 🔹 6️⃣ Método `main`

```java
public static void main(String[] args)
```

### O que ele faz?

1. Cria o tabuleiro
2. Inicializa o tabuleiro
3. Imprime tabuleiro vazio
4. Permite jogador 1 escolher símbolo
5. Inicia o jogo

---

# 📌 Código Completo Documentado

```java
package Aula3;

import java.util.Scanner;

/**
 * Jogo da Velha (Tic-Tac-Toe)
 * 
 * Representação:
 * - Matriz 3x3
 * - "." posição vazia
 * - "X" e "O" representam jogadas
 */
public class JogoVelha {

    public static Scanner entrada = new Scanner(System.in);

    /* ================= INICIALIZAÇÃO ================= */

    public static void inicializarTabuleiro(String[][] tabuleiro) {
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                tabuleiro[linha][coluna] = ".";
            }
        }
    }

    public static void imprimirTabuleiro(String[][] tabuleiro) {
        System.out.println("\nTabuleiro:");
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                System.out.print(tabuleiro[linha][coluna] + " ");
            }
            System.out.println();
        }
    }

    /* ================= LÓGICA ================= */

    public static boolean tabuleiroCheio(String[][] tabuleiro) {
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                if (".".equals(tabuleiro[linha][coluna])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int verificarVencedor(String[][] tabuleiro) {

        for (int i = 0; i < 3; i++) {

            if ("X".equals(tabuleiro[i][0]) &&
                "X".equals(tabuleiro[i][1]) &&
                "X".equals(tabuleiro[i][2]))
                return 1;

            if ("O".equals(tabuleiro[i][0]) &&
                "O".equals(tabuleiro[i][1]) &&
                "O".equals(tabuleiro[i][2]))
                return 2;

            if ("X".equals(tabuleiro[0][i]) &&
                "X".equals(tabuleiro[1][i]) &&
                "X".equals(tabuleiro[2][i]))
                return 1;

            if ("O".equals(tabuleiro[0][i]) &&
                "O".equals(tabuleiro[1][i]) &&
                "O".equals(tabuleiro[2][i]))
                return 2;
        }

        if ("X".equals(tabuleiro[0][0]) &&
            "X".equals(tabuleiro[1][1]) &&
            "X".equals(tabuleiro[2][2]))
            return 1;

        if ("O".equals(tabuleiro[0][0]) &&
            "O".equals(tabuleiro[1][1]) &&
            "O".equals(tabuleiro[2][2]))
            return 2;

        if ("X".equals(tabuleiro[0][2]) &&
            "X".equals(tabuleiro[1][1]) &&
            "X".equals(tabuleiro[2][0]))
            return 1;

        if ("O".equals(tabuleiro[0][2]) &&
            "O".equals(tabuleiro[1][1]) &&
            "O".equals(tabuleiro[2][0]))
            return 2;

        return 0;
    }

    /* ================= CONTROLE DO JOGO ================= */

    public static void jogar(boolean jogador1EhX, String[][] tabuleiro) {

        String simboloJ1 = jogador1EhX ? "X" : "O";
        String simboloJ2 = jogador1EhX ? "O" : "X";

        int turno = 0;
        boolean jogoAtivo = true;

        while (jogoAtivo) {

            String jogadorAtual = (turno % 2 == 0) ? simboloJ1 : simboloJ2;

            int linha, coluna;

            while (true) {
                System.out.println("Jogador " + jogadorAtual);
                System.out.print("Linha (0-2): ");
                linha = entrada.nextInt();
                System.out.print("Coluna (0-2): ");
                coluna = entrada.nextInt();

                if (linha >= 0 && linha < 3 &&
                    coluna >= 0 && coluna < 3 &&
                    ".".equals(tabuleiro[linha][coluna])) {
                    break;
                }

                System.out.println("Posição inválida!");
            }

            tabuleiro[linha][coluna] = jogadorAtual;
            imprimirTabuleiro(tabuleiro);

            int resultado = verificarVencedor(tabuleiro);

            if (resultado == 1) {
                System.out.println("Jogador X venceu!");
                jogoAtivo = false;
            } else if (resultado == 2) {
                System.out.println("Jogador O venceu!");
                jogoAtivo = false;
            } else if (tabuleiroCheio(tabuleiro)) {
                System.out.println("Deu velha! (Empate)");
                jogoAtivo = false;
            }

            turno++;
        }
    }

    /* ================= MAIN ================= */

    public static void main(String[] args) {

        String[][] tabuleiro = new String[3][3];

        inicializarTabuleiro(tabuleiro);
        imprimirTabuleiro(tabuleiro);

        boolean jogador1EhX;

        while (true) {
            System.out.print("Jogador 1 escolha (X ou O): ");
            String escolha = entrada.next().toUpperCase();

            if (escolha.equals("X")) {
                jogador1EhX = true;
                break;
            } else if (escolha.equals("O")) {
                jogador1EhX = false;
                break;
            }

            System.out.println("Entrada inválida!");
        }

        jogar(jogador1EhX, tabuleiro);

        entrada.close();
        System.out.println("Fim do jogo!");
    }
}
```

---

# 🎓 Conceitos Ensinados

* Matrizes bidimensionais
* Percurso com laços aninhados
* Estrutura condicional
* Estrutura de repetição
* Validação de entrada
* Operador ternário
* Modularização
* Separação de responsabilidades
* Controle de fluxo
