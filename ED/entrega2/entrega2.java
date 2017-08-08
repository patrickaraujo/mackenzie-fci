/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Patrick
 */
public class entrega2 {
    public boolean questao1(int k, int A[]){
        for (int i = 0; i < A.length-1; i++) {
            for (int j = 0; j < A.length; j++) {
                if(i!=j)
                    if((A[i]+A[j])==k)
                        return true;
            }
        }
        return false;
    }
    
    public void questao2(int a[], int k, int quant){
        a[quant] = k;
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a.length-1; j++)
                if (a[j] > a[j + 1]){
                    int aux = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = aux;
          }
    }
    
    public boolean questao3(int m[][]){
        boolean[] linha = new boolean[m.length];
        boolean[] coluna = new boolean[m[0].length];
        for(int i = 0; i < m.length; i++){
            int k = 0;
            for (int j = 0; j < m[0].length; j++) {
                k+= m[i][j];
            }
            if(k == 1)
                coluna[i] = true;
            else
                coluna[i] = false;
        }
        
        for(int j = 0; j < m[0].length; j++){
            int l = 0;
            for (int i = 0; i < m.length; i++) {
                l+= m[i][j];         
            }
            if(l == 1)
                linha[j] = true;
            else
                linha[j] = false;
        }
        boolean verifica [] = new boolean[(linha.length)+(coluna.length)];
        System.arraycopy(linha, 0, verifica, 0, linha.length);
        System.arraycopy(coluna, 0, verifica, linha.length, coluna.length);

        for(int i = 0; i < verifica.length; i++){
            if(!verifica[i])
                return false;
        }
        return true;
    }
}
