/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ProjetoConfeccao.Pojo;
/**
 *
 * @author randel
 */
public class Extra {
    private int id_extra;
    private double valor;
    private String hora;
    
    public int getId_extra() {
        return id_extra;
    }

    public void setId_extra(int id_extra) {
        this.id_extra = id_extra;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }   
}