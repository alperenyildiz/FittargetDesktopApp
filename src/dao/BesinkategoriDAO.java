package dao;

import entity.Besinkategori;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BesinkategoriDAO extends SuperDAO {

    PreparedStatement pst = null;
    ResultSet rs = null;

    public void insert(Besinkategori besinkategori) {

        try {
            pst = this.getConnection().prepareStatement("insert into besinkategori (besinkategori_isim) values(?)");
            pst.setString(1, besinkategori.getBesinkategori_isim());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println(" BesinkategoriDAO HATA(Create): " + ex.getMessage());
        }
    }

    public void delete(Besinkategori besinkategori) {

        try {
            pst = this.getConnection().prepareStatement("delete from besinkategori where besinkategori_id=?");
            pst.setInt(1, besinkategori.getBesinkategori_id());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
            System.out.println(" BesinKategoriDAO HATA(Delete): " + ex.getMessage());
        }
    }

    public List<Besinkategori> read() {
        List<Besinkategori> bklist = new ArrayList();

        try {
            pst = this.getConnection().prepareStatement("select * from besinkategori order by besinkategori_id asc");
            rs = pst.executeQuery();
            while (rs.next()) {
                Besinkategori temp = new Besinkategori(rs.getInt("besinkategori_id"), rs.getString("besinkategori_isim"));
                bklist.add(temp);
            }
        } catch (SQLException ex) {
            System.out.println("BesinkategoriDAO HATA(READ):" + ex.getMessage());
        }
        return bklist;
    }

    public void update(Besinkategori besinkategori) {

        try {
            pst = this.getConnection().prepareStatement("update besinkategori set besinkategori_isim=? where besinkategori_id=?");
            pst.setString(1, besinkategori.getBesinkategori_isim());
            pst.setInt(2, besinkategori.getBesinkategori_id());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
            System.out.println(" BesinkategoriDAO HATA(Update): " + ex.getMessage());
        }
    }

    public Besinkategori find(int id) {
        Besinkategori b = null;
        try {
            pst = this.getConnection().prepareStatement("select * from besinkategori where besinkategori_id=?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            rs.next();
            b = new Besinkategori();
            b.setBesinkategori_id(rs.getInt("besinkategori_id"));
            b.setBesinkategori_isim(rs.getString("besinkategori_isim"));
        } catch (SQLException ex) {
            System.out.println("BesinkategoriDAO HATA(FİND) :" + ex.getMessage());
        }
        return b;
    }

    public Besinkategori find(String isim) {
        Besinkategori b = null;
        try {
            pst = this.getConnection().prepareStatement("select * from besinkategori where besinkategori_isim ilike ?");
            pst.setString(1, isim);
            rs = pst.executeQuery();
            rs.next();
            b = new Besinkategori();
            b.setBesinkategori_id(rs.getInt("besinkategori_id"));
            b.setBesinkategori_isim(rs.getString("besinkategori_isim"));
        } catch (SQLException ex) {
            System.out.println("BesinkategoriDAO HATA(FİND) :" + ex.getMessage());
        }
        return b;
    }
}
