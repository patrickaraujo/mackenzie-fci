# Operações de Conjuntos em Vetores (União e Intersecção)

Este módulo implementa lógica de teoria de conjuntos aplicada a arrays em Java, gerando conjuntos aleatórios e extraindo relacionamentos entre eles.

## Operações Implementadas
1. **Geração de Vetor Aleatório (`generateVector`):** Preenche arrays com dígitos de 0 a 9.
2. **Busca Linear (`busca`):** Varre o array sequencialmente para verificar a existência de um elemento alvo.
3. **União (`union`):** Concatena dois vetores distintos, gerando um terceiro vetor com a capacidade ajustada.
4. **Intersecção (`intersection`):** Compara as entradas de dois vetores e constrói um novo array contendo exclusivamente os elementos que habitam ambos os conjuntos.

## Funcionamento
O método de intersecção utiliza a Busca Linear internamente. Para cada item do `Vetor 1`, ele verifica se este mesmo item existe no `Vetor 2`. Se sim, adiciona ao vetor resultante. Para evitar o desperdício de memória, a classe `Arrays.copyOf` é acionada ao final do processo para enxugar as sobras nulas (`0`) do array.
