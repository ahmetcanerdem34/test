package streamOrnekler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Stream03Integer {

    public static void main(String[] args) {
        List<Integer> liste = new ArrayList<>();
        liste.add(12);
        liste.add(9);
        liste.add(13);
        liste.add(4);
        liste.add(9);
        liste.add(2);
        liste.add(-2);
        liste.add(4);
        liste.add(-1);
        liste.add(15);
        liste.add(500);

        System.out.println("EN BUYUK DEĞER :" + buyukBul(liste));//EN BUYUK DEĞER :500
        System.out.println("EN BÜYÜK DEĞER " + buyukBul1(liste));//EN BÜYÜK DEĞER 500
        System.out.println("EN KÜÇÜK DEĞER " + kucukBul(liste));//EN KÜÇÜK DEĞER -4
        System.out.println("ÇARPIM DEĞER " + carpimBul(liste));//ÇARPIM DEĞER -2031941632
        System.out.println("DOKUZ SAY " + dokuzSay(liste));//DOKUZ SAY 2
        System.out.println("NEGETİF SAYILAR " + negatifSayiListesi(liste));//NEGETİF SAYILAR [-4]

        //forEachle yapalım
        negatifSayilariYazdır(liste);

        List<Integer> negatifler = negatifSayiListesi(liste);
        System.out.println("\nnegatif liste:" + negatifler);
        System.out.println("TEK SAYILARIN KARESİ SIRALI" + tekKareSiraliListele(liste));//TEK SAYILARIN KARESİ SIRALI[1, 81, 169, 225]
    }

    public static int buyukBul(List<Integer> liste){
        return liste.stream().reduce(0, (x, y) -> x > y ? x : y);
    }

    public static int buyukBul1(List<Integer> liste) {

        return liste.stream().reduce(0, Math::max);
    }

    public static int butyukBul2(List<Integer> liste) {

        return liste.stream().sorted().reduce(0, (x, y) -> y);//sorted sıralıyordu, x ve ye yi karşılaştırı buyuk olan
        // en sonda olduğu için y yi verir

    }

    public static int kucukBul(List<Integer> liste) {

        return liste.stream().reduce(0, (x, y) -> x < y ? x : y);//hangisi küçükse onu al karşılaştırı, küktür işareti onemli
    }

    public static int carpimBul(List<Integer> liste) {//çarpım bulalım, 1 den başlamalı

        return liste.stream().reduce(1, (x, y) -> x * y);
    }

    //liste içerisinde kaç tane 9 sayısı bulunmaktadır
    //bunu bulan bir method yazalım
    public static int dokuzSay(List<Integer> liste) {//reduce ile count aynı 1 ini kullanmalısın
    return (int) liste.stream().filter(x->x==9).count();//2
                //stream de 10 eleman var//filter 2 ye düşürüyor

    }
    //bir listedeki negatif dsayıları ayrı bir liste olarak döndürene methodu yazalım
    //ayrı bir liste oluşturmuş olduk çünkü void değil liste döndüreceğiz ve veri tipi int olmalı List<Integer>
    public static List<Integer> negatifSayiListesi(List<Integer> liste){
        return liste.stream().filter(x -> x<0).collect(Collectors.toList());
     // collect() :Stream in sonucunu bir listeye saklar,Collector interface leri yardimiyla gerceklestirilir.

    }
   //listedeki negatif sayıları yazdıran methodu yazalım
        public static void negatifSayilariYazdır(List<Integer> liste){
            liste.stream().filter(x-> x<0).forEach(System.out::print);

    }
    //Listedeki tek elemanların karelerini sıralı ve tekrarsız bir şekilde listeye kaydeden methodu yazdırınız
    public static List<Integer> tekKareSiraliListele(List<Integer>liste){
        return liste.
                stream().
                distinct().
                filter(Methodlar::tekMi).
                map(x->x*x).
                map(x->(int)Math.pow(x,2)).//mat pow double çalışıyor üst alır ve biz int e çevirdik işleme uysun diye, karesini aldık
                //5 inci kuvveti istese 2 yerine 5, 3  yani kü pünü isterse 3 filan...3,8 yazarsam 3 üzeri 8 i alır
                distinct().
                sorted().//sorted(Comparator.reverseOrder()).//burdada tersinden sıralar
                collect(Collectors.toList());
        //distinct sayıları tekrarsız hale getriri nereye koyacağınızı  siz belrleybilirsiniz
    }


}
