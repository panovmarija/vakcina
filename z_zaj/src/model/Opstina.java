/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author USER
 */
public class Opstina implements Serializable{
    private int id, ptt;
    private String naz;

    public Opstina() {
    }

    @Override
    public String toString() {
        return naz;
    }

    public Opstina(int id, int ptt, String naz) {
        this.id = id;
        this.ptt = ptt;
        this.naz = naz;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPtt() {
        return ptt;
    }

    public void setPtt(int ptt) {
        this.ptt = ptt;
    }

    public String getNaz() {
        return naz;
    }

    public void setNaz(String naz) {
        this.naz = naz;
    }
    
}
