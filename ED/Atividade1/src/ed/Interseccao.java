/*
    Escreva uma fun�ao que efetua a interseccao entre dois vetores, ja previamente ordenados. Consider que os vetores tem o mesmo tamanho.
    Resolva a funcao com complexidade O(n), onde eh o tamanho do vetor
 */
package ed;

public class Interseccao {

    public static void Inter(int A[], int B[]) {
        int N = A.length;
        int i = 0, j = 0;
        while (i < N && j < N) {
            if (A[i] < B[j]) {
                i++;
            } else if (A[i] > B[j]) {
                j++;
            } else { // A[i]==B[j]
                System.out.print(A[i] + " ");
                i++;
                j++;
            }
        }

    }

    public static void main(String args[]) {
        int A[] = {5, 15, 21, 22, 31, 37, 40, 41};
        int B[] = {20, 21, 22, 33, 37, 38, 39, 40};

        Inter(A, B);

        System.out.println();

    }
    
}
