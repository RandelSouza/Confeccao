package br.com.ProjetoConfeccao.ProjetoConfeccao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author randel
 */
public class ConnectionFactory {
    
    public Statement stm;
    public ResultSet rst;
    private String driver = "org.postgresql.Driver";
    private String path = "jdbc:postgresql://localhost:5432/Confeccao";
    private String user = "postgres";
    private String password = "5xz1kif";    
    public Connection connect;
 
    public void connection(){
        System.setProperty("jdbc.Drivers", driver);
        try {
            connect = DriverManager.getConnection(path, user, password);        
           // JOptionPane.showMessageDialog(null, "Conectado com sucessso!");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados:" + "\n" + ex.getMessage());
        }        
    }    
    
    public void disconect(){
        try {
            connect.close();            
            //JOptionPane.showMessageDialog(null, "desconectado com sucessso!");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao desconectar do banco de dados:" + "\n" + ex.getMessage());
        }
    }
    
    public void executaSql(String sql){
        try {
            stm = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE , ResultSet.CONCUR_READ_ONLY);
            rst = stm.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao executar sql:" + "\n" + ex.getMessage());
        }
    }
    
    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}