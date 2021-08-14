package StreamProje01;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Ogrenci> ogrListesi = new ArrayList<>();//listemizi oluşturduk ama içi boş, aşağıda veri ekleyelim
    public static void main(String[] args) {


        testOgrenciOlustur();
        //isme göre sıralayan bir method yapalım
        ismeGoreSirala("Ahmet");
        ismeGoreSirala("Ayşe");
        ismeGoreSirala("Jhon");//john listede olmadığı için birşey yazdırmadı
/*
ad='Ahmet', soyAd='Can', yas=30, diplomaNotu=88.4, cinsiyet='erkek'
ad='Ahmet', soyAd='Baki', yas=18, diplomaNotu=90.1, cinsiyet='erkek'
ad='Ayşe', soyAd='Can', yas=21, diplomaNotu=82.3, cinsiyet='kadın'
ad='Ayşe', soyAd='Yılmaz', yas=40, diplomaNotu=45.0, cinsiyet='kadın'
 */
    }
    private static void ismeGoreSirala(String isim){
        //t. dediğimizde her bir öğrenci objesini alır, her bir filterla isimler aranan ismi filtreler
        //gelen isimler içerisinde aradığımız isimde eşit olanları göster methodu yazıyoruz.. for eachle herbirini yazdır diyoruz
        ogrListesi.stream().filter(t->t.getAd().equalsIgnoreCase(isim)).forEach(System.out::println);


    }



    //başka yerde kullanmayacağıız için private yapalım
    private static void testOgrenciOlustur(){
        //ogrenci objesi oluturduk ve ekledik
        ogrListesi.add(new Ogrenci("Ahmet", "Can",30,88.4,"erkek"));
        ogrListesi.add(new Ogrenci("Ahmet", "Baki", 18, 90.1, "erkek"));
        ogrListesi.add(new Ogrenci("Ayşe", "Can", 21, 82.3, "kadın"));
        ogrListesi.add(new Ogrenci("Mustafa", "Can", 15, 75.4, "erkek"));
        ogrListesi.add(new Ogrenci("Ayşe", "Yılmaz", 40, 45, "kadın"));
        ogrListesi.add(new Ogrenci("Ali", "Veli", 80, 35.5, "erkek"));
        ogrListesi.add(new Ogrenci("Veli", "Öztürk", 20, 95.5, "erkek"));


    }

}
