/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

/**
 *
 * @author USER
 */
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Drz;
import model.Opstina;
import model.Prijava;
import model.Stavka;
public class DBB {

    public List<Prijava> vratiPrijave() {
        List<Prijava> l=new LinkedList<>();
        try (Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3316/prosoftfeb21", "root", "root")){
            conn.setAutoCommit(true);
            String u="select * from prijava p join opstina o on(o.opstinaid=p.opstinaid)";
            Statement s=conn.createStatement();
            ResultSet rs=s.executeQuery(u);
            while (rs.next()){
                Opstina o=new Opstina(rs.getInt("o.opstinaid"), rs.getInt("o.pttbroj"), rs.getString("o.naziv"));
                Prijava p=new Prijava(rs.getInt("p.prijavaid"), Drz.valueOf(rs.getString("p.drzavljanstvo")), rs.getString("jmbg"),
                        rs.getString("ime"), rs.getString("prezime"), rs.getString("elektronskaposta"), rs.getString("mobilnitelefon")
                        , rs.getBoolean("specificnaoboljenja"), new java.util.Date(rs.getTimestamp("datumprijave").getTime()), o);
                l.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    public boolean ponisti(Prijava p) {
        try {
            String u="delete from stavkaprijave where prijavaid="+p.getId();
            Statement s=Konekcija.getInstance().getConn().createStatement();
            s.executeUpdate(u);
            u="delete from prijava where prijavaid="+p.getId();
            s=Konekcija.getInstance().getConn().createStatement();
            s.executeUpdate(u);
            Konekcija.getInstance().getConn().commit();
        } catch (SQLException ex) {
            try {
                Konekcija.getInstance().getConn().rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(DBB.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DBB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public List<Opstina> vrati_op() {
        List<Opstina> l=new LinkedList<>();
        try (Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3316/prosoftfeb21", "root", "root")){
            conn.setAutoCommit(true);
            String u="select * from opstina o ";
            Statement s=conn.createStatement();
            ResultSet rs=s.executeQuery(u);
            while (rs.next()){
                Opstina o=new Opstina(rs.getInt("o.opstinaid"), rs.getInt("o.pttbroj"), rs.getString("o.naziv"));
                 l.add(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    public boolean sacuvaj(List<Stavka> list) {
        try {
            Prijava p=list.get(0).getP();
            String u="insert into prijava (drzavljanstvo, jmbg, ime, prezime, elektronskaposta, mobilnitelefon, specificnaoboljenja, datumprijave, opstinaid) values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps=Konekcija.getInstance().getConn().prepareStatement(u, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, p.getDrz()+"");
            ps.setString(2, p.getJmbg());
            ps.setString(3, p.getIme());
            ps.setString(4, p.getPrez());
            ps.setString(5, p.getEpos());
            ps.setString(6, p.getMob());
            ps.setBoolean(7, p.isSpec());
            ps.setTimestamp(8, new Timestamp(p.getDat().getTime()));
            ps.setInt(9, p.getO().getId());
            int afr=ps.executeUpdate();
            if(afr==0)
                return false;
            int id=-1;
            ResultSet rsid=ps.getGeneratedKeys();
            while(rsid.next())
            {
                id=rsid.getInt(1);
            }
            u="insert into stavkaprijave values(?,?,?)";
            ps=Konekcija.getInstance().getConn().prepareStatement(u);
            for(Stavka s:list)
            {
                ps.setInt(1, id);
                ps.setInt(2, s.getRb());
                ps.setString(3, s.getTip()+"");
                ps.addBatch();
            }
            ps.executeBatch();
            Konekcija.getInstance().getConn().commit();
        } catch (SQLException ex) {
            try {
                Konekcija.getInstance().getConn().rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(DBB.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DBB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
}
