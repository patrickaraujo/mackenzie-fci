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
public abstract class Pessoa {
    protected int anoNascimento;
    protected String nome;
    
    public Pessoa(String nome, int anoNascimento){
        this.anoNascimento = anoNascimento;
        this.nome = nome;
    }
    
    public Pessoa(){
        this.anoNascimento = 1900;
        this.nome = "não identificado";
    }
    
    public int getAnoNascimento(){
        return anoNascimento;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setAnoNascimento(int anoNascimento){
        this.anoNascimento = anoNascimento;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
}
