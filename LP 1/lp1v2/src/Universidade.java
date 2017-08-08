/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp1v2;

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
    private ArrayList <EstudanteGrad> estGrad;
    private ArrayList <EstudantePos> estPos;
    private ArrayList <Disciplina> disciplina;
    private String nomeUni;
    
    public Universidade(String nomeUni) {
        this.nomeUni = nomeUni;
    }
    
    public void carregarDadosArquivo(String file, String file2, String file3)throws IOException{
        estudantes = new ArrayList<Estudante>();
        estGrad = new ArrayList<EstudanteGrad>();
        estPos = new ArrayList<EstudantePos>();
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
            else if(j == 1){
                if(vetorStr[3].equals("GRAD")){
                    estudantes.add(new EstudanteGrad(Integer.parseInt(vetorStr[0]), vetorStr[1], vetorStr[2], Integer.parseInt(vetorStr[4])));
                    estGrad.add(new EstudanteGrad(Integer.parseInt(vetorStr[0]), vetorStr[1], vetorStr[2], Integer.parseInt(vetorStr[4])));
                }
                else{
                    estudantes.add(new EstudantePos(Integer.parseInt(vetorStr[0]), vetorStr[1], vetorStr[2], vetorStr[4], vetorStr[5]));
                    estPos.add(new EstudantePos(Integer.parseInt(vetorStr[0]), vetorStr[1], vetorStr[2], vetorStr[4], vetorStr[5]));
                }
            }
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
            if(getDetailEstGrad(estudantes.get(i)) != null)
                allStudents+= getDetailEstGrad(estudantes.get(i));
            else
                allStudents+= getDetailEstPos(estudantes.get(i));
        }
        return allStudents;
    }
    
    public String getDetailEstGrad(Estudante x){
        for (EstudanteGrad a: estGrad)
            if ( a.getId() == x.getId())
                return "GRADUAÇÃO\tId: "+a.getId()+"\tNome: "+a.getNome()+"\tCréditos: "+a.getTotalCreditos()+a.getHrs()+"\tHoras complementares: "+a.getHrs()+"\n";
        return null;
    }
    
    public String getDetailEstPos(Estudante x){
        for (EstudantePos a: estPos)
            if ( a.getId() == x.getId())
                return "PÓS-GRADUAÇÃO\tId: "+a.getId()+"\tNome: "+a.getNome()+"\tCréditos: "+a.getTotalCreditos()+"\tTema: "+a.getTema()+"\tOrientador: "+a.getOrientador()+"\n";
        return null;
    }
    
    public String findStudentsBySubject(String x){
        Disciplina achou = findDisciplina(x);
        ArrayList <Matricula> allStudents = achou.getMatriculas();
        String allStud = "";
        for(int i = 0; i < allStudents.size(); i++){
            Estudante a = allStudents.get(i).getEstudante();
            if(getDetailEstGrad(estudantes.get(i)) != null)
                allStud+= getDetailEstGrad(estudantes.get(i));
            else
                allStud+= getDetailEstPos(estudantes.get(i));
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
