package dao;

import entity.Kullanici;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KullaniciDAO extends SuperDAO {
    
    PreparedStatement pst;
    ResultSet rs;
    
    public KullaniciDAO() {
        this.pst = null;
        this.rs = null;
    }
    
    public List<Kullanici> read() {
        
        List<Kullanici> klist = new ArrayList();
        
        try {
            pst = this.getConnection().prepareStatement("select * from kullanici order by kullanici_id asc");
            rs = pst.executeQuery();
            while (rs.next()) {
                Kullanici temp = new Kullanici(rs.getInt("kullanici_id"), rs.getString("ad_soyad"),
                        rs.getString("login_name"), rs.getString("password"), rs.getInt("yas"), rs.getString("cinsiyet"),
                        rs.getString("email"), rs.getString("telefon"), rs.getDate("kayit_tarihi"), rs.getBoolean("bildirim"));
                klist.add(temp);
            }
        } catch (SQLException ex) {
            System.out.println("KullaniciDAO HATA(READ):" + ex.getMessage());
        }
        return klist;
    }

    /*  public Kullanici Login(String login_name, String password) {

        List<Kullanici> list = this.read();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getLogin_name().equalsIgnoreCase(login_name) && list.get(i).getPassword().equalsIgnoreCase(password)) {
                return list.get(i);
            }
        }
        return null;
    }
     */
}
