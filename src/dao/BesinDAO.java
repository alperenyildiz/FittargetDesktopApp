package dao;

import entity.Besin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BesinDAO extends SuperDAO {

    PreparedStatement pst = null;
    ResultSet rs = null;

    private BesinkategoriDAO bkdao;

    public void insert(Besin besin) {

        try {
            pst = this.getConnection().prepareStatement("insert into besin (isim,kalori,karbonhidrat,protein,yag,besinkategori_id) values(?,?,?,?,?,?)");
            pst.setString(1, besin.getIsim());
            pst.setDouble(2, besin.getKalori());
            pst.setDouble(3, besin.getKarbonhidrat());
            pst.setDouble(4, besin.getProtein());
            pst.setDouble(5, besin.getYag());
            pst.setInt(6, besin.getBesinkategori().getBesinkategori_id());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println(" BesinDAO HATA(Create): " + ex.getMessage());
        }
    }

    public void delete(Besin besin) {

        try {
            pst = this.getConnection().prepareStatement("delete from besin where besin_id=?");
            pst.setInt(1, besin.getBesin_id());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
            System.out.println(" MusteriDAO HATA(Delete): " + ex.getMessage());
        }
    }

    public List<Besin> read() {
        List<Besin> mlist = new ArrayList();

        try {
            pst = this.getConnection().prepareStatement("select * from besin order by besin_id asc");
            rs = pst.executeQuery();
            while (rs.next()) {
                Besin temp = new Besin();
                temp.setBesin_id(rs.getInt("besin_id"));
                temp.setBesinkategori(this.getBkdao().find(rs.getInt("besinkategori_id")));
                temp.setIsim(rs.getString("isim"));
                temp.setKalori(rs.getDouble("kalori"));
                temp.setKarbonhidrat(rs.getDouble("karbonhidrat"));
                temp.setYag(rs.getDouble("yag"));
                temp.setProtein(rs.getDouble("protein"));
                mlist.add(temp);
            }
        } catch (SQLException ex) {
            System.out.println("BesinDAO HATA(READ):" + ex.getMessage());
        }
        return mlist;
    }

    public List<Besin> ara(String deger) {
        List<Besin> list = new ArrayList();
        try {

            pst = this.getConnection()
                    .prepareStatement("select * from besin where isim ilike ? order by besin_id asc");
            pst.setString(1, "%" + deger + "%");
            rs = pst.executeQuery();

            while (rs.next()) {
                Besin besin = new Besin();
                besin.setBesin_id(rs.getInt("besin_id"));
                besin.setIsim(rs.getString("isim"));
                besin.setKalori(rs.getDouble("kalori"));
                besin.setKarbonhidrat(rs.getDouble("karbonhidrat"));
                besin.setProtein(rs.getDouble("protein"));
                besin.setYag(rs.getDouble("yag"));
                besin.setBesinkategori(this.getBkdao().find(rs.getInt("besinkategori_id")));

                list.add(besin);

            }
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            System.out.println("BesinDAO(ara) Hata:" + ex.getMessage());
        } finally {
            this.disconnect();
        }
        return list;
    }

    public void update(Besin besin) {

        try {
            pst = this.getConnection().prepareStatement("update besin set isim=?,kalori=?,karbonhidrat=?,protein=?,yag=?,besinkategori_id=? where besin_id=?");
            pst.setString(1, besin.getIsim());
            pst.setDouble(2, besin.getKalori());
            pst.setDouble(3, besin.getKarbonhidrat());
            pst.setDouble(4, besin.getProtein());
            pst.setDouble(5, besin.getYag());
            pst.setDouble(6, besin.getBesinkategori().getBesinkategori_id());
            pst.setDouble(7, besin.getBesin_id());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
            System.out.println(" BesinDAO HATA(Update): " + ex.getMessage());
        }
    }

    public Besin find(int id) {
        Besin b = null;
        try {
            pst = this.getConnection().prepareStatement("select * from besin where besin_id=?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            rs.next();
            b = new Besin();
            b.setBesin_id(rs.getInt("besin_id"));
            b.setBesinkategori(this.getBkdao().find(rs.getInt("besinkategori_id")));
            b.setIsim(rs.getString("isim"));
            b.setKalori(rs.getDouble("kalori"));
            b.setKarbonhidrat(rs.getDouble("karbonhidrat"));
            b.setProtein(rs.getDouble("protein"));
            b.setYag(rs.getDouble("yag"));
        } catch (SQLException ex) {
            System.out.println("BesinDAO HATA(FİND) :" + ex.getMessage());
        }
        return b;
    }

    public List<Besin> getTuketilenBesinler(int musteri_id) {
        List<Besin> list = new ArrayList<>();

        try {
            PreparedStatement pst1 = this.getConnection().prepareStatement("select * from musteri_besin where musteri_id=?");
            pst1.setInt(1, musteri_id);
            ResultSet rs1 = pst1.executeQuery();

            while (rs1.next()) {

                list.add(this.find(rs1.getInt("besin_id")));
            }
        } catch (SQLException ex) {
            System.out.println("YetkiDAO HATA(getKullaniciYetkileri): " + ex.getMessage());
        }
        return list;
    }

    public BesinkategoriDAO getBkdao() {
        if (this.bkdao == null) {
            this.bkdao = new BesinkategoriDAO();
        }
        return bkdao;
    }

    public void setBkdao(BesinkategoriDAO bkdao) {
        this.bkdao = bkdao;
    }

}
