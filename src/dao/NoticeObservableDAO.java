package dao;

import Observer.NoticeObservable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NoticeObservableDAO extends SuperDAO {
    
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public void insert(NoticeObservable noticeObservable) {
        
        try {
            pst = this.getConnection().prepareStatement("insert into duyuru (mesaj) values(?)");
            pst.setString(1, noticeObservable.getMessage());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println(" DuyuruDAO HATA(Create): " + ex.getMessage());
        }
    }
    
    public void delete(NoticeObservable noticeObservable) {
        
        try {
            pst = this.getConnection().prepareStatement("delete from duyuru where id=?");
            pst.setInt(1, noticeObservable.getId());
            pst.executeUpdate();
            pst.close();
            
        } catch (SQLException ex) {
            System.out.println("DuyuruDAO HATA(Delete): " + ex.getMessage());
        }
    }
    
    public List<NoticeObservable> read() {
        List<NoticeObservable> noticelist = new ArrayList();
        
        try {
            pst = this.getConnection().prepareStatement("select * from duyuru order by id asc");
            rs = pst.executeQuery();
            while (rs.next()) {
                NoticeObservable temp = new NoticeObservable();
                temp.setId(rs.getInt("id"));
                temp.setMessage(rs.getString("mesaj"));
                temp.setIlan_tarihi(rs.getDate("ilan_tarihi"));
                noticelist.add(temp);
            }
        } catch (SQLException ex) {
            System.out.println("DuyuruDAO HATA(READ):" + ex.getMessage());
        }
        return noticelist;
    }
    
    public void update(NoticeObservable noticeObservable) {
        
        try {
            pst = this.getConnection().prepareStatement("update duyuru set mesaj=? where id=?");
            pst.setString(1, noticeObservable.getMessage());
            pst.setInt(2, noticeObservable.getId());
            pst.executeUpdate();
            pst.close();
            
        } catch (SQLException ex) {
            System.out.println(" DuyuruDAO HATA(Update): " + ex.getMessage());
        }
    }
    
}
