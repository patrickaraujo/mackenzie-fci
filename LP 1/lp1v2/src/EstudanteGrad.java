/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp1v2;

/**
 *
 * @author Patrick
 */
public class EstudanteGrad extends Estudante{
    private int horas;
    
    public EstudanteGrad(int codigo, String nome, String email, int horas){
        super(codigo, nome, email);
        this.horas = horas;
    }
    
    public int getHrs(){
        return horas;
    }
    
    @Override
    public int getTotalCreditos(){
        return super.getTotalCreditos()+horas;
    }
    
    
}
