package SystemsController;

import dao.KullaniciDAO;
import entity.Kullanici;
import java.util.List;

public class KullaniciSystem {

    private KullaniciDAO kdao;
    private Kullanici kullanici;

    private List<Kullanici> klist;

    public Kullanici Login(String login_name, String password) {

        for (int i = 0; i < this.getKlist().size(); i++) {
            if (this.getKlist().get(i).getLogin_name().equalsIgnoreCase(login_name) && this.getKlist().get(i).getPassword().equalsIgnoreCase(password)) {
                return this.getKlist().get(i);
            }
        }
        return null;
    }

    public KullaniciDAO getKdao() {
        if (this.kdao == null) {
            this.kdao = new KullaniciDAO();
        }
        return kdao;
    }

    public void setKdao(KullaniciDAO kdao) {
        this.kdao = kdao;
    }

    public Kullanici getKullanici() {
        if (this.kullanici == null) {
            this.kullanici = new Kullanici();
        }
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    public List<Kullanici> getKlist() {
        this.klist = this.getKdao().read();
        return klist;
    }

    public void setKlist(List<Kullanici> klist) {
        this.klist = klist;
    }

}
