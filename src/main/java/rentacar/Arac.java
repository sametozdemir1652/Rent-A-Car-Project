package rentacar;

public class Arac {

    private String marka;
    private String model;
    private String yakitTipi;
    private String vites;
    private double gunlukUcret;

    public Arac(String marka, String model, String yakitTipi, String vites, double gunlukUcret) {
        this.marka = marka;
        this.model = model;
        this.yakitTipi = yakitTipi;
        this.vites = vites;
        this.gunlukUcret = gunlukUcret;
    }

    public Arac() {
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYakitTipi() {
        return yakitTipi;
    }

    public void setYakitTipi(String yakitTipi) {
        this.yakitTipi = yakitTipi;
    }

    public String getVites() {
        return vites;
    }

    public void setVites(String vites) {
        this.vites = vites;
    }

    public double getGunlukUcret() {
        return gunlukUcret;
    }

    public void setGunlukUcret(double gunlukUcret) {
        this.gunlukUcret = gunlukUcret;
    }

    @Override
    public String toString() {
        return
                "Marka='" + marka + '\''+
                ", Model='" + model + '\'' +
                ", Yakit Tipi='" + yakitTipi + '\'' +
                ", Vites='" + vites + '\'' +
                ", Gunluk ucret=" + gunlukUcret;
    }
}
