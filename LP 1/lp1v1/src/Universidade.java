/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp1v1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Patrick
 */
public class Universidade {
    private ArrayList <Estudante> estudantes;
    private ArrayList <Disciplina> disciplina;
    private String nomeUni;
    
    public Universidade(String nomeUni) {
        this.nomeUni = nomeUni;
    }
    
    public void carregarDadosArquivo(String file, String file2, String file3)throws IOException{
        estudantes = new ArrayList<Estudante>();
        disciplina = new ArrayList<Disciplina>();
        for(int k = 0; k <= 2; k++){
            
            String nameFile;
            if(k == 0)
                nameFile = file;
            else if (k == 1)
                nameFile = file2;
            else
                nameFile = file3;
            BufferedReader entrada = new BufferedReader(new FileReader(nameFile));
            String linha = entrada.readLine();  // lê a primeira linha
            int i = 0;
            while (linha != null) {
                linha = entrada.readLine();
                i++;
            }
            passaDados(nameFile, i, k);
            entrada.close();
        }
    }
    
    public void passaDados(String file, int i, int j) throws IOException {
        
        BufferedReader entrada = new BufferedReader(new FileReader(file));
        String linha;
        for(int k = 0; k < i; k++){
            linha = entrada.readLine();
            String vetorStr[] = linha.split(":");
            if(j == 0){
                String codigo = "";
                int credito = 0;
                for(int l = 0; l < vetorStr.length; l++)
                    if(l == 0)
                        codigo = vetorStr[l];
                    else
                        disciplina.add(new Disciplina(codigo, Integer.parseInt(vetorStr[l])));
            }
            else if(j == 1)
                estudantes.add(new Estudante(Integer.parseInt(vetorStr[0]), vetorStr[1], vetorStr[2]));
            else{
                int numEst = 0;
                for(int l = 0; l < vetorStr.length; l++)
                    if(l == 0)
                        numEst = Integer.parseInt(vetorStr[l]);
                    else{
                        Disciplina b = findDisciplina(vetorStr[l]);
                        Estudante a = findEstudante(numEst);
                        b.addMatriculas(a, b);
                        a.addMatriculas(a, b);
                    }
            }
        }
        entrada.close();
    }
    
    public Disciplina findDisciplina(String id){
        for (Disciplina c : disciplina)
            if ( c.getCodigo().equals(id) )
                return c;
        return null;
    }
    
    public String getNome(){
        return nomeUni;
    }
    
    public ArrayList<Estudante> getEstudantes(){
        return estudantes;
    }
    
    public ArrayList<Disciplina> getDisciplinas(){
        return disciplina;
    }
    
    public String showAllSubjects(){
        String allSubjects = "";
        for(int i = 0; i < disciplina.size(); i++){
           allSubjects+= disciplina.get(i).getCodigo()+"\n";
        }
        return allSubjects;
    }
    
    public String showAllStudents(){
        String allStudents = "";
        for(int i = 0; i < estudantes.size(); i++){
                allStudents+= estudante(estudantes.get(i))+"\n";
        }
        return allStudents;
    }
    
    public String estudante(Estudante x){
        return +x.getId()+"\t"+x.getNome();
    }
    
    
    public String findStudentsBySubject(String x){
        Disciplina achou = findDisciplina(x);
        ArrayList <Matricula> allStudents = achou.getMatriculas();
        String allStud = "Total de matrículas: "+allStudents.size()+"\nId\tNome\tE-Mail\n";
        for(int i = 0; i < allStudents.size(); i++){
            Estudante a = allStudents.get(i).getEstudante();
            allStud+= estudante(a)+"\t"+a.getEmail()+"\n";
        }
        return allStud;
    }
    
    public Estudante findEstudante(int estudante){
        for (Estudante c: estudantes)
            if ( c.getId() == estudante )
                return c;
        return null;
    }
    
    public String findSubjectsbyStudent(int x){
        Estudante achou = findEstudante(x);
        ArrayList <Matricula> allSubjects = achou.getMatriculas();
        String allSub = "Total de matrículas: "+allSubjects.size()+"\nCódigo\tCréditos\n";
        int j = 0;
        for(int i = 0; i < allSubjects.size(); i++){
            Disciplina a = allSubjects.get(i).getDisciplina();
            allSub+= a.getCodigo()+"\t"+a.getCreditos()+"\n";
            j+=a.getCreditos();
        }
        allSub+= "Total de créditos: "+j;
        return allSub;
    }
    
}
