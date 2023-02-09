package rentacar;

import java.time.LocalDate;

public class Validators {

    public static void yasValidator(int yas){
        if (yas<18){
            System.out.println("18 yasindan kucukler arac kiralayamaz");
            MusteriveAracBilgileri.aracMenu();
        }
    }

    public static void adSoyadValidator(String adSoyad ){

        if (adSoyad.replaceAll(" ","").replaceAll("[a-zA-Z]","").length()>0){
            System.out.println("Ad ve soyad harfler haric baska degerler iceremez");
            MusteriveAracBilgileri.aracMenu();
        }
    }

    public static void kimlikNoValidator(String kimlikNo){
        if (kimlikNo.replaceAll("[0-9]","").length()>0 || kimlikNo.length()!=4){
            System.out.println("Kimlik numarasi 4'ten kucuk olamaz ve rakamdan baska karakter iceremez... \n");
            MusteriveAracBilgileri.aracMenu();
        }
    }

    public static void kartBilgileriValidator(String kartNumarasi, String cvvKodu){

        if (kartNumarasi.length()!=12 || kartNumarasi.replaceAll("[0-9]","").length()>0 ){
            System.out.println("Kart numarasi 12 haneli olmali ve sadece rakamlardan olusmalidir...");
            MusteriveAracBilgileri.aracMenu();
        }
        if (cvvKodu.length()!=3 || cvvKodu.replaceAll("[0-9]","").length()>0){
            System.out.println("Cvv kodu 3 haneli olmali ve sadece rakamlardan olusmalidir");
            MusteriveAracBilgileri.aracMenu();
        }

    }

    public static void telefonNoValidator(String telefonNo){
        if (telefonNo.charAt(0)==0 || telefonNo.replaceAll("[0-9]","").length()>0 || telefonNo.length()!=10){
            System.out.println("Telefon numaranizi basinda 0 olmadan on haneli olarak giriniz...");
            MusteriveAracBilgileri.aracMenu();
        }
    }

    public static void tarihValidator(LocalDate teslimAlinacakGun, LocalDate teslimEdilecekGun){
        if (teslimEdilecekGun.isBefore(teslimAlinacakGun)){
            System.out.println("Aracin teslim edilecegi gun teslim alinacagi gunden once olamaz...");
            MusteriveAracBilgileri.aracMenu();
        }
    }

}
