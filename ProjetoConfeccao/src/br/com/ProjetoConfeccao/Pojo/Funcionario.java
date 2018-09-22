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
public class Funcionario {

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    private int id_funcionario;
    private int id_tipo;
    private int idade;
    private char sexo;
    private Date data_nascimento;    
    private String telefone_1;
    private String telefone_2;
    private double valor_diaria;
    private double salario;
    private String nome;
    private String rua;
    private String bairro;
    private String cpf;    
    private int qtd_dias_de_trabalho;    
    
    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getTelefone_1() {
        return telefone_1;
    }

    public void setTelefone_1(String telefone_1) {
        this.telefone_1 = telefone_1;
    }

    public String getTelefone_2() {
        return telefone_2;
    }

    public void setTelefone_2(String telefone_2) {
        this.telefone_2 = telefone_2;
    }

    public double getValor_diaria() {
        return valor_diaria;
    }

    public void setValor_diaria(double valor_diaria) {
        this.valor_diaria = valor_diaria;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    
    public int getQtd_dias_de_trabalho() {
        return qtd_dias_de_trabalho;
    }

    public void setQtd_dias_de_trabalho(int qtd_dias_de_trabalho) {
        this.qtd_dias_de_trabalho = qtd_dias_de_trabalho;
    }        
}
