# 🏦 Sistema Bancário Simples em Java

## 🎯 Objetivo

Este programa simula um sistema bancário simples onde:

* Cada cliente possui:

  * Conta Corrente
  * Conta Poupança
* O sistema permite:

  * Consultar saldos
  * Sacar
  * Depositar
  * Transferir valores entre contas

---

# 🧠 Estrutura de Dados Utilizada

## 📌 1️⃣ Vetor de Clientes

```java
String[] clientes
```

Armazena os nomes dos clientes.

Exemplo:

```java
{"Marcos", "Júlia", "João", "Roberto", "Janaína"}
```

Cada posição representa um cliente.

---

## 📌 2️⃣ Matriz de Saldos

```java
double[][] saldos
```

Essa é uma **matriz bidimensional**, onde:

```
saldos[cliente][tipoConta]
```

| Índice    | Significado                 |
| --------- | --------------------------- |
| cliente   | qual cliente                |
| tipoConta | 0 = corrente / 1 = poupança |

### Exemplo visual:

```
            Corrente   Poupança
Marcos        1000        2500
Júlia          250        1500
João          2500         750
```

Internamente:

```java
double[][] saldos = {
    {1000, 2500},
    {250, 1500},
    {2500, 750},
    {3000, 50},
    {4500, 3200}
};
```

---

# 🏗 Organização do Código

O código foi dividido em 3 partes principais:

1. **Métodos de Lógica**
2. **Métodos de Interação com Usuário**
3. **Métodos Auxiliares**
4. **Método main (controle do programa)**

Essa separação é importante para:

✔ Melhor organização
✔ Evitar repetição de código
✔ Facilitar manutenção
✔ Tornar didático

---

# ⚙️ Métodos de Lógica

Esses métodos alteram os dados, mas **não pedem informações ao usuário**.

---

## 🟢 Método `sacar`

```java
public static void sacar(double[][] saldos, double valor, int cliente, int tipoConta) {
    saldos[cliente][tipoConta] -= valor;
}
```

### O que faz?

Subtrai um valor do saldo de uma conta específica.

---

## 🟢 Método `depositar`

```java
public static void depositar(double[][] saldos, double valor, int cliente, int tipoConta) {
    saldos[cliente][tipoConta] += valor;
}
```

### O que faz?

Adiciona valor ao saldo da conta.

---

## 🟢 Método `transferir`

```java
public static void transferir(double[][] saldos, double valor,
                              int clienteOrigem, int tipoContaOrigem,
                              int clienteDestino, int tipoContaDestino) {

    sacar(saldos, valor, clienteOrigem, tipoContaOrigem);
    depositar(saldos, valor, clienteDestino, tipoContaDestino);
}
```

### O que faz?

1. Saca da conta de origem
2. Deposita na conta de destino

---

# 👤 Métodos de Interação

Esses métodos:

* Pedem dados ao usuário
* Validam entradas
* Chamam os métodos de lógica

---

## 🟡 `interacaoSacar`

1. Solicita cliente válido
2. Solicita tipo de conta
3. Solicita valor
4. Executa saque

---

## 🟡 `interacaoDepositar`

Mesmo fluxo do saque, mas chama `depositar`.

---

## 🟡 `interacaoTransferir`

Fluxo:

1. Solicita valor
2. Solicita conta origem
3. Solicita conta destino
4. Executa transferência

---

# 🔁 Métodos Auxiliares

Para evitar repetição de código, criamos:

---

## 🔹 `solicitarClienteValido`

Valida se o índice está dentro do intervalo:

```java
0 até totalClientes - 1
```

Evita erro de índice fora do vetor.

---

## 🔹 `solicitarTipoConta`

Aceita apenas:

```
0 → Conta Corrente
1 → Poupança
```

---

# 🖥 Método `main`

O método principal controla o menu do sistema.

Fluxo:

```
Enquanto não sair:
    Mostrar menu
    Ler opção
    Executar operação correspondente
```

---

# 📌 Código Completo Documentado

```java
package Aula3;

import java.util.Scanner;

/**
 * Sistema bancário simples utilizando matriz bidimensional.
 * 
 * Estrutura:
 * saldos[cliente][tipoConta]
 * 
 * tipoConta:
 * 0 - Conta Corrente
 * 1 - Poupança
 */
public class ContaBancaria {

    public static Scanner entrada;

    /* ================= MÉTODOS DE LÓGICA ================= */

    public static void sacar(double[][] saldos, double valor, int cliente, int tipoConta) {
        saldos[cliente][tipoConta] -= valor;
    }

    public static void depositar(double[][] saldos, double valor, int cliente, int tipoConta) {
        saldos[cliente][tipoConta] += valor;
    }

    public static void transferir(double[][] saldos, double valor,
                                  int clienteOrigem, int tipoContaOrigem,
                                  int clienteDestino, int tipoContaDestino) {

        sacar(saldos, valor, clienteOrigem, tipoContaOrigem);
        depositar(saldos, valor, clienteDestino, tipoContaDestino);
    }

    /* ================= MÉTODOS AUXILIARES ================= */

    public static int solicitarClienteValido(int totalClientes) {
        int cliente;

        do {
            System.out.print("Escolha o cliente (0 a " + (totalClientes - 1) + "): ");
            cliente = entrada.nextInt();
        } while (cliente < 0 || cliente >= totalClientes);

        return cliente;
    }

    public static int solicitarTipoConta() {
        int tipoConta;

        do {
            System.out.println("0 - Conta Corrente");
            System.out.println("1 - Poupança");
            tipoConta = entrada.nextInt();
        } while (tipoConta != 0 && tipoConta != 1);

        return tipoConta;
    }

    public static void imprimirSaldos(String[] nomes, double[][] saldos) {
        System.out.println("\n=== SALDOS DOS CLIENTES ===");

        for (int i = 0; i < nomes.length; i++) {
            System.out.println(i + ") " + nomes[i]);
            System.out.println("   Corrente: R$ " + saldos[i][0]);
            System.out.println("   Poupança: R$ " + saldos[i][1]);
            System.out.println();
        }
    }

    /* =========================== MAIN =========================== */

    public static void main(String[] args) {

        String[] clientes = {"Marcos", "Júlia", "João", "Roberto", "Janaína"};

        double[][] saldos = {
                {1000, 2500},
                {250, 1500},
                {2500, 750},
                {3000, 50},
                {4500, 3200}
        };

        entrada = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {

            System.out.println("1 - Mostrar saldos");
            System.out.println("2 - Sacar");
            System.out.println("3 - Depositar");
            System.out.println("4 - Transferir");
            System.out.println("5 - Sair");

            int opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    imprimirSaldos(clientes, saldos);
                    break;
                case 2:
                    interacaoSacar(saldos);
                    break;
                case 3:
                    interacaoDepositar(saldos);
                    break;
                case 4:
                    interacaoTransferir(saldos);
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }

        entrada.close();
        System.out.println("Fim do programa!");
    }
}
```

---

# 📚 Conceitos Trabalhados

* Vetores
* Matrizes bidimensionais
* Estrutura de repetição (`while`)
* Estrutura condicional (`switch`)
* Modularização
* Separação de responsabilidades
* Validação de entrada
* Passagem de parâmetros
* Métodos estáticos
