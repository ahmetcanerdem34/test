package fonksiyon;


import java.util.Arrays;
import java.util.List;

public class Lambda01Kurallar {
    public static void main(String[] args) {
        // Javada Lambda fonksiyonları sadece Fonksiyonel interface'ler ile kullanılabilir.
        // Sadece bir adet abstract metodu olan interface'lere fonksiyonel interface denilir.
        // Kullanıcı isterse kendi fonksiyonel interface'ini yazabilir. Ama Javada hali hazırda
        // Consumer, Function, Supplier, Predicate gibi tanımlanmış interfaceler bulunmaktadır.
        // Ayrıca bu interface'leri parametre olarak alabilen High Order Function (HOF)'lar da bulunmaktadır.
        // foreEach(), map(), filter(), reduce() gibi HOF'lar fonksiyonel interfaceler ile çalıştığı için
        // içerisinde Lambda fonksiyonları yazmak mümkündür.
        // Javada genelde bu gibi fonksiyonlar üzerinden Lambda ifadeleri kullanılmaktadır.
        //yeni not

        List<Integer> liste = Arrays.asList(1,2,3,4,5);
        //bu diziniz içindeki elemanaları yazdırmak istiyorum

        // forEach() bir collection'nın iterasyonu için kullanılan HOF'dur.
        // Parametre olarak bir lambda fonksiyonu alabilir.
        // Dizinin Elemanlarını yazdıralım
        liste.forEach(x-> System.out.println(x+" "));//baştaki list yazan collection-yanındaki foreach--kalan kısımda lamdda foksiyonu
                    //buradaki x i i gibi düşünebiliriz, x de olur w de olur ne istersek
      /*1
        2
        3
        4
        5
       */

        System.out.println("=======================");
        //listenin elemanlarını 2 artırarak yazdıralım
        liste.forEach(t-> System.out.print(t+2+" "));//her bir elemanı getir 2 rttrı
        //3 4 5 6 7

        System.out.println("\neğer satır sayısı (1)birden fazla ise {} süslü kulllanmalıyız");
        liste.forEach(t-> {
            int miktar =2;
            System.out.println(t + miktar + " ");
        });

        System.out.println("veri tipi kullanılırasa explicit(açık) implcicit (örtülü)");
        liste.forEach((Integer x) -> System.out.println(x*2));//her elemanı 2 ile çarp anlamında

        System.out.println("Bir dış değişken kullannalım");

        int deger = 5;
        liste.forEach(t -> System.out.println(t +deger));//her bir değeri 5 ile toplayacak



        liste.forEach(x -> System.out.println(x));//burası lambda fonksiyonu
        //bunun yerine method referaansı da kullanabiliriz
        //method referansı Class adı : : Method adı
        System.out.println("\nmetohd referans kullanımı");

        liste.forEach(Lambda01Kurallar :: yazdır);//1 2 3 4 5 ---classs adı(LamdaKurllar-- yanındada method adı method adı
                    //class adı  //2nokta  //method adı
    }
    public static void yazdır(int x){
        System.out.print(x+" ");
    }
}
