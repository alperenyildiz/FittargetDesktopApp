package dao;

import entity.Besin;
import entity.Kullanici;
import entity.Musteri;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MusteriDAO extends SuperDAO {

    PreparedStatement pst = null;
    ResultSet rs = null;

    public void insert(Musteri musteri) {

        try {
            pst = this.getConnection().prepareStatement("insert into musteri (ad_soyad,login_name,password,yas,cinsiyet,email,telefon"
                    + ",boy,kilo,yag_orani,hedef,gunluk_kalori_ihtiyaci,gunluk_karbonhidrat_ihtiyaci,gunluk_protein_ihtiyaci,gunluk_yag_ihtiyaci,bildirim) "
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, musteri.getAd_soyad());
            pst.setString(2, musteri.getLogin_name());
            pst.setString(3, musteri.getPassword());
            pst.setInt(4, musteri.getYas());
            pst.setString(5, musteri.getCinsiyet());
            pst.setString(6, musteri.getEmail());
            pst.setString(7, musteri.getTelefon());
            pst.setInt(8, musteri.getBoy());
            pst.setDouble(9, musteri.getKilo());
            pst.setDouble(10, musteri.getYag_orani());
            pst.setString(11, musteri.getHedef());
            pst.setDouble(12, musteri.getGunluk_kalori_ihtiyaci());
            pst.setDouble(13, musteri.getGunluk_karbonhidrat_ihtiyaci());
            pst.setDouble(14, musteri.getGunluk_protein_ihtiyaci());
            pst.setDouble(15, musteri.getGunluk_yag_ihtiyaci());
            pst.setBoolean(16, musteri.isBildirim());

            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println(" MusteriDAO HATA(Create): " + ex.getMessage());
        }
    }

    public void delete(Musteri musteri) {

        try {
            pst = this.getConnection().prepareStatement("delete from musteri where musteri_id=?");
            pst.setInt(1, musteri.getMusteri_id());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
            System.out.println(" MusteriDAO HATA(Delete): " + ex.getMessage());
        }
    }

    public List<Musteri> read() {
        List<Musteri> mlist = new ArrayList();

        try {
            pst = this.getConnection().prepareStatement("select * from musteri order by musteri_id asc");
            rs = pst.executeQuery();
            while (rs.next()) {
                Musteri temp = new Musteri(rs.getInt("musteri_id"), rs.getInt("boy"), rs.getDouble("kilo"), rs.getDouble("yag_orani"),
                        rs.getString("hedef"), rs.getDouble("gunluk_kalori_ihtiyaci"), rs.getDouble("gunluk_karbonhidrat_ihtiyaci"),
                        rs.getDouble("gunluk_protein_ihtiyaci"), rs.getDouble("gunluk_yag_ihtiyaci"), rs.getInt("kullanici_id"), rs.getString("ad_soyad"),
                        rs.getString("login_name"), rs.getString("password"), rs.getInt("yas"), rs.getString("cinsiyet"), rs.getString("email"),
                        rs.getString("telefon"), rs.getDate("kayit_tarihi"), rs.getBoolean("bildirim"));
                mlist.add(temp);
            }
        } catch (SQLException ex) {
            System.out.println("MusteriDAO HATA(READ):" + ex.getMessage());
        }
        return mlist;
    }

    public List<Musteri> readActiveNotifyUsers() {  //Bildirimlere açık olan musterilerin listesini döner.
        List<Musteri> mlist = new ArrayList();

        try {
            pst = this.getConnection().prepareStatement("select * from musteri where bildirim=true order by musteri_id asc");
            rs = pst.executeQuery();
            while (rs.next()) {
                Musteri temp = new Musteri(rs.getInt("musteri_id"), rs.getInt("boy"), rs.getDouble("kilo"), rs.getDouble("yag_orani"),
                        rs.getString("hedef"), rs.getDouble("gunluk_kalori_ihtiyaci"), rs.getDouble("gunluk_karbonhidrat_ihtiyaci"),
                        rs.getDouble("gunluk_protein_ihtiyaci"), rs.getDouble("gunluk_yag_ihtiyaci"), rs.getInt("kullanici_id"), rs.getString("ad_soyad"),
                        rs.getString("login_name"), rs.getString("password"), rs.getInt("yas"), rs.getString("cinsiyet"), rs.getString("email"),
                        rs.getString("telefon"), rs.getDate("kayit_tarihi"), rs.getBoolean("bildirim"));
                mlist.add(temp);
            }
        } catch (SQLException ex) {
            System.out.println("MusteriDAO HATA(READ ACTİVE NOTİFY USERS):" + ex.getMessage());
        }
        return mlist;

    }

    public void update(Musteri musteri) {

        try {
            pst = this.getConnection().prepareStatement("update musteri set ad_soyad=?,login_name=?,password=?,yas=?,cinsiyet=?,"
                    + "email=?,telefon=?,boy=?,kilo=?,yag_orani=?,hedef=?,gunluk_kalori_ihtiyaci=?,"
                    + "gunluk_karbonhidrat_ihtiyaci=?,gunluk_protein_ihtiyaci=?,gunluk_yag_ihtiyaci=?,bildirim=? where musteri_id=?");
            pst.setString(1, musteri.getAd_soyad());
            pst.setString(2, musteri.getLogin_name());
            pst.setString(3, musteri.getPassword());
            pst.setInt(4, musteri.getYas());
            pst.setString(5, musteri.getCinsiyet());
            pst.setString(6, musteri.getEmail());
            pst.setString(7, musteri.getTelefon());
            pst.setInt(8, musteri.getBoy());
            pst.setDouble(9, musteri.getKilo());
            pst.setDouble(10, musteri.getYag_orani());
            pst.setString(11, musteri.getHedef());
            pst.setDouble(12, musteri.getGunluk_kalori_ihtiyaci());
            pst.setDouble(13, musteri.getGunluk_karbonhidrat_ihtiyaci());
            pst.setDouble(14, musteri.getGunluk_protein_ihtiyaci());
            pst.setDouble(15, musteri.getGunluk_yag_ihtiyaci());
            pst.setBoolean(16, musteri.isBildirim());
            pst.setDouble(17, musteri.getMusteri_id());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
            System.out.println(" MusteriDAO HATA(Update): " + ex.getMessage());
        }
    }

    public Musteri find(Kullanici k) {
        Musteri m = null;
        try {
            pst = this.getConnection().prepareStatement("select * from musteri where kullanici_id=?");
            pst.setInt(1, k.getKullanici_id());
            rs = pst.executeQuery();
            rs.next();
            m = new Musteri(rs.getInt("musteri_id"), rs.getInt("boy"), rs.getDouble("kilo"), rs.getDouble("yag_orani"),
                    rs.getString("hedef"), rs.getDouble("gunluk_kalori_ihtiyaci"), rs.getDouble("gunluk_karbonhidrat_ihtiyaci"),
                    rs.getDouble("gunluk_protein_ihtiyaci"), rs.getDouble("gunluk_yag_ihtiyaci"), rs.getInt("kullanici_id"), rs.getString("ad_soyad"),
                    rs.getString("login_name"), rs.getString("password"), rs.getInt("yas"), rs.getString("cinsiyet"), rs.getString("email"),
                    rs.getString("telefon"), rs.getDate("kayit_tarihi"), rs.getBoolean("bildirim"));

        } catch (SQLException ex) {
            System.out.println("MusteriDAO HATA(FİND WİHT OBJECT|Kullanici) :" + ex.getMessage());
        }

        return m;
    }

    public Musteri find(int id) {
        Musteri m = null;
        try {
            pst = this.getConnection().prepareStatement("select * from musteri where musteri_id=?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            rs.next();
            m = new Musteri(rs.getInt("musteri_id"), rs.getInt("boy"), rs.getDouble("kilo"), rs.getDouble("yag_orani"),
                    rs.getString("hedef"), rs.getDouble("gunluk_kalori_ihtiyaci"), rs.getDouble("gunluk_karbonhidrat_ihtiyaci"),
                    rs.getDouble("gunluk_protein_ihtiyaci"), rs.getDouble("gunluk_yag_ihtiyaci"), rs.getInt("kullanici_id"), rs.getString("ad_soyad"),
                    rs.getString("login_name"), rs.getString("password"), rs.getInt("yas"), rs.getString("cinsiyet"), rs.getString("email"),
                    rs.getString("telefon"), rs.getDate("kayit_tarihi"), rs.getBoolean("bildirim"));

        } catch (SQLException ex) {
            System.out.println("MusteriDAO HATA(FİND WİTH İD) :" + ex.getMessage());
        }
        return m;
    }

    public List<Double> kaloriHesapla(Musteri musteri) {   //Katch-McArdle formülü ile hesaplanmıştır.
        List<Double> kalorilerListesi = new ArrayList();
        double bmh;  // bazal metabolizma hızı
        double topKalori;
        double topYag;  //gr cinsinden
        double topKarbonhidrat;
        double topProtein;
        double yagsizKutle = (double) (musteri.getKilo() - (musteri.getKilo() * (musteri.getYag_orani() / 100)));

        if (musteri.getHedef().equalsIgnoreCase("kilo alma")) {

            if (musteri.getCinsiyet().equalsIgnoreCase("erkek")) {   //(ERKEK)bmh=66+(13.75 x kilonuz) + (5 x santimetre olarak boyunuz) – (6.8 x yaşınız)

                bmh = 66 + (13.75 * musteri.getKilo()) + (5 * musteri.getBoy()) + (6.8 * musteri.getYas());
                topKalori = (1.2 * bmh) + 250.0;
                topProtein = (yagsizKutle * 2.0);
                topYag = (yagsizKutle % 10) + 10;
                topKarbonhidrat = (topKalori - ((topYag * 9) + (topProtein * 4))) / 4;

                kalorilerListesi.add(topKalori);
                kalorilerListesi.add(topProtein);
                kalorilerListesi.add(topYag);
                kalorilerListesi.add(topKarbonhidrat);
            } else { //kadın   (KADIN)BMH=665+ ( 9.6 x kilonuz) + ( 1.7 x santimetre olarak boyunuz ) – ( 4.7 x yaşınız )

                bmh = 665 + (9.6 * musteri.getKilo()) + (1.7 * musteri.getBoy()) + (4.7 * musteri.getYas());
                topKalori = (1.2 * bmh) + 200.0;
                topProtein = (yagsizKutle * 2.0);
                topYag = yagsizKutle;
                topKarbonhidrat = (topKalori - ((topYag * 9) + (topProtein * 4))) / 4;

                kalorilerListesi.add(topKalori);
                kalorilerListesi.add(topProtein);
                kalorilerListesi.add(topYag);
                kalorilerListesi.add(topKarbonhidrat);

            }

        } else if (musteri.getHedef().equalsIgnoreCase("yağ yakma")) {

            if (musteri.getCinsiyet().equalsIgnoreCase("erkek")) {

                bmh = 66 + (13.75 * musteri.getKilo()) + (5 * musteri.getBoy()) + (6.8 * musteri.getYas());
                topKalori = (1.2 * bmh) - 250.0;
                topProtein = (yagsizKutle * 2.0);
                topYag = yagsizKutle;
                topKarbonhidrat = (topKalori - ((topYag * 9) + (topProtein * 4))) / 4;

                kalorilerListesi.add(topKalori);
                kalorilerListesi.add(topProtein);
                kalorilerListesi.add(topYag);
                kalorilerListesi.add(topKarbonhidrat);

            } else {  //kadın
                bmh = 665 + (9.6 * musteri.getKilo()) + (1.7 * musteri.getBoy()) + (4.7 * musteri.getYas());
                topKalori = (1.2 * bmh) - 200.0;
                topProtein = (yagsizKutle * 2.0);
                topYag = yagsizKutle;
                topKarbonhidrat = (topKalori - ((topYag * 9) + (topProtein * 4))) / 4;

                kalorilerListesi.add(topKalori);
                kalorilerListesi.add(topProtein);
                kalorilerListesi.add(topYag);
                kalorilerListesi.add(topKarbonhidrat);
            }
        } else {
            return null;
        }
        System.out.println("BMH :" + bmh + "YAĞSIZ KÜTLE: " + yagsizKutle + "  TOPLAM KALORİ: " + kalorilerListesi.get(0) + "  TOPLAM PROTEİN :" + kalorilerListesi.get(1)
                + " TOPLAM YAG :" + kalorilerListesi.get(2) + " TOPLAM KARBONHİDRAT :" + kalorilerListesi.get(3));
        return kalorilerListesi;
    }

    public void yemekEkle(Besin besin, Musteri m) {
        try {   // musteri_besin tablosuna besin ekliyoruz!
            pst = this.getConnection().prepareStatement("insert into musteri_besin (musteri_id,besin_id) values(?,?)");
            pst.setInt(1, m.getMusteri_id());
            pst.setInt(2, besin.getBesin_id());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
            System.out.println("MusteriDAO HATA(YemekEkle) :" + ex.getMessage());
        }
    }

    public List<Double> tuketilenMakroHesapla(Musteri musteri) {
        List<Double> list = new ArrayList();
        double kalori = 0.0;
        double karbonhidrat = 0.0;
        double protein = 0.0;
        double yag = 0.0;
        if (musteri.getTuketilenBesinler().size() != 0) {
            for (int i = 0; i < musteri.getTuketilenBesinler().size(); i++) {
                kalori += musteri.getTuketilenBesinler().get(i).getKalori();
                karbonhidrat += musteri.getTuketilenBesinler().get(i).getKarbonhidrat();
                protein += musteri.getTuketilenBesinler().get(i).getProtein();
                yag += musteri.getTuketilenBesinler().get(i).getYag();
            }
        }
        list.add(kalori);
        list.add(karbonhidrat);
        list.add(protein);
        list.add(yag);
        return list;
    }
}
