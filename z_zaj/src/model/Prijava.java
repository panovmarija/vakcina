/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author USER
 */
public class Prijava implements Serializable{
    private int id;
    private Drz drz;
    private String jmbg, ime, prez, epos, mob;
    private boolean spec;
    private Date dat;
    private Opstina o;

    public Prijava() {
    }

    public Prijava(int id, Drz drz, String jmbg, String ime, String prez, String epos, String mob, boolean spec, Date dat, Opstina o) {
        this.id = id;
        this.drz = drz;
        this.jmbg = jmbg;
        this.ime = ime;
        this.prez = prez;
        this.epos = epos;
        this.mob = mob;
        this.spec = spec;
        this.dat = dat;
        this.o = o;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Drz getDrz() {
        return drz;
    }

    public void setDrz(Drz drz) {
        this.drz = drz;
    }


    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrez() {
        return prez;
    }

    public void setPrez(String prez) {
        this.prez = prez;
    }

    public String getEpos() {
        return epos;
    }

    public void setEpos(String epos) {
        this.epos = epos;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public boolean isSpec() {
        return spec;
    }

    public void setSpec(boolean spec) {
        this.spec = spec;
    }

    public Date getDat() {
        return dat;
    }

    public void setDat(Date dat) {
        this.dat = dat;
    }

    public Opstina getO() {
        return o;
    }

    public void setO(Opstina o) {
        this.o = o;
    }
    
}
