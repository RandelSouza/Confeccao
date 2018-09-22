package br.com.ProjetoConfeccao.Pojo;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author randel
 */
public final class Tabela extends AbstractTableModel{
   
    private ArrayList row = null;
    private String[] column=  null;
           
    public Tabela(ArrayList row, String[] column){
        setRow(row);
        setColumn(column);               
    }
    
     public ArrayList getRow() {
        return row;
    }

    public void setRow(ArrayList row) {
        this.row = row;
    }

    public String[] getColumn() {
        return column;
    }

    public void setColumn(String[] collumn) {
        this.column = collumn;
    }
    
    @Override
    public String getColumnName(int numCol){
        return column[numCol];
    }
        
    @Override
    public int getRowCount() {
        return row.size();
    }

    @Override
    public int getColumnCount() {
        return column.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object[] rows = (Object[]) getRow().get(rowIndex);
        return rows[columnIndex];
    }    
}