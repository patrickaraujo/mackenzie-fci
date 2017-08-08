/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locar;

/**
 *
 * @author Patrick
 */
public class CommercialAdress {
    private long cep;
    private String endereco;
    private int endNum;
    private String cidade;
    private String estado;
    private long telefone;
    private long celular;

    public void setCep(long cep) {
        this.cep = cep;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setEndNum(int endNum) {
        this.endNum = endNum;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    public long getCep() {
        return cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getEndNum() {
        return endNum;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public long getTelefone() {
        return telefone;
    }

    public long getCelular() {
        return celular;
    }

    public CommercialAdress(long cep, String endereco, int endNum, String cidade, String estado, long telefone, long celular) {
        this.cep = cep;
        this.endereco = endereco;
        this.endNum = endNum;
        this.cidade = cidade;
        this.estado = estado;
        this.telefone = telefone;
        this.celular = celular;
    }
}
