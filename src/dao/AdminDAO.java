package dao;

import entity.Admin;
import entity.Kullanici;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO extends SuperDAO {

    PreparedStatement pst = null;
    ResultSet rs = null;

    public void insert(Admin admin) {

        try {
            pst = this.getConnection().prepareStatement("insert into admin (ad_soyad,login_name,password,yas,cinsiyet,email,telefon"
                    + ",yetkiler,bildirim) "
                    + "values(?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, admin.getAd_soyad());
            pst.setString(2, admin.getLogin_name());
            pst.setString(3, admin.getPassword());
            pst.setInt(4, admin.getYas());
            pst.setString(5, admin.getCinsiyet());
            pst.setString(6, admin.getEmail());
            pst.setString(7, admin.getTelefon());
            pst.setString(8, admin.getYetkiler());
            pst.setBoolean(9, admin.isBildirim());

            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println(" AdminDAO HATA(Create): " + ex.getMessage());
        }
    }

    public void delete(Admin admin) {

        try {
            pst = this.getConnection().prepareStatement("delete from admin where admin_id=?");
            pst.setInt(1, admin.getAdmin_id());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
            System.out.println(" AdminDAO HATA(Delete): " + ex.getMessage());
        }
    }

    public List<Admin> read() {
        List<Admin> alist = new ArrayList();

        try {
            pst = this.getConnection().prepareStatement("select * from admin order by admin_id asc");
            rs = pst.executeQuery();
            while (rs.next()) {
                Admin temp = new Admin(rs.getInt("admin_id"), rs.getString("yetkiler"), rs.getInt("kullanici_id"), rs.getString("ad_soyad"),
                        rs.getString("login_name"), rs.getString("password"), rs.getInt("yas"), rs.getString("cinsiyet"),
                        rs.getString("email"), rs.getString("telefon"), rs.getDate("kayit_tarihi"));
                alist.add(temp);
            }
        } catch (SQLException ex) {
            System.out.println("AdminDAO HATA(READ):" + ex.getMessage());
        }
        return alist;
    }

    public void update(Admin admin) {

        try {
            pst = this.getConnection().prepareStatement("update admin set ad_soyad=?,login_name=?,password=?,yas=?,cinsiyet=?,"
                    + "email=?,telefon=?,yetkiler=? where admin_id=?");
            pst.setString(1, admin.getAd_soyad());
            pst.setString(2, admin.getLogin_name());
            pst.setString(3, admin.getPassword());
            pst.setInt(4, admin.getYas());
            pst.setString(5, admin.getCinsiyet());
            pst.setString(6, admin.getEmail());
            pst.setString(7, admin.getTelefon());
            pst.setString(8, admin.getYetkiler());
            pst.setInt(9, admin.getAdmin_id());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
            System.out.println(" AdminDAO HATA(Update): " + ex.getMessage());
        }
    }

    public Admin find(int id) {
        Admin a = null;
        try {
            pst = this.getConnection().prepareStatement("select * from admin where admin_id=?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            rs.next();
            a = new Admin(rs.getInt("admin_id"), rs.getString("yetkiler"), rs.getInt("kullanici_İd"), rs.getString("ad_soyad"), rs.getString("login_name"),
                    rs.getString("password"), rs.getInt("yas"), rs.getString("cinsiyet"), rs.getString("email"), rs.getString("telefon"), rs.getDate("kayit_tarihi"));

        } catch (SQLException ex) {
            System.out.println("AdminDAO HATA(FİND) :" + ex.getMessage());
        }
        return a;
    }

    public Admin find(Kullanici k) {
        Admin admin = null;
        try {
            pst = this.getConnection().prepareStatement("select * from admin where kullanici_id=?");
            pst.setInt(1, k.getKullanici_id());
            rs = pst.executeQuery();
            rs.next();
            admin = new Admin(rs.getInt("admin_id"), rs.getString("yetkiler"), rs.getInt("kullanici_id"), rs.getString("ad_soyad"),
                    rs.getString("login_name"), rs.getString("password"), rs.getInt("yas"), rs.getString("cinsiyet"), rs.getString("email"),
                    rs.getString("telefon"), rs.getDate("kayit_tarihi"));

        } catch (SQLException ex) {
            System.out.println("AdminDAO HATA(FİND WİHT OBJECT|Kullanici) :" + ex.getMessage());
        }

        return admin;
    }
}
