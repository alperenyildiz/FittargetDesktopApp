package SystemsController;

import dao.MusteriDAO;
import entity.Kullanici;
import entity.Musteri;
import java.util.ArrayList;
import java.util.List;

public class MusteriSystem {

    private MusteriDAO mdao;
    private Musteri m;

    private List<Musteri> mlist;

    public void create() {
        List<Double> klist = new ArrayList();
        klist = this.getMdao().kaloriHesapla(this.m);
        this.getM().setGunluk_kalori_ihtiyaci(klist.get(0));
        this.getM().setGunluk_protein_ihtiyaci(klist.get(1));
        this.getM().setGunluk_yag_ihtiyaci(klist.get(2));
        this.getM().setGunluk_karbonhidrat_ihtiyaci(klist.get(3));

        this.getMdao().insert(this.m);
    }

    public void update() {
        List<Double> klist = new ArrayList();
        klist = this.getMdao().kaloriHesapla(this.m);
        this.getM().setGunluk_kalori_ihtiyaci(klist.get(0));
        this.getM().setGunluk_protein_ihtiyaci(klist.get(1));
        this.getM().setGunluk_yag_ihtiyaci(klist.get(2));
        this.getM().setGunluk_karbonhidrat_ihtiyaci(klist.get(3));
        
        this.getMdao().update(this.m);
    }

    public void delete() {
        this.mdao.delete(this.m);
    }

    public boolean MusteriMi(Kullanici k) {

        for (int i = 0; i < this.getMlist().size(); i++) {

            if (this.getMlist().get(i).getKullanici_id() == k.getKullanici_id()) {
                return true;
            }
        }
        return false;
    }

    public MusteriDAO getMdao() {
        if (this.mdao == null) {
            this.mdao = new MusteriDAO();
        }
        return mdao;
    }

    public void setMdao(MusteriDAO mdao) {
        this.mdao = mdao;
    }

    public Musteri getM() {
        if (this.m == null) {
            this.m = new Musteri();
        }
        return m;
    }

    public void setM(Musteri m) {
        this.m = m;
    }

    public List<Musteri> getMlist() {
        this.mlist = this.getMdao().read();
        return mlist;
    }

    public void setMlist(List<Musteri> mlist) {
        this.mlist = mlist;
    }

}
