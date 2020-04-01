
package entity;


public class Besinkategori {
    
    private int besinkategori_id;
    private String besinkategori_isim;

    public Besinkategori() {
    }

    public Besinkategori(int besinkategori_id, String besinkategori_isim) {
        this.besinkategori_id = besinkategori_id;
        this.besinkategori_isim = besinkategori_isim;
    }

    public int getBesinkategori_id() {
        return besinkategori_id;
    }

    public void setBesinkategori_id(int besinkategori_id) {
        this.besinkategori_id = besinkategori_id;
    }

    public String getBesinkategori_isim() {
        return besinkategori_isim;
    }

    public void setBesinkategori_isim(String besinkategori_isim) {
        this.besinkategori_isim = besinkategori_isim;
    }

    @Override
    public String toString() {
        return "Besinkategori{" + "besinkategori_id=" + besinkategori_id + ", besinkategori_isim=" + besinkategori_isim + '}';
    }
    
    
}
