/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula7;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author 41318862
 */
public class Bank {
    private ArrayList <BankAccount>  accounts;
    private ArrayList <SavingsAccount>  savingsAccount;
    private ArrayList <SavingsAccount>  allAccounts;
    private int last;
    
    public Bank() {
        accounts = new ArrayList<BankAccount>();
    }
    
    public Bank(String file)throws IOException {
        accounts = new ArrayList<BankAccount>();
        savingsAccount = new ArrayList<SavingsAccount>();
        allAccounts = new ArrayList<SavingsAccount>();
        BufferedReader entrada = new BufferedReader(new FileReader(file));
        String linha = entrada.readLine();  // lê a primeira linha
        // String vetorStr[] = linha.split("#");
        int i = 0;
        while (linha != null) {
            linha = entrada.readLine();
            i++;
        }
        // passaDados(file, i, vetorStr.length);
        passaDados(file, i);
        entrada.close();
    }
    
    
    public void passaDados(String file, int i) throws IOException {
        BufferedReader entrada = new BufferedReader(new FileReader(file));
        String linha;
        int nConta = 0;
        String senha = "";
        String nome = "";
        for(int k = 0; k < i; k++){
            double balance = 0;
            linha = entrada.readLine();
            String vetorStr[] = linha.split("#");
            if(vetorStr.length > 4)
                for(int l = 0; l < vetorStr.length; l++){
                    if(l == 0)
                        nConta = Integer.parseInt(vetorStr[l]);
                    else if(l == 1)
                        senha = vetorStr[l];
                    else if(l == 2)
                        nome = vetorStr[l];
                    else if(l == 3)
                        balance = Double.parseDouble(vetorStr[l]);
                    else{
                        savingsAccount.add(new SavingsAccount(nConta, senha, nome, balance, Double.parseDouble(vetorStr[l])));
                        allAccounts.add(new SavingsAccount(nConta, senha, nome, balance, Double.parseDouble(vetorStr[l])));
                    }
                }
            else
                for(int l = 0; l < vetorStr.length; l++){
                    if(l == 0)
                        nConta = Integer.parseInt(vetorStr[l]);
                    else if(l == 1)
                        senha = vetorStr[l];
                    else if(l == 2)
                        nome = vetorStr[l];
                    else{
                        accounts.add(new BankAccount(nConta, senha, nome, Double.parseDouble(vetorStr[l])));
                        allAccounts.add(new SavingsAccount(nConta, senha, nome, (Double.parseDouble(vetorStr[l])), 0.0));
                    }
                }
        }
        entrada.close();
    }
    
    public void dump() throws IOException{
        BufferedWriter w = new BufferedWriter(new FileWriter("dump.txt"));
        for(int i = 0; i < accounts.size(); i++){
            String linha = +(accounts.get(i).getAccountNumber())+"\t"+(accounts.get(i).getPassword())+"\t"+(accounts.get(i).getOwner())+"\t"+(accounts.get(i).getBalance());
            w.write(linha);
            w.newLine();
        }
        w.flush();
        w.close();
        
    }
    
    public void dumpAll() throws IOException{
        BufferedWriter w = new BufferedWriter(new FileWriter("dumpAll.txt"));
        for(int i = 0; i < allAccounts.size(); i++){
            String linha = +(allAccounts.get(i).getAccountNumber())+"\t"+(allAccounts.get(i).getPassword())+"\t"+(allAccounts.get(i).getOwner())+"\t"+(allAccounts.get(i).getBalance())+"\t"+(allAccounts.get(i).getInterestRate());
            w.write(linha);
            w.newLine();
        }
        w.flush();
        w.close();
        
    }
    
    public void sort() {
        for ( int i = 0; i < ( accounts.size() - 1 ); i++ ) {
            int index = i;
            for ( int j = i + 1; j < accounts.size(); j++ )
                if ((accounts.get(j).getAccountNumber()) < (accounts.get(index).getAccountNumber()))
                    index = j;
                BankAccount smallerNumber = accounts.get(index);
                accounts.set(index, accounts.get(i));
                accounts.set(i, smallerNumber);
        }
    }
    
    public void sortBalance() {
        for ( int i = 0; i < ( allAccounts.size() - 1 ); i++ ) {
            int index = i;
            for ( int j = i + 1; j < allAccounts.size(); j++ )
                if ((allAccounts.get(j).getBalance()) < (allAccounts.get(index).getBalance()))
                    index = j;
                SavingsAccount smallerNumber = allAccounts.get(index);
                allAccounts.set(index, allAccounts.get(i));
                allAccounts.set(i, smallerNumber);
        }
    }
    
    public void addAccount(BankAccount a){
        accounts.add(a);
    }
    
    public double getTotalBalance(){
        double soma = 0.0;
        for(BankAccount a: accounts)
            soma += a.getBalance();
        return soma;
    }
    
    public String buscaBinaria(int valor){
        int menor = 0;
        int maior = ( accounts.size() - 1 );
        
        while (menor <= maior){
            int meio = (menor+maior)/2;
            if(valor > (accounts.get(meio).getAccountNumber()))
                menor = meio-1;
            else if(valor < (accounts.get(meio).getAccountNumber()))
                maior = meio+1;
            else
                return "Número da conta: "+(accounts.get(meio).getAccountNumber())+"\nProprietário: "+(accounts.get(meio).getOwner())+"\nSaldo: "+(accounts.get(meio).getBalance())+"\nSenha: "+(accounts.get(meio).getPassword());
        }
        return null;
    }
    
    public String find(int valor){
        int menor = 0;
        int maior = ( allAccounts.size() - 1 );
        
        while (menor <= maior){
            int meio = (menor+maior)/2;
            if(valor > (allAccounts.get(meio).getAccountNumber()))
                menor = meio-1;
            else if(valor < (allAccounts.get(meio).getAccountNumber()))
                maior = meio+1;
            else
                return "Número da conta: "+(allAccounts.get(meio).getAccountNumber())+"\nProprietário: "+(allAccounts.get(meio).getOwner())+"\nSaldo: R$"+(allAccounts.get(meio).getBalance())+"(Juros de "+(allAccounts.get(meio).getInterestRate())+"%)\nSenha: "+(allAccounts.get(meio).getPassword());
        }
        return null;
    }
    
    
    public void changeAccount(BankAccount oldAccount, BankAccount newAccount){
        int x = oldAccount.getAccountNumber();
        for (SavingsAccount a: allAccounts)
            if ( a.getAccountNumber() == x)
                a = (SavingsAccount) newAccount;
        if(x == newAccount.getAccountNumber())
            oldAccount = newAccount;
    }
    
    public void importAccounts(Bank b){
        ArrayList<BankAccount> x = b.getAllBankAccounts();
        for(int i = 0; i < x.size(); i++)
            accounts.add(x.get(i));
    }
    
    public ArrayList<BankAccount> getAllBankAccounts(){
        return accounts;
    }
    
    /*
    public String find(int accountNumber){ //Devolve a conta vinculada a um número de conta
         for (BankAccount c : accounts)   
            if ( c.getAccountNumber() == accountNumber )
                return "Número da conta: "+c.getAccountNumber()+"\nProprietário: "+c.getOwner()+"\nSaldo: "+c.getBalance()+"\nSenha: "+c.getPassword();
         return null;
    }
    */
    
}
