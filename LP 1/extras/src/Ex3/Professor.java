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
public class Professor extends Pessoa implements Motivacao{
    private int anoContratacao;
    private String drt;
    private double reputacao;
    
    public Professor(String nome, int anoNascimento, String drt, int anoContratacao, double reputacao){
        super(nome, anoNascimento);
        this.anoContratacao = anoContratacao;
        this.reputacao = reputacao;
        this.drt = drt;
    }
    
    public Professor(){
        super("não identificado", 1900);
        this.anoContratacao = 1900;
        this.reputacao = 100.0;
        this.drt = "11111111";
    }
    
    public int getAnoContratacao(){
        return anoContratacao;
    }
    
    public String getDrt(){
        return drt;
    }
    
    public double getReputacao(){
        return reputacao;
    }
    
    public void incentiva(double x){
        this.reputacao+=x;
    }
    
    public void setAnoContratacao(int anoContratacao){
        this.anoContratacao = anoContratacao;
    }
    
    public void setDrt(String drt){
        this.drt = drt;
    }
    
    public void serReputacao(double reputacao){
        this.reputacao = reputacao;
    }
    
}
