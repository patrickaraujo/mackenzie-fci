/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bombeiros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Patrick
 */
public class Mapa {
    private int empI;
    private ArrayList <EsquinasAd>  esquinas;
    
    public Mapa(String file)throws IOException {
        BufferedReader entrada = new BufferedReader(new FileReader(file));
        String linha = entrada.readLine();
        for (int i = 0; linha != null; i++) {
            String vetorStr[] = linha.split("\t");
            if(i == 0)
                empI = Integer.parseInt(vetorStr[0]);
            else
                esquinas.add(new EsquinasAd((Integer.parseInt(vetorStr[0])), (Integer.parseInt(vetorStr[1]))));
        }
        entrada.close();
    }
}
