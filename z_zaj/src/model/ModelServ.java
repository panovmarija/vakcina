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
public class ModelServ extends AbstractTableModel {
private List<Prijava> l;
private String []kol=new String[]{"Ime i prezime", "JMBG", "Drzavljanstvo", "Opstina", "El. posta", "Mobilni","Specificna oboljenja" };

    public ModelServ(List<Prijava> l) {
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
        Prijava p=l.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getIme()+" "+p.getPrez();
            case 1:
                return p.getJmbg();
            case 2:
                return p.getDrz();
            case 3:
                return p.getO().getNaz();
            case 4:
                return p.getEpos();
            case 5:
                return p.getMob();
            case 6:
                return p.isSpec();
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String getColumnName(int column) {
        return kol[column];
    }

    public List<Prijava> getL() {
        return l;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex==6)
            return Boolean.class;
        return String.class;
    }
    
}
