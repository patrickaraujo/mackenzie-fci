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
public class EstudantePos extends Estudante{
    private String tema;
    private String orientador;
    
    public EstudantePos(int codigo, String nome, String email, String tema, String orientador){
        super(codigo, nome, email);
        this.tema = tema;
        this.orientador = orientador;
    }
    
    public String getTema(){
        return tema;
    }
    
    public String getOrientador(){
        return orientador;
    }
    
    @Override
    public int getTotalCreditos(){
        return super.getTotalCreditos();
    }
    
    
}
