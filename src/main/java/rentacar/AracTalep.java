package rentacar;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

public class AracTalep {

    private String alinacakSehir;

    private String teslimEdilecekSehir;
    private LocalDate alinacakGun;

    private LocalDate teslimGunu;
    private double toplamUcret;


    public AracTalep(String alinacakSehir, String teslimEdilecekSehir, LocalDate alinacakGun, LocalDate teslimGunu, double toplamUcret) {
        this.alinacakSehir = alinacakSehir;
        this.teslimEdilecekSehir=teslimEdilecekSehir;
        this.alinacakGun = alinacakGun;
        this.teslimGunu = teslimGunu;
        this.toplamUcret=toplamUcret;

    }

    public AracTalep() {
    }

    public String getTeslimEdilecekSehir() {
        return teslimEdilecekSehir;
    }

    public void setTeslimEdilecekSehir(String teslimEdilecekSehir) {
        this.teslimEdilecekSehir = teslimEdilecekSehir;
    }

    public String getAlinacakSehir() {
        return alinacakSehir;
    }

    public void setAlinacakSehir(String alinacakSehir) {
        this.alinacakSehir = alinacakSehir;
    }

    public LocalDate getAlinacakGun() {
        return alinacakGun;
    }

    public void setAlinacakGun(LocalDate alinacakGun) {
        this.alinacakGun = alinacakGun;
    }





    public LocalDate getTeslimGunu() {
        return teslimGunu;
    }

    public void setTeslimGunu(LocalDate teslimGunu) {
        this.teslimGunu = teslimGunu;
    }

    public double getToplamUcret() {
        return toplamUcret;
    }

    public void setToplamUcret(double toplamUcret) {
        this.toplamUcret = toplamUcret;
    }

    @Override
    public String toString() {
        return
                "Aracin alinacagi sehir='" + alinacakSehir + '\'' +
                ", Aracin teslim edilecegi sehir='" + teslimEdilecekSehir + '\'' +
                ", Alinacagi tarih=" + alinacakGun +
                ", Teslim edilecegi tarih=" + teslimGunu +
                ", Toplam Ucret=" + toplamUcret ;
    }
}
