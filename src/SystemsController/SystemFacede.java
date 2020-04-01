package SystemsController;

public class SystemFacede {

    private AdminSystem adminSystem;
    private MusteriSystem musteriSystem;
    private BesinSystem besinSystem;
    private BesinkategoriSystem besinkategoriSystem;
    private KullaniciSystem kullaniciSystem;

    private NoticeObservableSystem noticeObservableSystem;

    public SystemFacede() {

    }

    public AdminSystem getAdminSystem() {
        if (this.adminSystem == null) {
            this.adminSystem = new AdminSystem();
        }
        return adminSystem;
    }

    public void setAdminSystem(AdminSystem adminSystem) {

        this.adminSystem = adminSystem;
    }

    public MusteriSystem getMusteriSystem() {
        if (this.musteriSystem == null) {
            this.musteriSystem = new MusteriSystem();
        }
        return musteriSystem;
    }

    public void setMusteriSystem(MusteriSystem musteriSystem) {
        this.musteriSystem = musteriSystem;
    }

    public BesinSystem getBesinSystem() {
        if (this.besinSystem == null) {
            this.besinSystem = new BesinSystem();
        }
        return besinSystem;
    }

    public void setBesinSystem(BesinSystem besinSystem) {
        this.besinSystem = besinSystem;
    }

    public BesinkategoriSystem getBesinkategoriSystem() {
        if (this.besinkategoriSystem == null) {
            this.besinkategoriSystem = new BesinkategoriSystem();
        }
        return besinkategoriSystem;
    }

    public void setBesinkategoriSystem(BesinkategoriSystem besinkategoriSystem) {
        this.besinkategoriSystem = besinkategoriSystem;
    }

    public KullaniciSystem getKullaniciSystem() {
        if (this.kullaniciSystem == null) {
            this.kullaniciSystem = new KullaniciSystem();
        }
        return kullaniciSystem;
    }

    public void setKullaniciSystem(KullaniciSystem kullaniciSystem) {
        this.kullaniciSystem = kullaniciSystem;
    }

    public NoticeObservableSystem getNoticeObservableSystem() {
        if (this.noticeObservableSystem == null) {
            this.noticeObservableSystem = new NoticeObservableSystem();
        }
        return noticeObservableSystem;
    }

    public void setNoticeObservableSystem(NoticeObservableSystem noticeObservableSystem) {
        this.noticeObservableSystem = noticeObservableSystem;
    }

}
