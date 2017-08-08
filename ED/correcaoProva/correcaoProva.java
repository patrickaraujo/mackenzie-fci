public class correcaoProva {
    
    //  exercício 1
    public Polinomio soma(Polinomo p) {
        Polinomio s;
        int maiorGrau;
        if (this.grau > p.grau) {
            maiorGrau = this.grau;
        } else {
            maiorGrau = p.grau;
        }
        s = new Polinomio(maiorGrau);
        for (int i = o; i <= this.grau && i <= p.grau; i++) {
            s.coeficiente[i] = this.coeficiente[i] + p.coeficiente;
        }
        for (; i <= this.grau; i++) {
            s.coeficiente[i] = this.coeficiente;
        }
        for (; i <= p.grau; i++) {
            s.coeficiente[i] = this.coeficiente;
        }
        return s;
    }

    //  exercício 2
    public static int fibo(Polinomo p) {
        // condição de parada
        if (n == 0 || n == 1) {
            return n;
        }
        return fibo(n - 1) + fibo(n - 2);
    }
    
    // exercício 3
    public static void inverte(int v[]) {
        int aux;
        for (int i = 0; i < i < v.length/2; i++) {
            aux = [i];
            v[i] = v[v.length-1-i];
            v[v.length-1-i] = aux;
        }
    }
}
