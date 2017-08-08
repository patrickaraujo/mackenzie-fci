/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp1v2;

import java.util.ArrayList;

/**
 *
 * @author Patrick
 */
public abstract class Estudante {
    protected int codigo;
    protected String nome;
    protected String email;
    protected ArrayList <Matricula> matricula;
    
    public Estudante(int codigo, String nome, String email){
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        matricula = new ArrayList<Matricula>();
    }
    
    public int getId() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
    
    public int getTotalCreditos(){
        int j = 0;
        for(int i = 0; i < matricula.size(); i++){
            Disciplina a = matricula.get(i).getDisciplina();
            j+=a.getCreditos();
        }
        return j;
    }

    public void addMatriculas(Estudante estudante, Disciplina disciplina) {
        matricula.add(new Matricula(estudante, disciplina));
    }
    
    public ArrayList <Matricula> getMatriculas() {
        return matricula;
    }
    
    public ArrayList <Disciplina> getDisciplinasMatriculadas(){
        ArrayList <Disciplina>  disciplina = new ArrayList<Disciplina>();
        for(int i = 0; i < matricula.size(); i++)
            disciplina.add(matricula.get(i).getDisciplina());
        return disciplina;
    }
    
}
