package SystemsController;

import dao.BesinkategoriDAO;
import entity.Besinkategori;
import java.util.List;

public class BesinkategoriSystem {

    private BesinkategoriDAO bkdao;
    private Besinkategori bk;

    private List<Besinkategori> bklist;

    public void create() {
        this.getBkdao().insert(this.bk);
    }

    public void update() {
        this.getBkdao().update(this.bk);
    }

    public void delete() {
        this.bkdao.delete(this.bk);
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

    public Besinkategori getBk() {
        if (this.bk == null) {
            this.bk = new Besinkategori();
        }
        return bk;
    }

    public void setBk(Besinkategori bk) {
        this.bk = bk;
    }

    public List<Besinkategori> getBklist() {
        this.bklist = this.getBkdao().read();
        return bklist;
    }

    public void setBklist(List<Besinkategori> bklist) {
        this.bklist = bklist;
    }

}
