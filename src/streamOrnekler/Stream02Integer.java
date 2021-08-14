package streamOrnekler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Stream02Integer {
    public static void main(String[] args) {
        //bir listeyi parametre olarak alan ve listedeki her tek sayının karesini aralarında
        //bir boşluk bırakarak yazdıran methodu yazınız
       //map(): Matematik işlemi yapar javada---stream deki verileri verilen methoda göre değiştiren ara işlem methodudur

        //reduce : bir ilisteyi parametre olarak ala nlistedeki tek sayıların karelerinin toplamını hespalayan method yazınız

        List<Integer> liste = new ArrayList<>();
        liste.add(12);
        liste.add(9);
        liste.add(13);
        liste.add(4);
        liste.add(9);
        liste.add(2);
        liste.add(4);
        liste.add(12);
        liste.add(15);

        tekKareYazdır(liste);//81 169 81 225
        System.out.println("\ntoplam: "+teKupToplami(liste));//toplam: 7030
                                        //toplam: Optional[7030]

    }
    public static void tekKareYazdır(List<Integer> l){//mainden listeyi aldık adı l olsun
        l.stream().filter(Stream01Integer::tekMi).map(x->x*x).forEach(Stream01Integer::yazdır);//diğer class tanda alabiliriz çünkü o public
        // bir kere yazdık ve çağırıyoruz anywhere
        //map(ile karesini aldık
        //önceki classdan yazdırı çağırdık
        //maine çıkıp çağıralım
        //STREAM LİSTEDEKİ SAYILARI ALIR
        //FİLTER TEK OLANLARI ALIR
        //MAP KARELERİNİ HESAPLAR
        //FOReACH YAN YANA YAZDIRIR
        //map den önce distinc i kullanırsak tekrarlı sayıları kaldırı 81-->map transformasyonlarda kullanılır
        //map ten sonrada distinc i kullanabiliriz ama zaman kaybettirir hızı etkiler
        //stream den sonrada olur ama az faydalı olur

    }
    public static Integer teKupToplami(List<Integer> l){//bunu mainde yazdıralım onun için int yapım return yapmalıyız

       // return l.stream().filter(Stream01Integer::tekMi).map(x->x*x*x).reduce(0,(x,y)->(x+y));
                                                        //kup kısmını map yapar--//reduce toplama
                                                        //niye 0 dan başladık index olarak

       // return l.stream().filter(Stream01Integer::tekMi).map(x->x*x*x).reduce(Math::addExact);//optional ekldi method başına

        return l.stream().filter(Stream01Integer::tekMi).map(x->x*x*x).reduce(0,Integer::sum);//methodu ınteger a çevirdik
                                                                            //ÇARPIM OLSAYDI BURAYA 1 YAZARDIK
        //REDUCE
        // Verileri tek bir ture indirger,methodlarla ilgili islemleri gerceklestirip tek bir deger doner
        //reduce un icinde kendi terminal islemimizi yazabiliriz veya bir method referansi cagirabiliriz
    }


}
