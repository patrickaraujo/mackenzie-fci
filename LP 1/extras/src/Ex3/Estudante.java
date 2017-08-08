/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex3;

/**
 *
 * @author Patrick
 */
public class Estudante extends Pessoa implements Motivacao{
    
    private double mediaGeral;
    private String tia;
    
    public Estudante(String nome, int anoNascimento, String tia, double mediaGeral){
        super(nome, anoNascimento);
        this.mediaGeral = mediaGeral;
        this.tia = tia;
    }
    
    public Estudante(){
        super("não identificado", 1900);
        this.mediaGeral = 0;
        this.tia = "";
    }
    
    public double getMediaGeral(){
        return mediaGeral;
    }
    
    public String getTia(){
        return tia;
    }
    
    public void incentiva(double x){
        this.mediaGeral+=x;
    }
    
    public void setMediaGeral(double mediaGeral){
        this.mediaGeral = mediaGeral;
    }
    
    public void setTia(String tia){
        this.tia = tia;
    }
    
}
