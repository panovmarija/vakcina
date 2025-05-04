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
public class Stavka implements Serializable{
  private Prijava p;
  private int rb;
  private Tip tip;

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Stavka other = (Stavka) obj;
        return this.tip == other.tip;
    }

    public Stavka() {
    }

    public Stavka(Prijava p, int rb, Tip tip) {
        this.p = p;
        this.rb = rb;
        this.tip = tip;
    }


    public Prijava getP() {
        return p;
    }

    public void setP(Prijava p) {
        this.p = p;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public Tip getTip() {
        return tip;
    }

    public void setTip(Tip tip) {
        this.tip = tip;
    }

  
}
