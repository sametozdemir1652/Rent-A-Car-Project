package rentacar;

public class MusteriBilgileri {

    private String adSoyad;
    private String ID;
    private int yas;
    private String telefonNumarasi;

    public MusteriBilgileri(String adSoyad, String ID, int yas, String telefonNumarasi) {
        this.adSoyad = adSoyad;
        this.ID = ID;
        this.yas = yas;
        this.telefonNumarasi = telefonNumarasi;
    }

    public MusteriBilgileri() {

    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public String getTelefonNumarasi() {
        return telefonNumarasi;
    }

    public void setTelefonNumarasi(String telefonNumarasi) {
        this.telefonNumarasi = telefonNumarasi;
    }

    @Override
    public String toString() {
        return
                "Ad Soyad='" + adSoyad + '\'' +
                ", ID='" + ID + '\'' +
                ", Yas=" + yas +
                ", Telefon Numarasi='" + telefonNumarasi;
    }
}
