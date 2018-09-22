/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ProjetoConfeccao.Pojo;

import java.util.Date;

/**
 *
 * @author randel
 */
public class Ponto {
    private int id_ponto;
    private int id_funcionario;
    private String hora_saida_1;
    private String hora_saida_2;
    private String hora_entrada_1;
    private String hora_entrada_2;
    private double valor_da_falta;
    private Date data;
    private boolean falta;
    private String justificativa;

    public int getId_ponto() {
        return id_ponto;
    }

    public void setId_ponto(int id_ponto) {
        this.id_ponto = id_ponto;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public String getHora_saida_1() {
        return hora_saida_1;
    }

    public void setHora_saida_1(String hora_saida_1) {
        this.hora_saida_1 = hora_saida_1;
    }

    public String getHora_saida_2() {
        return hora_saida_2;
    }

    public void setHora_saida_2(String hora_saida_2) {
        this.hora_saida_2 = hora_saida_2;
    }

    public String getHora_entrada_1() {
        return hora_entrada_1;
    }

    public void setHora_entrada_1(String hora_entrada_1) {
        this.hora_entrada_1 = hora_entrada_1;
    }

    public String getHora_entrada_2() {
        return hora_entrada_2;
    }

    public void setHora_entrada_2(String hora_entrada_2) {
        this.hora_entrada_2 = hora_entrada_2;
    }

    public double getValor_da_falta() {
        return valor_da_falta;
    }

    public void setValor_da_falta(double valor_da_falta) {
        this.valor_da_falta = valor_da_falta;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public boolean isFalta() {
        return falta;
    }

    public void setFalta(boolean falta) {
        this.falta = falta;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }    
}
