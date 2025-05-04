/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import forme.Server;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class Osvezi extends Thread{
private Server sf;

    public Osvezi(Server sf) {
        this.sf = sf;
    }

    @Override
    public void run() {
        while (true) {            
            sf.osvezi();
            System.out.println("c");
            try {
                sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Osvezi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
