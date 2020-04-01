package Observer;

import SystemsController.SystemFacede;
import entity.Musteri;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class NoticeObservable implements Observable {  //Observable interface'inin özelliklerinin genişletilmesi bu sınıfta tanımlandı.
    //Herhangi bir duyuru oluşturulup o duyuruya yeni kullanıcılar eklenebilir.

    private int id; // *
    private List<Observer> observerList;
    private String message;

    private Date ilan_tarihi; //*
    private SystemFacede systemFacede;

    public NoticeObservable() {
        this.observerList = new ArrayList();
        this.message = "18.05.2019 Cumartesi Günü Saat 14:00'da gerçekleşecek olan 2. FitTarget Türkiye festivaline davetlisiniz. \nFit Target Ekibi!";
        this.ObserverListCasting();
    }

    @Override
    public void addObserver(Observer observer) {
        this.observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observerList.remove(observer);
    }

    @Override
    public String notifyObserver(int kullanici_id) {
        for (Observer observer : observerList) {
            Musteri m;

            m = (Musteri) observer;
            if (m.getKullanici_id() == kullanici_id) {
                return observer.notify(message);

            }

        }
        return "";
    }

    public void ObserverListCasting() {
        List<Musteri> mlist = this.getSystemFacede().getMusteriSystem().getMdao().readActiveNotifyUsers();
        for (int i = 0; i < mlist.size(); i++) {
            this.observerList.add(mlist.get(i));
        }
    }

    public List<Observer> getObserverList() {

        return observerList;
    }

    public void setObserverList(List<Observer> observerList) {
        this.observerList = observerList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SystemFacede getSystemFacede() {
        if (this.systemFacede == null) {
            this.systemFacede = new SystemFacede();
        }
        return systemFacede;
    }

    public void setSystemFacede(SystemFacede systemFacede) {
        this.systemFacede = systemFacede;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getIlan_tarihi() {
        return ilan_tarihi;
    }

    public void setIlan_tarihi(Date ilan_tarihi) {
        this.ilan_tarihi = ilan_tarihi;
    }

}
