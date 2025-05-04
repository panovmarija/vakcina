/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author USER
 */
public class ModelKl extends AbstractTableModel {
private List<Stavka> l;
private String []kol=new String[]{"RB", "Tip vakcine"};

    public ModelKl(List<Stavka> l) {
        this.l = l;
    }

    @Override
    public int getRowCount() {
        return l.size();
        }

    @Override
    public int getColumnCount() {
        return kol.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Stavka s=l.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return s.getRb();
            case 1:
                return s.getTip();
             default:
                throw new AssertionError();
        }
    }

    @Override
    public String getColumnName(int column) {
        return kol[column];
    }

    public List<Stavka> getL() {
        return l;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex==1;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        l.get(rowIndex).setTip((Tip) aValue);
    }
    
     
}
