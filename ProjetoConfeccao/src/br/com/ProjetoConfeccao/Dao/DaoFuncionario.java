/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ProjetoConfeccao.Dao;

import br.com.ProjetoConfeccao.Pojo.Funcionario;
import br.com.ProjetoConfeccao.Pojo.Tabela;
import br.com.ProjetoConfeccao.ProjetoConfeccao.ConnectionFactory;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 *
 * @author randel
 */
public class DaoFuncionario {
    ConnectionFactory connect = new ConnectionFactory();
    Funcionario funcionarioPojo = new Funcionario();
    String sql = "";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");   
    DecimalFormat formato = new DecimalFormat("R$ #,##0.00");         
    String sexo;
    String telefone1;
    String telefone2;
    public void salvar(Funcionario funcionarioPojo){
        java.sql.Date dataSQL = new Date(funcionarioPojo.getData_nascimento().getTime());
       
        sql = "INSERT INTO Funcionario(id_tipo, idade, sexo, data_nascimento,"
                + " telefone_1, telefone_2, valor_diaria, salario, nome,"
                + " rua, bairro, qtd_dias_de_trabalho, cpf) "
                + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
               
        try {
            connect.connection();  
            PreparedStatement pst = connect.connect.prepareStatement(sql);
            pst.setInt(1, funcionarioPojo.getId_tipo());
            pst.setInt(2, funcionarioPojo.getIdade());
            pst.setObject(3, funcionarioPojo.getSexo(), java.sql.Types.CHAR);
            pst.setObject(4, dataSQL);
            pst.setString(5, funcionarioPojo.getTelefone_1());
            pst.setString(6, funcionarioPojo.getTelefone_2());
            pst.setDouble(7, funcionarioPojo.getValor_diaria());            
            pst.setDouble(8, funcionarioPojo.getSalario());
            pst.setString(9, funcionarioPojo.getNome());
            pst.setString(10, funcionarioPojo.getRua());
            pst.setString(11, funcionarioPojo.getBairro());
            pst.setInt(12, funcionarioPojo.getQtd_dias_de_trabalho());
            pst.setString(13, funcionarioPojo.getCpf());
            pst.execute();
            connect.disconect();
            JOptionPane.showMessageDialog(null, "Funcionário salvo com êxito!");
        } catch (SQLException ex) {
            Logger.getLogger(DaoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Funcionário não foi salvo!");
        }        
    }
    
    public void editar(Funcionario funcionarioPojo){  
        java.sql.Date dataSQL = new Date(funcionarioPojo.getData_nascimento().getTime());
        
        sql = "UPDATE Funcionario SET id_tipo=?, idade=?, sexo=?, data_nascimento=?, "
                                   + "telefone_1=?, telefone_2=?, valor_diaria=?, salario=?, "
                                   + "nome=?, rua=?, bairro=?, qtd_dias_de_trabalho=?, "
                                   + "cpf=? "
                                   + "WHERE id_funcionario=?;";
        
        try {
            connect.connection();  
            PreparedStatement pst = connect.connect.prepareStatement(sql);
            pst.setInt(1, funcionarioPojo.getId_tipo());
            pst.setInt(2, funcionarioPojo.getIdade());
            pst.setObject(3, funcionarioPojo.getSexo(), java.sql.Types.CHAR);
            pst.setObject(4, dataSQL);
            pst.setString(5, funcionarioPojo.getTelefone_1());
            pst.setString(6, funcionarioPojo.getTelefone_2());
            pst.setDouble(7, funcionarioPojo.getValor_diaria());            
            pst.setDouble(8, funcionarioPojo.getSalario());
            pst.setString(9, funcionarioPojo.getNome());
            pst.setString(10, funcionarioPojo.getRua());
            pst.setString(11, funcionarioPojo.getBairro());
            pst.setInt(12, funcionarioPojo.getQtd_dias_de_trabalho());
            pst.setString(13, funcionarioPojo.getCpf());
            pst.setInt(14, funcionarioPojo.getId_funcionario());
            pst.execute();
            connect.disconect();
            JOptionPane.showMessageDialog(null, "Funcionário Editado com êxito!");
        } catch (SQLException ex) {
            Logger.getLogger(DaoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Funcionário não foi salvo!: " + ex.getMessage());
        }                
    }
    
    public void excluir(Funcionario funcionarioPojo){
        int opcao = 1;
        
        sql = "DELETE FROM Funcionario WHERE id_funcionario = ?;";
                        
        try {            
            opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o Funcionário: " + funcionarioPojo.getNome(), "Excluir: "+ funcionarioPojo.getNome(), JOptionPane.YES_NO_OPTION);
            
            if(opcao == 0){
                connect.connection();
                PreparedStatement pst = connect.connect.prepareStatement(sql);            
                pst.setInt(1, funcionarioPojo.getId_funcionario());
                pst.execute();
                connect.disconect();
                JOptionPane.showMessageDialog(null, "Funcionário excluido com êxito!");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir a função: " + ex.getMessage());
        }        
        
    }
    public void visualisar(Funcionario funcionarioPojo){
    }
    
    public void buscarTipos(JComboBox jcb, JComboBox jcb2, JComboBox jcb3 ){
        try {
            jcb.removeAllItems();
            jcb2.removeAllItems();
            jcb3.removeAllItems();
            
            sql = "SELECT * FROM tipo;";
            connect.connection();
            connect.executaSql(sql);
            
            while(connect.rst.next()){
                jcb.addItem(connect.rst.getString("nome"));
                jcb2.addItem(connect.rst.getString("descricao"));
                jcb3.addItem(String.valueOf(connect.rst.getInt("id_tipo")));
            }
            
            connect.disconect();
        } catch (SQLException ex) {
            Logger.getLogger(DaoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
     public void preencherTabela(JTable jTableFuncionario){
        sql = "SELECT F.id_funcionario, F.nome As nome_funcionario, F.sexo, F.idade, F.data_nascimento, T.nome AS nome_tipo, T.descricao, " +
              "F.rua, F.bairro, F.cpf, F.telefone_1, F.telefone_2, F.qtd_dias_de_trabalho,  " +
              "F.valor_diaria, F.salario " +
              "FROM Funcionario F, Tipo T " +
              "WHERE F.id_tipo = T.id_tipo " +
              "ORDER BY F.id_funcionario;";
        
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Identificador", "Nome do Funcionario", "Sexo"
                                       , "Idade", "Data de Nascimento", "Função", "Descrição da Função","Rua"
                                       , "Bairro", "CPF", "Telefone (1)", "Telefone (2)"
                                       , "Periodo/dias de trabalho", "Valor da Diaria"
                                       , "Salario"};
                
        try {  
            connect.connection();
            connect.executaSql(sql);
            boolean estado = connect.rst.first();
            
            if(estado){
                do{
                    if(connect.rst.getString("sexo").equals("F")){
                        sexo = "Feminino";
                    }else{
                        sexo = "Masculino";
                    }
                    
                    telefone1 = connect.rst.getString("telefone_1").trim();
                    telefone2 = connect.rst.getString("telefone_2").trim();
                    
                    if(telefone1.equals("(  )")){
                        telefone1 = "";
                    }
                    
                    if(telefone2.equals("(  )")){
                        telefone2 = "";
                    }
                    
                    dados.add(new Object[]{connect.rst.getInt("id_funcionario"), connect.rst.getString("nome_funcionario").trim()
                                         , sexo, connect.rst.getInt("idade")
                                         , simpleDateFormat.format(connect.rst.getDate("data_nascimento")), connect.rst.getString("nome_tipo"),  connect.rst.getString("descricao")
                                         , connect.rst.getString("rua").trim(), connect.rst.getString("bairro").trim()
                                         , connect.rst.getString("cpf").trim(), telefone1
                                         , telefone2 , connect.rst.getInt("qtd_dias_de_trabalho")
                                         , formato.format(connect.rst.getDouble("valor_diaria")),  formato.format(connect.rst.getDouble("salario"))});                                           
                }while(connect.rst.next());
            }                        
                               
            connect.disconect();
        } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null, "Erro ao preencher a tabela de funções: " + ex.getMessage());
        }
        
        Tabela tabelaPojo = new Tabela(dados, colunas);
        jTableFuncionario.setModel(tabelaPojo);
        
        jTableFuncionario.getColumnModel().getColumn(0).setPreferredWidth(100);
        jTableFuncionario.getColumnModel().getColumn(0).setResizable(false);
        jTableFuncionario.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTableFuncionario.getColumnModel().getColumn(1).setResizable(false);
        jTableFuncionario.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTableFuncionario.getColumnModel().getColumn(2).setResizable(false);
        jTableFuncionario.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTableFuncionario.getColumnModel().getColumn(3).setResizable(false);
        jTableFuncionario.getColumnModel().getColumn(4).setPreferredWidth(100);
        jTableFuncionario.getColumnModel().getColumn(4).setResizable(false);
        jTableFuncionario.getColumnModel().getColumn(5).setPreferredWidth(100);
        jTableFuncionario.getColumnModel().getColumn(5).setResizable(false);
        jTableFuncionario.getColumnModel().getColumn(6).setPreferredWidth(100);
        jTableFuncionario.getColumnModel().getColumn(6).setResizable(false);
        jTableFuncionario.getColumnModel().getColumn(7).setPreferredWidth(100);
        jTableFuncionario.getColumnModel().getColumn(7).setResizable(false);
        jTableFuncionario.getColumnModel().getColumn(8).setPreferredWidth(100);
        jTableFuncionario.getColumnModel().getColumn(8).setResizable(false);
        jTableFuncionario.getColumnModel().getColumn(9).setPreferredWidth(100);
        jTableFuncionario.getColumnModel().getColumn(9).setResizable(false);
        jTableFuncionario.getColumnModel().getColumn(10).setPreferredWidth(100);
        jTableFuncionario.getColumnModel().getColumn(10).setResizable(false);
        jTableFuncionario.getColumnModel().getColumn(11).setPreferredWidth(100);
        jTableFuncionario.getColumnModel().getColumn(11).setResizable(false);
        jTableFuncionario.getColumnModel().getColumn(12).setPreferredWidth(100);
        jTableFuncionario.getColumnModel().getColumn(12).setResizable(false);
        jTableFuncionario.getColumnModel().getColumn(13).setPreferredWidth(100);
        jTableFuncionario.getColumnModel().getColumn(13).setResizable(false);
        jTableFuncionario.getColumnModel().getColumn(14).setPreferredWidth(100);
        jTableFuncionario.getColumnModel().getColumn(14).setResizable(false);
        
        jTableFuncionario.getTableHeader().setReorderingAllowed(false);
        jTableFuncionario.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);       
        jTableFuncionario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
     }
}
