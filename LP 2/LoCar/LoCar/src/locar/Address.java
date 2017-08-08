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
public class Address {
    private String cidade;
    private String estado;
    private long cep;
    private String endereco;
    private int endNum;
    private String complemento;

    public Address(String cidade, String estado, long cep, String endereco, int endNum, String complemento) {
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.endereco = endereco;
        this.endNum = endNum;
        this.complemento = complemento;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCep(long cep) {
        this.cep = cep;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setEndNum(int endNum) {
        this.endNum = endNum;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
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

    public String getComplemento() {
        return complemento;
    }
    
}
