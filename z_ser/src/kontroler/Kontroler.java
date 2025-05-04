/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroler;

import baza.DBB;
import java.util.List;
import model.Opstina;
import model.Prijava;
import model.Stavka;

/**
 *
 * @author USER
 */
public class Kontroler {
    private static Kontroler instance;
    private DBB dbb;
    private Kontroler() {
        dbb=new DBB();
    }

    public static Kontroler getInstance() {
        if(instance==null)
            instance=new Kontroler();
        return instance;
    }

    public List<Prijava> vratiPrijave() {
        return dbb.vratiPrijave();
    }

    public boolean ponisti(Prijava get) {
        return dbb.ponisti(get);
    }

    public List<Opstina>  vrati_op() {
        return dbb.vrati_op();
    }

    public boolean sacuvaj(List<Stavka> list) {
        return dbb.sacuvaj(list);
    }
    
}
