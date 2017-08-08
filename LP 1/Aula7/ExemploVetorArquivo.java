/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula7;

import java.io.*;

/**
 *
 * @author 41318862
 */
public class ExemploVetorArquivo {
    public static void main(String [] args){
        try{
            BufferedReader r = new BufferedReader(new FileReader("entrada.txt"));
            BufferedWriter w = new BufferedWriter(new FileWriter("saida.txt"));
            if(r != null){
                String linha = r.readLine();
                int q = Integer.parseInt(linha);
                for(int i = 0; i < q; i++){
                    linha = r.readLine();
                    w.write(linha.toUpperCase());
                    w.newLine();
                }
                r.close();
                w.flush();
                w.close();
            }
        }
        catch(Exception e){
            System.exit(-1);
        }
        
    }
}
