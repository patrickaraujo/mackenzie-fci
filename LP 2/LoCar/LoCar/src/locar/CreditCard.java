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
public class CreditCard {
    private long numCartao;
    private String bandeira;
    private int codSeguranca;
    private String nomeCartao;
    private int parcelas;

    public CreditCard(long numCartao, String bandeira, int codSeguranca, String nomeCartao, int parcelas) {
        this.numCartao = numCartao;
        this.bandeira = bandeira;
        this.codSeguranca = codSeguranca;
        this.nomeCartao = nomeCartao;
        this.parcelas = parcelas;
    }

    public long getNumCartao() {
        return numCartao;
    }

    public String getBandeira() {
        return bandeira;
    }

    public int getCodSeguranca() {
        return codSeguranca;
    }

    public String getNomeCartao() {
        return nomeCartao;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setNumCartao(long numCartao) {
        this.numCartao = numCartao;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public void setCodSeguranca(int codSeguranca) {
        this.codSeguranca = codSeguranca;
    }

    public void setNomeCartao(String nomeCartao) {
        this.nomeCartao = nomeCartao;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }
}