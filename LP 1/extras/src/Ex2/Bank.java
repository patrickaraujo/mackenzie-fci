/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex2;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author 41318862
 */
public class Bank {
    private ArrayList <BankAccount> accounts;
    private ArrayList <SavingsAccount> savingsAccount;
    private ArrayList <BankAccount> allAccounts;
    private int last;
    
    public Bank() {
        accounts = new ArrayList<BankAccount>();
    }
    
    public Bank(String file)throws IOException {
        accounts = new ArrayList<BankAccount>();
        savingsAccount = new ArrayList<SavingsAccount>();
        allAccounts = new ArrayList<BankAccount>();
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
                        allAccounts.add(new BankAccount(nConta, senha, nome, balance));
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
    
    /*
    public void dump() throws IOException{
        BufferedWriter w = new BufferedWriter(new FileWriter("dumpExtra.txt"));
        for(int i = 0; i < accounts.size(); i++){
            String linha = +(accounts.get(i).getAccountNumber())+"\t"+(accounts.get(i).getPassword())+"\t"+(accounts.get(i).getOwner())+"\t"+(accounts.get(i).getBalance());
            w.write(linha);
            w.newLine();
        }
        w.flush();
        w.close();  
    }
    */
    
    public void dump() throws IOException{
        BufferedWriter w = new BufferedWriter(new FileWriter("dumpAllExtras.txt"));
        for(int i = 0; i < allAccounts.size(); i++){
            String linha="";
            if((getSavings(allAccounts.get(i).getAccountNumber())) != null)
                linha+= "CP\t"+(allAccounts.get(i).getAccountNumber())+"\t"+(allAccounts.get(i).getPassword())+"\t"+(allAccounts.get(i).getOwner())+"\t"+(allAccounts.get(i).getBalance())+"\t"+((getSavings(allAccounts.get(i).getAccountNumber())).getInterestRate());
            else
                linha+= "CC\t"+(allAccounts.get(i).getAccountNumber())+"\t"+(allAccounts.get(i).getPassword())+"\t"+(allAccounts.get(i).getOwner())+"\t"+(allAccounts.get(i).getBalance());
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

    public void sort(ArrayList <BankAccount> ord) {
        for ( int i = 0; i < ( ord.size() - 1 ); i++ ) {
            int index = i;
            for ( int j = i + 1; j < ord.size(); j++ )
                if ((ord.get(j).getAccountNumber()) < (ord.get(index).getAccountNumber()))
                    index = j;
                BankAccount smallerNumber = ord.get(index);
                ord.set(index, ord.get(i));
                ord.set(i, smallerNumber);
        }
    }
    
    public void sortBalance() {
        for ( int i = 0; i < ( allAccounts.size() - 1 ); i++ ) {
            int index = i;
            for ( int j = i + 1; j < allAccounts.size(); j++ )
                if ((allAccounts.get(j).getBalance()) < (allAccounts.get(index).getBalance()))
                    index = j;
                BankAccount smallerNumber = allAccounts.get(index);
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
    
    public String find(int valor){
        int menor = 0;
        int maior = ( allAccounts.size() - 1 );
        
        while (menor <= maior){
            int meio = (menor+maior)/2;
            String linha;
            if(valor > (allAccounts.get(meio).getAccountNumber()))
                menor = meio-1;
            else if(valor < (allAccounts.get(meio).getAccountNumber()))
                maior = meio+1;
            else{
                if((getSavings(allAccounts.get(meio).getAccountNumber())) != null)
                    linha = "Conta Poupança\nNúmero da conta: "+(allAccounts.get(meio).getAccountNumber())+"\nProprietário: "+(allAccounts.get(meio).getOwner())+"\nSaldo: R$"+(allAccounts.get(meio).getBalance())+"(Juros de "+((getSavings(allAccounts.get(meio).getAccountNumber())).getInterestRate())+"%)\nSenha: "+(allAccounts.get(meio).getPassword());
                else
                    linha = "Conta Corrente\nNúmero da conta: "+(allAccounts.get(meio).getAccountNumber())+"\nProprietário: "+(allAccounts.get(meio).getOwner())+"\nSaldo: R$"+(allAccounts.get(meio).getBalance())+"\nSenha: "+(allAccounts.get(meio).getPassword());
                return linha;
            }
        }
        return null;
    }
    
    
    public void changeAccount(BankAccount oldAccount, BankAccount newAccount){
        for (BankAccount a: allAccounts)
            if ( a.getAccountNumber() == oldAccount.getAccountNumber()){
                if((getSavings(a.getAccountNumber())) != null)
                    for(BankAccount b: accounts)
                        if ( b.getAccountNumber() == oldAccount.getAccountNumber()){
                            a = newAccount;
                            b = newAccount;
                    }
                else
                    for (SavingsAccount c: savingsAccount)
                        if ( c.getAccountNumber() == oldAccount.getAccountNumber()){
                            a = newAccount;
                            c = (SavingsAccount) newAccount;
                        }
            }
    }
    
    public void importAccounts(Bank b){
        ArrayList<BankAccount> x = b.getAllBankAccounts();
        ArrayList<SavingsAccount> y = b.getAllSavingsAccounts();
        for(BankAccount a: x){
            accounts.add(a);
            allAccounts.add(a);
        }
        for(SavingsAccount c: y){
            allAccounts.add(c);
            savingsAccount.add(c);
        }
    }
    
    public ArrayList<BankAccount> getAllAccounts(){
        return allAccounts;
    }
    
    public ArrayList<BankAccount> getAllBankAccounts(){
        return accounts;
    }
    
    public ArrayList<SavingsAccount> getAllSavingsAccounts(){
        return savingsAccount;
    }
    
    public SavingsAccount getSavings(int x) {
        for(SavingsAccount y: savingsAccount)
            if(y.getAccountNumber() == x)
                return y;
        return null;
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
