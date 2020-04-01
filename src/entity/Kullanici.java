package entity;

import Observer.Observable;
import Observer.Observer;
import java.sql.Date;

public class Kullanici implements Observer {

    private int kullanici_id;
    private String ad_soyad;
    private String login_name;
    private String password;
    private int yas;
    private String cinsiyet;
    private String email;
    private String telefon;
    private Date kayit_tarihi;

    private Observable observable;
    private boolean bildirim;

    public Kullanici() {
    }

    public Kullanici(int kullanici_id, String ad_soyad, String login_name, String password, int yas, String cinsiyet, String email, String telefon, Date kayit_tarihi, Boolean bildirim) {
        this.kullanici_id = kullanici_id;
        this.ad_soyad = ad_soyad;
        this.login_name = login_name;
        this.password = password;
        this.yas = yas;
        this.cinsiyet = cinsiyet;
        this.email = email;
        this.telefon = telefon;
        this.kayit_tarihi = kayit_tarihi;
        this.bildirim = bildirim;
    }

    @Override
    public String notify(String message) {

        return "Sayın " + this.ad_soyad + " " + message;
    }

    public void removeObserver() {
        this.observable.removeObserver(this);
    }

    public int getKullanici_id() {
        return kullanici_id;
    }

    public void setKullanici_id(int kullanici_id) {
        this.kullanici_id = kullanici_id;
    }

    public String getAd_soyad() {
        return ad_soyad;
    }

    public void setAd_soyad(String ad_soyad) {
        this.ad_soyad = ad_soyad;
    }

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        if (login_name.length() < 30) {
            this.login_name = login_name;
        }

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Date getKayit_tarihi() {
        return kayit_tarihi;
    }

    public void setKayit_tarihi(Date kayit_tarihi) {
        this.kayit_tarihi = kayit_tarihi;
    }

    public Observable getObservable() {
        return observable;
    }

    public void setObservable(Observable observable) {
        this.observable = observable;
    }

    public boolean isBildirim() {
        return bildirim;
    }

    public void setBildirim(boolean bildirim) {
        this.bildirim = bildirim;
    }

    @Override
    public String toString() {
        return "Kullanici{" + "kullanici_id=" + kullanici_id + ", ad_soyad=" + ad_soyad + ", login_name=" + login_name + ", password=" + password + ", yas=" + yas + ", cinsiyet=" + cinsiyet + ", email=" + email + ", telefon=" + telefon + ", kayit_tarihi=" + kayit_tarihi + '}';
    }

}
