package SystemsController;

import dao.BesinDAO;
import entity.Besin;
import java.util.List;

public class BesinSystem {

    private BesinDAO bdao;
    private Besin besin;

    private List<Besin> blist;

    public void create() {
        this.getBdao().insert(this.besin);
    }

    public void update() {
        this.getBdao().update(this.besin);
    }

    public void delete() {
        this.getBdao().delete(this.besin);
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

    public Besin getBesin() {
        if (this.besin == null) {
            this.besin = new Besin();
        }
        return besin;
    }

    public void setBesin(Besin besin) {
        this.besin = besin;
    }

    public List<Besin> getBlist() {
        this.blist = this.getBdao().read();
        return blist;
    }

    public void setBlist(List<Besin> blist) {
        this.blist = blist;
    }

}
