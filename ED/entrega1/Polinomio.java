/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entrega1;

import java.util.ArrayList;

/**
 *
 * @author 41318862
 */
public class Polinomio {
    private ArrayList <Monomio> monomios;

    public Polinomio(ArrayList<Monomio> monomios) {
        this.monomios = monomios;
    }

    public Polinomio(String polinomio) throws Exception{
        monomios = new ArrayList<Monomio>();
        transformation(polinomio);
    }
    
    public void transformation(String polinomio) throws Exception{
        String vetor[] = toArrayString(polinomio);
        if(((vetor[0].charAt(0)) != '+') || ((vetor[0].charAt(0)) != '-'))
            vetor[0] = "+"+vetor[0];
        for(int j = 0; j < vetor.length; j++){
            if ((vetor[j]).charAt(vetor[j].length()-1) == 'x')
                vetor[j] = vetor[j]+"1";
            if (!((vetor[j]).contains("x")))
                vetor[j] = vetor[j]+"x0";
            if ((vetor[j]).charAt(1) == 'x'){
                vetor[j] = vetor[j].replaceFirst("x", "1x");
            }
        }
        // if ((vetor[vetor.length-2]).charAt(vetor[vetor.length-2].length()-1) == 'x')
            // vetor[vetor.length-2] = vetor[vetor.length-2]+"1";
        // if ((vetor[vetor.length-1]).length() == 2)
            // vetor[vetor.length-1] = vetor[vetor.length-1]+"x0";
        for(int i = 0; i <= vetor.length-2; i++){
            String pot1 = "";
            String pot2 = "";
            for(int j = vetor[i].indexOf("x")+1; j < vetor[i].length(); j++)
                pot1+= vetor[i].charAt(j);
            for(int k = vetor[i+1].indexOf("x")+1; k < vetor[i+1].length(); k++)
                pot2+= vetor[i+1].charAt(k);
            if((Integer.parseInt(pot1)) < (Integer.parseInt(pot2)))
                throw new Exception("Não está em ordem decrescente");
            monomios.add(new Monomio(vetor[i]));
            if(i == vetor.length-2)
                monomios.add(new Monomio(vetor[i+1]));
        }
    }
    
    public String[] toArrayString(String polinomio){
        ArrayList <String>  monomios = new ArrayList<String>();
        String vetorStr[] = polinomio.split("[()]");
        for (String a: vetorStr)
            if(!(a.isEmpty()))
                monomios.add(new String(a));
        String newVector [] = new String[monomios.size()];
        for(int i = 0; i < monomios.size(); i++)
            newVector[i] = monomios.get(i).toString();
        return newVector;
    }

    public ArrayList<Monomio> getMonomios() {
        return monomios;
    }
    
    public long calcula(int x){
        long resultado = 0;
        for(Monomio a: monomios)
            resultado+= a.calculaMon(x);
        return resultado;
    }
    
    public Polinomio soma(Polinomio x){
        ArrayList <Monomio> newMonomio = new ArrayList<>();
        ArrayList <Monomio> new1 = new ArrayList<>();
        new1.addAll(monomios);
        ArrayList <Monomio> new2 = new ArrayList<>();
        new2.addAll(x.getMonomios());
        for(Monomio a: monomios){
            for(int i = 0; i < x.getMonomios().size(); i++)
                if(a.getPotencia() == x.getMonomios().get(i).getPotencia()){
                    newMonomio.add(a.soma(x.getMonomios().get(i).getCoeficiente()));
                    new1.remove(a);
                    new2.remove(x.getMonomios().get(i));
                }
        }
        newMonomio.addAll(new1);
        newMonomio.addAll(new2);
        ordenar(newMonomio);
        Polinomio newPolinomio = new Polinomio(newMonomio);
        
        return newPolinomio;
    }
    
    public void ordenar(ArrayList <Monomio> array) {
        for (int i = 0; i < array.size(); i++)
            for (int j = 0; j < array.size()-1; j++)
                if (array.get(j).getPotencia() < array.get(j+1).getPotencia()){
                    Monomio aux = array.get(j);
                    array.set(j, array.get(j+1));
                    array.set(j+1, aux);
                }
    }

    
    public String getPolinomios(){
        String b = "";
        for(Monomio a: monomios){
            b += a.getMon()+"\n";
        }
        return b;
    }
    
}
