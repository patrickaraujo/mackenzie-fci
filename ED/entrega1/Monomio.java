/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entrega1;

/**
 *
 * @author 41318862
 */
public class Monomio {
    private char variavel;
    private int coeficiente;
    private int potencia;
    
    public Monomio(String monomio){
        String num = "";
        for(int i = 1; i < monomio.indexOf("x"); i++)
            num+= monomio.charAt(i);
        int coeficiente = Integer.parseInt(num);
        // usar indexof
        if((monomio.charAt(0)) == '-')
            coeficiente = coeficiente-coeficiente-coeficiente;
        this.coeficiente = coeficiente;
        String pot="";
        for(int i = monomio.indexOf("x")+1; i < monomio.length(); i++)
            pot+= monomio.charAt(i);
        potencia = Integer.parseInt(pot);
        variavel = monomio.charAt(monomio.indexOf("x"));
    }

    public Monomio(char variavel, int coeficiente, int potencia) {
        this.variavel = variavel;
        this.coeficiente = coeficiente;
        this.potencia = potencia;
    }
    
    public int calculaMon(int x){
        int resultado = (int)(coeficiente*(Math.pow(x, potencia)));
        return resultado;
    }
    
    public Monomio soma(int x){
        Monomio newMonomio = new Monomio(variavel, (coeficiente+x), potencia);
        return newMonomio;
    }

    public int getCoeficiente() {
        return coeficiente;
    }
    
    public int getPotencia(){
        return this.potencia;
    }
    
    public String getMon(){
        return ""+coeficiente+variavel+potencia;
    }
}
