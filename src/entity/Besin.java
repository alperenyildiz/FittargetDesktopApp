
package entity;


public class Besin {
    
    private int besin_id;
    private String isim;
    private Double kalori;
    private Double karbonhidrat;
    private Double protein;
    private Double yag;
    
    private Besinkategori besinkategori;

    public Besin() {
    }

    public Besin(int besin_id, String isim, Double kalori, Double karbonhidrat, Double protein, Double yag) {
        this.besin_id = besin_id;
        this.isim = isim;
        this.kalori = kalori;
        this.karbonhidrat = karbonhidrat;
        this.protein = protein;
        this.yag = yag;
    }

  

    public int getBesin_id() {
        return besin_id;
    }

    public void setBesin_id(int besin_id) {
        this.besin_id = besin_id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public Double getKalori() {
        return kalori;
    }

    public void setKalori(Double kalori) {
        this.kalori = kalori;
    }

    public Double getKarbonhidrat() {
        return karbonhidrat;
    }

    public void setKarbonhidrat(Double karbonhidrat) {
        this.karbonhidrat = karbonhidrat;
    }

    public Double getProtein() {
        return protein;
    }

    public void setProtein(Double protein) {
        this.protein = protein;
    }

    public Double getYag() {
        return yag;
    }

    public void setYag(Double yag) {
        this.yag = yag;
    }

    public Besinkategori getBesinkategori() {
      
        return besinkategori;
    }

    public void setBesinkategori(Besinkategori besinkategori) {
        this.besinkategori = besinkategori;
    }

    @Override
    public String toString() {
        return "Besin{" + "besin_id=" + besin_id + ", isim=" + isim + ", kalori=" + kalori + ", karbonhidrat=" + karbonhidrat + ", protein=" + protein + ", yag=" + yag + ", besinkategori=" + besinkategori + '}';
    }

 

    
    
    
}
