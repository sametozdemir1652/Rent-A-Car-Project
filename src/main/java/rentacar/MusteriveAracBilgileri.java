package rentacar;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class MusteriveAracBilgileri {

    static Scanner input=new Scanner(System.in);
    public static List<Arac> aracList =new ArrayList<>(Arrays.asList());
    public static List<Arac> kiralananAraclarList =new ArrayList<>(Arrays.asList());
    public static List<OdemeBilgileri> musteriKartBilgileri=new ArrayList<>();
    public static List<MusteriBilgileri> musteriKimlikBilgileri=new ArrayList<>();
    public static List<AracTalep> sehirVeGunSayisiList=new ArrayList<>();





    static Arac egea=new Arac("Fiat","Egea","Benzin","Manuel",250);
    static Arac clio=new Arac("Renault","Clio","Dizel","Manuel",300);
    static Arac megane=new Arac("Renault","Megane","Dizel","Otomatik",350);
    static Arac c_elysee=new Arac("Citroen","C_elysee","Benzin","Manuel",250);





    public static void aracOlustur(){

        aracList.add(egea);
        aracList.add(clio);
        aracList.add(megane);
        aracList.add(c_elysee);


    }

    public static void anaMenu(){

        System.out.println("1-Arac kirala\n" +
                           "2-Yonetici paneline git\n" +
                           "0-Cikis yap    ");

        String secim=input.next();
        switch (secim){
            case "1":
                aracMenu();
                break;
            case "2":
                yoneticiPaneli();
                break;
            case "0":
                System.out.println("Sistemden cikis yapiliyor...");
                break;
            default:
                System.out.println("Gecersiz secim yaptiniz, tekrar deneyiniz");
                anaMenu();
        }

    }

    public static void yoneticiPaneli(){

        System.out.println("Kiralanan araclari ve kiralama bilgilerini gormek icin 1'e'\n" +
                "Ana menuye ulasmak icin 2'e\n" +
                "Cikmak icin 0'a basiniz    ");

        String secim=input.next();
        switch (secim){
            case "1":
                kiralananAraclariVeBilgileriniYazdir();
                yoneticiPaneli();
                break;
            case "2":
                anaMenu();
                break;
            case "0":
                System.out.println("Sistemden cikis yapiliyor...");
                break;
            default:
                System.out.println("Gecersiz secim yaptiniz, tekrar deneyiniz...");
                yoneticiPaneli();
        }

    }

    public static void aracMenu(){
        for (int i = 0; i < aracList.size(); i++) {
            System.out.println(i+1+")"+aracList.get(i));
        }

        System.out.println();
        System.out.println("========RENT A CAR========"+"\n");
        System.out.println("Kiralamak istediginiz aracin modelini yaziniz: \n"+
                           "9-Ana Menu\n" +
                           "0-Cikis");
        String  secim=input.next().toLowerCase();

        switch (secim){
            case "egea":
                kiralamaBilgileri(egea);
                break;
            case "clio":
                kiralamaBilgileri(clio);
                break;
            case "megane":
                kiralamaBilgileri(megane);
                break;
            case "c_elysee":
                kiralamaBilgileri(c_elysee);
                break;
            case "0":
                System.out.println("Sistemden cikiliyor...");
                break;
            case "9":
                anaMenu();
                break;
            default:
                System.out.println("Yanlis tuslama yaptiniz tekrar deneyiniz...");
                aracMenu();

        }
    }

    public static void kiralamaBilgileri(Arac arac){

        aracTalepBilgileri(arac);



        System.out.println("Kiralamaya devam etmek icin 1'e\n" +
                           "Ana menuye donmek icin 2'ye\n" +
                           "Cikmak icin 0'a basin");
        String secim=input.next();

        switch (secim){

            case "1":
                musteriBilgileri();
                odemeBilgileri();
                kiralananAraclarList.add(arac);
                aracList.remove(arac);
                anaMenu();
                break;
            case "2":
                aracMenu();
                break;
            case "0":
                System.out.println("Sistemden cikis yapiliyor");
            default:
                System.out.println("Gecersiz bir deger girdiniz, ana menuye aktariliyorsunuz...");
                aracMenu();
        }


    }

    public static void aracTalepBilgileri(Arac arac){
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Alinacak sehir:");
        String alinacakSehir=input.next();

        System.out.println("Teslim edilecek sehir:");
        String teslimEdilecekSehir=input.next();

        System.out.println("Teslim alinacak tarihi su şekilde girin (gg/aa/yyyy): ");
        LocalDate alinacakGun= null;
        try {
            alinacakGun = LocalDate.parse(input.next(),dtf);
        } catch (DateTimeParseException e) {
            System.out.println("Tarihi istenilen formatta giriniz! \n");
            aracMenu();
        }


        System.out.println("Teslim edilecek tarihi su şekilde girin (gg/aa/yyyy):");
        LocalDate teslimEdilecekGun= null;
        try {
            teslimEdilecekGun = LocalDate.parse(input.next(),dtf);
        } catch (DateTimeParseException e) {
            System.out.println("Tarihi istenilen formatta giriniz! \n");
            aracMenu();
        }

        Validators.tarihValidator(alinacakGun,teslimEdilecekGun);

        long gunSayisi=ChronoUnit.DAYS.between(alinacakGun,teslimEdilecekGun);
        System.out.println(gunSayisi);
        double toplamUcret=toplamUcretHesapla(arac.getGunlukUcret(),gunSayisi);
        System.out.println("Toplam odenecek ucret "+toplamUcret+" TL \n");

        AracTalep aracTalepBilgileri=new AracTalep(alinacakSehir,teslimEdilecekSehir,alinacakGun,teslimEdilecekGun,toplamUcret);
        sehirVeGunSayisiList.add(aracTalepBilgileri);


    }

    public static double toplamUcretHesapla(double gunlukUcret,long gunSayisi){

        return gunlukUcret*gunSayisi;

    }

    public static void odemeBilgileri(){

        System.out.println("Kart sahibinin adi ve soyadi: ");
        input.nextLine();
        String adSoyad=input.nextLine();
        Validators.adSoyadValidator(adSoyad);

        System.out.println("12 haneli kart numarasi: ");
        String kartNumarasi=input.nextLine();

        System.out.println("Kartin arkasinda yer alan 3 haneli CVC kodunu giriniz: ");
        String  cvvKodu= input.next();
        Validators.kartBilgileriValidator(kartNumarasi,cvvKodu);

        OdemeBilgileri kartbilgileri=new OdemeBilgileri(adSoyad,kartNumarasi,cvvKodu);
        musteriKartBilgileri.add(kartbilgileri);

        System.out.println("Odeme basariyla gerceklestirildi...");


    }

    public static void musteriBilgileri(){

        System.out.println("Ad ve soyad: ");
        input.nextLine();
        String adSoyad=input.nextLine().trim();
        Validators.adSoyadValidator(adSoyad);

        System.out.println("Kimlik numaranizi giriniz:");
        String ID=input.next();
        Validators.kimlikNoValidator(ID);

        System.out.println("Yasinizi giriniz");
        int yas= 0;
        try {
            yas = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Sadece rakamsal degerler girebilirsiniz...");
            aracMenu();
        }
        Validators.yasValidator(yas);


        System.out.println("Telefon numaranizi basinda sifir olmadan giriniz: ");
        String telefonNumarasi= input.next();
        Validators.telefonNoValidator(telefonNumarasi);

        MusteriBilgileri kimlikBilgileri=new MusteriBilgileri(adSoyad,ID,yas,telefonNumarasi);
        musteriKimlikBilgileri.add(kimlikBilgileri);

    }

    public static void kiralananAraclariVeBilgileriniYazdir(){

        for (int i = 0; i < kiralananAraclarList.size(); i++) {

                System.out.println(kiralananAraclarList.get(i));
                System.out.println(musteriKimlikBilgileri.get(i));
                System.out.println(sehirVeGunSayisiList.get(i));
            System.out.println();

        }



    }

}
