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
public class CommercialInfo {
    private String dadosComerciaisFuncao;
    private String dadosComerciasEmpresa;

    public CommercialInfo(String dadosComerciaisFuncao, String dadosComerciasEmpresa) {
        this.dadosComerciaisFuncao = dadosComerciaisFuncao;
        this.dadosComerciasEmpresa = dadosComerciasEmpresa;
    }

    public String getDadosComerciaisFuncao() {
        return dadosComerciaisFuncao;
    }

    public String getDadosComerciasEmpresa() {
        return dadosComerciasEmpresa;
    }

    public void setDadosComerciaisFuncao(String dadosComerciaisFuncao) {
        this.dadosComerciaisFuncao = dadosComerciaisFuncao;
    }

    public void setDadosComerciasEmpresa(String dadosComerciasEmpresa) {
        this.dadosComerciasEmpresa = dadosComerciasEmpresa;
    }
    
}
