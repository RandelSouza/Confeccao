/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ProjetoConfeccao.Pojo;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author randel
 */
public class Hora {
   
    private String hora;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
    Date horaAtual;
    
    public void lerHora(){
        horaAtual = new Date();
        setHora(simpleDateFormat.format(horaAtual));
    }
    
     public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
