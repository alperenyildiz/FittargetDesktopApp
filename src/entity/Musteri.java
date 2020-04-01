package entity;

import Observer.Observable;
import dao.BesinDAO;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Musteri extends Kullanici {

    private int musteri_id;
    private int boy; //cm cinsinden
    private double kilo; //kg
    private double yag_orani; // örn: %15
    private String hedef;  //kilo alma-yağ yakma
    private double gunluk_kalori_ihtiyaci; //kalori cinsinden
    private double gunluk_karbonhidrat_ihtiyaci; //gr cinsinden
    private double gunluk_protein_ihtiyaci; //gr cinsinden
    private double gunluk_yag_ihtiyaci; //gr cinsinden

    private double kalanKalori;
    private double kalanKarbonhidrat;
    private double kalanProtein;
    private double kalanYag;

    List<Besin> tuketilenBesinler;
    private BesinDAO bdao;

    public Musteri() {
    }

    public Musteri(int musteri_id, int boy, double kilo, double yag_orani, String hedef, double gunluk_kalori_ihtiyaci, double gunluk_karbonhidrat_ihtiyaci, double gunluk_protein_ihtiyaci, double gunluk_yag_ihtiyaci, int kullanici_id, String ad_soyad, String login_name, String password, int yas, String cinsiyet, String email, String telefon, Date kayit_tarihi,boolean bildirim) {
        super(kullanici_id, ad_soyad, login_name, password, yas, cinsiyet, email, telefon, kayit_tarihi,bildirim);
        this.musteri_id = musteri_id;
        this.boy = boy;
        this.kilo = kilo;
        this.yag_orani = yag_orani;
        this.hedef = hedef;
        this.gunluk_kalori_ihtiyaci = gunluk_kalori_ihtiyaci;
        this.gunluk_karbonhidrat_ihtiyaci = gunluk_karbonhidrat_ihtiyaci;
        this.gunluk_protein_ihtiyaci = gunluk_protein_ihtiyaci;
        this.gunluk_yag_ihtiyaci = gunluk_yag_ihtiyaci;
    }

    public int getMusteri_id() {
        return musteri_id;
    }

    public void setMusteri_id(int musteri_id) {
        this.musteri_id = musteri_id;
    }

    public int getBoy() {
        return boy;
    }

    public void setBoy(int boy) {
        this.boy = boy;
    }

    public double getKilo() {
        return kilo;
    }

    public void setKilo(double kilo) {
        this.kilo = kilo;
    }

    public double getYag_orani() {
        return yag_orani;
    }

    public void setYag_orani(double yag_orani) {
        this.yag_orani = yag_orani;
    }

    public String getHedef() {
        return hedef;
    }

    public void setHedef(String hedef) {
        this.hedef = hedef;
    }

    public double getGunluk_kalori_ihtiyaci() {
        return gunluk_kalori_ihtiyaci;
    }

    public void setGunluk_kalori_ihtiyaci(double gunluk_kalori_ihtiyaci) {
        this.gunluk_kalori_ihtiyaci = gunluk_kalori_ihtiyaci;
    }

    public double getGunluk_karbonhidrat_ihtiyaci() {
        return gunluk_karbonhidrat_ihtiyaci;
    }

    public void setGunluk_karbonhidrat_ihtiyaci(double gunluk_karbonhidrat_ihtiyaci) {
        this.gunluk_karbonhidrat_ihtiyaci = gunluk_karbonhidrat_ihtiyaci;
    }

    public double getGunluk_protein_ihtiyaci() {
        return gunluk_protein_ihtiyaci;
    }

    public void setGunluk_protein_ihtiyaci(double gunluk_protein_ihtiyaci) {
        this.gunluk_protein_ihtiyaci = gunluk_protein_ihtiyaci;
    }

    public double getGunluk_yag_ihtiyaci() {
        return gunluk_yag_ihtiyaci;
    }

    public void setGunluk_yag_ihtiyaci(double gunluk_yag_ihtiyaci) {
        this.gunluk_yag_ihtiyaci = gunluk_yag_ihtiyaci;
    }

    public List<Besin> getTuketilenBesinler() {
        if (this.tuketilenBesinler == null) {
            this.tuketilenBesinler = new ArrayList();
            this.tuketilenBesinler = this.getBdao().getTuketilenBesinler(this.musteri_id);
        }
        this.tuketilenBesinler = this.getBdao().getTuketilenBesinler(this.musteri_id);
        return tuketilenBesinler;
    }

    public void setTuketilenBesinler(List<Besin> tuketilenBesinler) {
        this.tuketilenBesinler = tuketilenBesinler;
    }

    public double getKalanKalori() {
        return kalanKalori;
    }

    public void setKalanKalori(double kalanKalori) {
        this.kalanKalori = kalanKalori;
    }

    public double getKalanKarbonhidrat() {
        return kalanKarbonhidrat;
    }

    public void setKalanKarbonhidrat(double kalanKarbonhidrat) {
        this.kalanKarbonhidrat = kalanKarbonhidrat;
    }

    public double getKalanProtein() {
        return kalanProtein;
    }

    public void setKalanProtein(double kalanProtein) {
        this.kalanProtein = kalanProtein;
    }

    public double getKalanYag() {
        return kalanYag;
    }

    public void setKalanYag(double kalanYag) {
        this.kalanYag = kalanYag;
    }

    public BesinDAO getBdao() {
        if (this.bdao == null) {
            this.bdao = new BesinDAO();
        }
        return bdao;
    }

    public void setBdao(BesinDAO bdao) {
        this.bdao = bdao;
    }

    @Override
    public String toString() {
        super.toString();
        return "musteri{" + "musteri_id=" + musteri_id + ", boy=" + boy + ", kilo=" + kilo + ", yag_orani=" + yag_orani + ", hedef=" + hedef + ", gunluk_kalori_ihtiyaci=" + gunluk_kalori_ihtiyaci + ", gunluk_karbonhidrat_ihtiyaci=" + gunluk_karbonhidrat_ihtiyaci + ", gunluk_protein_ihtiyaci=" + gunluk_protein_ihtiyaci + ", gunluk_yag_ihtiyaci=" + gunluk_yag_ihtiyaci + '}';
    }

}
