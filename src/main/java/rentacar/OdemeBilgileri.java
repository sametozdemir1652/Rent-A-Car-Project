package rentacar;

public class OdemeBilgileri {

    private String kartSahibiAdSoyad;
    private String kartNumarasi;
    private String  cvv;

    public OdemeBilgileri(String kartSahibiAdSoyad, String kartNumarasi, String CVC) {
        this.kartSahibiAdSoyad = kartSahibiAdSoyad;
        this.kartNumarasi = kartNumarasi;
        this.cvv = CVC;
    }

    public OdemeBilgileri() {
    }

    public String getKartSahibiAdSoyad() {
        return kartSahibiAdSoyad;
    }

    public void setKartSahibiAdSoyad(String kartSahibiAdSoyad) {
        this.kartSahibiAdSoyad = kartSahibiAdSoyad;
    }

    public String getKartNumarasi() {
        return kartNumarasi;
    }

    public void setKartNumarasi(String kartNumarasi) {
        this.kartNumarasi = kartNumarasi;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    @Override
    public String toString() {
        return "OdemeBilgileri{" +
                "kartSahibiAdSoyad='" + kartSahibiAdSoyad + '\'' +
                ", kartNumarasi='" + kartNumarasi + '\'' +
                ", CVC=" + cvv +
                '}';
    }
}
