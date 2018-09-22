/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ProjetoConfeccao.Dao;

import br.com.ProjetoConfeccao.Pojo.Tabela;
import br.com.ProjetoConfeccao.Pojo.Tipo;
import br.com.ProjetoConfeccao.ProjetoConfeccao.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
/**
 *
 * @author randel
 */
public class DaoTipo {
    ConnectionFactory connect = new ConnectionFactory();   
    String sql = "";
    int opcao;

    public void salvar(Tipo tipoPojo){
        try {
            sql = "INSERT INTO Tipo(nome, descricao) VALUES(?, ?);";
            connect.connection();
            PreparedStatement pst = connect.connect.prepareStatement(sql);
            pst.setString(1, tipoPojo.getNome());
            pst.setString(2, tipoPojo.getDescricao());
            pst.execute();
            connect.disconect();
            JOptionPane.showMessageDialog(null, "Função salva com êxito!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível Função salvar a função: " + ex.getMessage());
        }
    }
    
    public void preencherTabela(JTable jtableTipo){
        sql = "SELECT * FROM Tipo ORDER BY id_tipo;";
        
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Identificador", "Nome da Função", "Descrição"};
            
        try {  
            connect.connection();
            connect.executaSql(sql);
            boolean estado = connect.rst.first();
            
            if(estado){
                do{
                    dados.add(new Object[]{connect.rst.getInt("id_tipo"), connect.rst.getString("nome"), connect.rst.getString("descricao")});                       
                }while(connect.rst.next());
            }
            connect.disconect();
        } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null, "Erro ao preencher a tabela de funções: " + ex.getMessage());
        }
        
        Tabela tabelaPojo = new Tabela(dados, colunas);
        jtableTipo.setModel(tabelaPojo);
        jtableTipo.getColumnModel().getColumn(0).setPreferredWidth(100);
        jtableTipo.getColumnModel().getColumn(0).setResizable(false);
        jtableTipo.getColumnModel().getColumn(1).setPreferredWidth(300);
        jtableTipo.getColumnModel().getColumn(1).setResizable(false);
        jtableTipo.getColumnModel().getColumn(2).setPreferredWidth(438);
        jtableTipo.getColumnModel().getColumn(2).setResizable(false);
        jtableTipo.getTableHeader().setReorderingAllowed(false);
        jtableTipo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);       
        jtableTipo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }   
    
    public void editar(Tipo tipoPojo){
        sql = "UPDATE Tipo SET nome = ?, descricao = ? WHERE id_tipo = ?;";
                        
        try {
            connect.connection();
            PreparedStatement pst = connect.connect.prepareStatement(sql);
            pst.setString(1, tipoPojo.getNome());
            pst.setString(2, tipoPojo.getDescricao());            
            pst.setInt(3, tipoPojo.getId_tipo());
            pst.execute();
            connect.disconect();
            JOptionPane.showMessageDialog(null, "Função aualizada com êxito!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher a tabela de funções: " + ex.getMessage());
        }        
    }
        
    public void excluir(Tipo tipoPojo){
        sql = "DELETE FROM Tipo WHERE id_tipo = ?;";
                        
        try {            
            opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir a Função: " + tipoPojo.getNome(), "Excluir: "+ tipoPojo.getNome(), JOptionPane.YES_NO_OPTION);
            
            if(opcao == 0){
                connect.connection();
                PreparedStatement pst = connect.connect.prepareStatement(sql);            
                pst.setInt(1, tipoPojo.getId_tipo());
                pst.execute();
                connect.disconect();
                JOptionPane.showMessageDialog(null, "Função excluida com êxito!");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir a função: " + ex.getMessage());
        }        
    }    
}
