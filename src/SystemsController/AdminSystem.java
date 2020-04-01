package SystemsController;

import dao.AdminDAO;
import entity.Admin;
import entity.Kullanici;
import java.util.List;

public class AdminSystem {

    private AdminDAO adao;
    private Admin admin;

    private List<Admin> alist;

    public void create(){
        this.getAdao().insert(this.admin);
    }
    public void update(){
        this.getAdao().update(this.admin);
    }
    public void delete(){
        this.getAdao().delete(this.admin);
    }
    
    public boolean AdminMi(Kullanici k) {

        for (int i = 0; i < this.getAlist().size(); i++) {

            if (this.getAlist().get(i).getKullanici_id() == k.getKullanici_id()) {
                return true;
            }
        }
        return false;
    }

    public AdminDAO getAdao() {
        if (this.adao == null) {
            this.adao = new AdminDAO();
        }
        return adao;
    }

    public void setAdao(AdminDAO adao) {
        this.adao = adao;
    }

    public Admin getAdmin() {
        if (this.admin == null) {
            this.admin = new Admin();
        }
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<Admin> getAlist() {
        this.alist = this.getAdao().read();
        return alist;
    }

    public void setAlist(List<Admin> alist) {
        this.alist = alist;
    }

}
