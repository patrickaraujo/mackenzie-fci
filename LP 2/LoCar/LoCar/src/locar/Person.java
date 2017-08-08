/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locar;

import java.util.Date;

/**
 *
 * @author Patrick
 */
public abstract class Person {
    protected String nome;
    protected boolean sex;
    protected long cpf;
    protected long cnpj;
    protected long rg;
    protected String nacionalidade;
    protected String email;
    protected String senha;
    protected long id;
    protected long telfixo;
    protected long telCel;
    protected Date primeiroAcesso;
    protected Date ultimoAcesso;
    protected Address endereco;

    public Person(String nome, boolean sex, long cpf, long cnpj, long rg, String nacionalidade, String email, String senha, long id, long telfixo, long telCel, Date primeiroAcesso, Date ultimoAcesso) {
        this.nome = nome;
        this.sex = sex;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.rg = rg;
        this.nacionalidade = nacionalidade;
        this.email = email;
        this.senha = senha;
        this.id = id;
        this.telfixo = telfixo;
        this.telCel = telCel;
        this.primeiroAcesso = primeiroAcesso;
        this.ultimoAcesso = ultimoAcesso;
    }

    public String getNome() {
        return nome;
    }

    public boolean isSex() {
        return sex;
    }

    public long getCpf() {
        return cpf;
    }

    public long getCnpj() {
        return cnpj;
    }

    public long getRg() {
        return rg;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public long getId() {
        return id;
    }

    public long getTelfixo() {
        return telfixo;
    }

    public long getTelCel() {
        return telCel;
    }

    public Date getPrimeiroAcesso() {
        return primeiroAcesso;
    }

    public Date getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }

    public void setRg(long rg) {
        this.rg = rg;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTelfixo(long telfixo) {
        this.telfixo = telfixo;
    }

    public void setTelCel(long telCel) {
        this.telCel = telCel;
    }

    public void setPrimeiroAcesso(Date primeiroAcesso) {
        this.primeiroAcesso = primeiroAcesso;
    }

    public void setUltimoAcesso(Date ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }
    
}
