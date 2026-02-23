# Gerenciador Interativo de Coleções em Java (Problema 12)

Este programa simula o comportamento de uma lista dinâmica utilizando **exclusivamente arrays estáticos primitivos** do Java, sem dependência de coleções como ArrayList. Ele permite ao usuário definir o tamanho de uma coleção e realizar operações diversas através de um menu no terminal.

## Funcionalidades Principais

* **Adição de Elementos:** 
  - Inserção no final da lista
  - Inserção em posições específicas com deslocamento automático dos elementos
  
* **Remoção de Elementos:**
  - Exclusão por índice
  - Remoção de todas as ocorrências de um valor específico
  
* **Consultas:**
  - Verificação de existência de elementos
  - Identificação da última posição de um valor
  
* **Soma de Pares (Two Sum):** 
  - Verifica se existem dois números distintos cuja soma resulta em um valor específico
  - Exibe os pares encontrados

## Implementação Técnica

### Controle de Tamanho Lógico
O programa utiliza uma abordagem eficiente para gerenciar arrays estáticos:
- **Variável `quantidadePreenchida`:** Controla o número real de elementos válidos
- **Valor 0 como marcador:** Representa posições vazias no array
- **Função `contarElementosNaoNulos()`:** Calcula dinamicamente o tamanho lógico

### Operações com Arrays Puros
Todas as manipulações são realizadas através de:
- **Deslocamento manual de elementos** usando loops for
- **Realocação in-place** sem criar novos arrays desnecessariamente
- **Atualização automática** do contador após cada operação

### Validações e Tratamento de Erros
- Verificação de array cheio antes de inserções
- Validação de posições inválidas
- Tratamento de vetor vazio em operações de remoção
- Mensagens de erro claras para o usuário

## Considerações Importantes

- **Tamanho máximo:** Limitado a 100 elementos conforme especificação
- **Inicialização:** Começa com 1/4 do array preenchido com valores aleatórios (1-99)
- **Eficiência:** Operações de inserção/remoção em posição específica têm complexidade O(n)
- **Restrições:** Não aceita o valor 0 como elemento válido (usado como marcador de posição vazia)

## Como Executar

1. Compile o arquivo `Problema12.java`
2. Execute o programa
3. Siga as instruções do menu interativo
