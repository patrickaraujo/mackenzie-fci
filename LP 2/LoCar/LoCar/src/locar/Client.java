/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locar;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Patrick
 */
public class Client extends Person{
    private boolean cnhTipoB;
    private long cnhNumero;
    private Date cnhValidade;
    private long cnhNumRegistro;
    private ArrayList<Booking> reservas;
    private CommercialAdress endComerciais;
    private CommercialInfo dadosComerciais;
    private String passaporte;
    
    public Client(String nome, boolean sex, long cpf, long cnpj, long rg, String nacionalidade, String email, String senha, long id, long telfixo, long telCel, Date primeiroAcesso, Date ultimoAcesso, boolean cnhTipoB, long cnhNumero, Date cnhValidade, long cnhNumRegistro, ArrayList<Booking> reservas, CommercialAdress endComerciais, CommercialInfo dadosComerciais, String passaporte) {
        super(nome, sex, cpf, cnpj, rg, nacionalidade, email, senha, id, telfixo, telCel, primeiroAcesso, ultimoAcesso);
        this.cnhTipoB = cnhTipoB;
        this.cnhNumero = cnhNumero;
        this.cnhValidade = cnhValidade;
        this.cnhNumRegistro = cnhNumRegistro;
        this.reservas = reservas;
        this.endComerciais = endComerciais;
        this.dadosComerciais = dadosComerciais;
        this.passaporte = passaporte;
    }

    public boolean isCnhTipoB() {
        return cnhTipoB;
    }

    public long getCnhNumero() {
        return cnhNumero;
    }

    public Date getCnhValidade() {
        return cnhValidade;
    }

    public long getCnhNumRegistro() {
        return cnhNumRegistro;
    }

    public ArrayList<Booking> getReservas() {
        return reservas;
    }

    public CommercialAdress getEndComerciais() {
        return endComerciais;
    }

    public CommercialInfo getDadosComerciais() {
        return dadosComerciais;
    }

    public String getPassaporte() {
        return passaporte;
    }

    public void setCnhTipoB(boolean cnhTipoB) {
        this.cnhTipoB = cnhTipoB;
    }

    public void setCnhNumero(long cnhNumero) {
        this.cnhNumero = cnhNumero;
    }

    public void setCnhValidade(Date cnhValidade) {
        this.cnhValidade = cnhValidade;
    }

    public void setCnhNumRegistro(long cnhNumRegistro) {
        this.cnhNumRegistro = cnhNumRegistro;
    }

    public void setReservas(ArrayList<Booking> reservas) {
        this.reservas = reservas;
    }

    public void setEndComerciais(CommercialAdress endComerciais) {
        this.endComerciais = endComerciais;
    }

    public void setDadosComerciais(CommercialInfo dadosComerciais) {
        this.dadosComerciais = dadosComerciais;
    }

    public void setPassaporte(String passaporte) {
        this.passaporte = passaporte;
    }
}