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
public class Disciplina {
    private String codigo;
    private int creditos;
    private ArrayList <Matricula> matricula;
    
    public Disciplina(String codigo, int creditos){
        this.codigo = codigo;
        this.creditos = creditos;
        matricula = new ArrayList<Matricula>();
    }
    
    public String getCodigo() {
        return codigo;
    }

    public int getCreditos() {
        return creditos;
    }
    
    public void addMatriculas(Estudante estudante, Disciplina disciplina) {
        matricula.add(new Matricula(estudante, disciplina));
    }
    
    public ArrayList <Matricula> getMatriculas() {
        return matricula;
    }
    
    public ArrayList <Estudante> getEstudantesMtriculados(){
        ArrayList <Estudante>  estudante = new ArrayList<Estudante>();
        for(int i = 0; i < matricula.size(); i++)
            estudante.add(matricula.get(i).getEstudante());
        return estudante;
    }
    
}
