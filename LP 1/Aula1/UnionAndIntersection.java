/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula1;

import java.util.Arrays;

/**
 *
 * @author 41318862
 */
public class UnionAndIntersection {
    public static int [] generateVector(int n){
        int v[]= new int[n];
        for(int i=0;i<n;i++){
            v[i]=(int)(Math.random()*10);//Porque Math.random gera double e só aceita inteiro
        }
        return v;
    }
     
    public static void printVector(int v[]){
        int tam=v.length;
        for(int i=0;i<tam;i++){//O tamanho quer dizer o tamanho do vetor que é de 10 posições
            System.out.print(v[i]+"  ");
        }
        System.out.println();
    }
     
    public static boolean busca(int v[],int x){
        int tam=v.length;
            for(int i=0;i<tam;i++){
            if(v[i]==x){
                return true;
            }
        }
        return false;
    }
     
    public static int[] union(int v[],int w[]){
        int uniao[]=new int[v.length+w.length];
        int k=v.length;
        uniao=Arrays.copyOf(v,v.length+w.length);
        for(int i=0;i<w.length;i++){
            //if(busca(v,w[i])){ 
                uniao[k]=w[i];
                k++;
            //}
        }
        uniao=Arrays.copyOf(uniao, k);
        return uniao;
    }
    /*
    public static int[] inter(int v[],int w[]){
        int tam;
        if(v.length >= w.length)
            tam = w.length;
        else
            tam = v.length;
        int inter[]=new int[tam];
        int k = 0;
        for(int i = 0; i < v.length; i++){
            if(busca(w, v[i])){
                inter[k] = v[i];
                k++;
            }
        }
        return inter;
    }
    */
    public static int[] intersection(int v[],int w[]){
        int tam;
        if(v.length >= w.length)
            tam = w.length;
        else
            tam = v.length;
        int inter[]=new int[tam];
        int k=0;
        for(int i=0;i<v.length;i++){
            if(busca(w,v[i])){
                inter[k]=v[i];
                k++;
            }
             
        }
        inter=Arrays.copyOf(inter, k);
        return inter;
    }
     
    public static void main(String args[]){
        int vet[]=generateVector(10);
        int vet2[]=generateVector(15);
        System.out.println("Vetor 1");
        printVector(vet);
        System.out.println("Vetor 2");
        printVector(vet2);
        int x=7;
        boolean achou=busca(vet,x);
        if(achou){
            System.out.println("7 esta no vetor");
        }
        else{
            System.out.println("7 não esta no vetor");
        }
        System.out.println("União: ");
        int u[]=union(vet,vet2);
        int inters[]=intersection(vet,vet2);
        printVector(u);
        System.out.println("Intersecção: ");
        printVector(inters);
    }
}
