package entity;

import java.sql.Date;

public class Admin extends Kullanici {

    private int admin_id;
    private String yetkiler;

    public Admin() {
    }

    public Admin(int admin_id, String yetkiler, int kullanici_id, String ad_soyad, String login_name, String password, int yas, String cinsiyet, String email, String telefon, Date kayit_tarihi) {
        super(kullanici_id, ad_soyad, login_name, password, yas, cinsiyet, email, telefon, kayit_tarihi, true);
        this.admin_id = admin_id;
        this.yetkiler = yetkiler;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getYetkiler() {
        return yetkiler;
    }

    public void setYetkiler(String yetkiler) {
        this.yetkiler = yetkiler;
    }

    @Override
    public String toString() {
        super.toString();
        return "admin{" + "admin_id=" + admin_id + ", yetkiler=" + yetkiler + '}';
    }

}
