package streamOrnekler;

import java.util.List;
import java.util.stream.*;

public class Stream05Digerleri {

    public static void main(String[] args) {
/*
          Collection'larimizi stream method;u ile Stream'e cevirmeyi ogrendik.
          Collection : List,Map,HashMap vb..
          Stream'e cevirdikten sonra Stream API kullanarak pipeLine'a sokuyorduk.
          IntStream : Integer seklinde Stream olusturabiliriz.
          LongStream, DoubleStream
          Bunlarin ne artisi var ? Sayisal degerlerle islem yapacaksak isleri kolaylastiriyor.
          Biz istersek Integer, Double, Long tipinde Stream'ler olusturabiliyoruz.
         */
        System.out.println("TOPLAM :"+ topla(4));
        topla1(4);//1234
        System.out.println("*********************");
        tekTopla(1,7);//1 ile 7 arasındaki değerleri topla
        System.out.println("**************");
        System.out.println("Faktoriyel :" +faktoriyel(5));//20 ciarı versek ınt in değerini aşar Long yapmalıyız
        //Faktoriyel :120
        System.out.println("******************");
        System.out.println("Faktoriyel1 :" +faktoriyel1(20));
        //Faktoriyel :2432902008176640000
        System.out.println("*************************");
        System.out.println("Faktoriyel2 :" +faktoriyel2(20));
        //Faktoriyel :2.43290200817664E18
        System.out.println("**********************");
        System.out.println("notları 50 den buyuk olanlar :"+doubleDiziCevirList());//parametresiz
        //notları 50 den buyuk olanlar :[88.5, 52.3, 88.9, 100.0, 99.6]
    }
// ÖRNEK25: 1'den belirtilen değere kadar olan tamsayıları toplayan ve sonucu döndüren metodu yazınız
    //for dongusuyle yapılır ama biz fonksiyonel programa ile yapacağız
    public static int topla(int deger){
        //range aralık demek
        //sadece range dersek verdiğimiz aralık, son dahil değil
        //rangeClosed dersek son sayıda alınır
        return IntStream.range(1, deger + 1).sum();//1 den basla istediğimiz değere kadar git topla, 4 e kadar ama 4 dahil edeğil
    }
    public static void topla1(int deger){
         IntStream.rangeClosed(1,deger).forEach(System.out::print);
    }
    public static void tekTopla(int alt,int ust){
        System.out.println(IntStream.rangeClosed(alt,ust).filter(Methodlar::tekMi).sum());
    }
    //belirtilen sayınınn faktoriyelini hesaplayan functional programıng ile yazınız
    //5 girildiyese eğer rangeCloese kullanmak mantıklı sayıya kadar dahil alacak
    //reduce kullanmalıyız, ardışık işlemler için kullanılan bir terminaldir
    public static int faktoriyel(int n){//int yerine long yazamayız çünkü bu sitemde primitive data lar kullanılmıyor,Long oilman
        return IntStream.rangeClosed(1,n).reduce(1,(x,y)->x*y);
       // return IntStream.iterate(1,t->t+1).limit(n).reduce(1,(x,y)->x*y);-->aşağıdaki iteratoru burdada  yani int tede kullanaabiliyoruz
    }
    public static Long faktoriyel1(int n){//Long (long) da olur bu sırada, yukarıdaki de int yerine Integer
        return LongStream.rangeClosed(1,n).reduce(1,(x, y)->x*y);

    }
    public static double faktoriyel2(int n){//doublestreamde . range kullanımı yok;
                                                         // çünkü bir virgüllü sayılarda aralıkta sonsuz sayı olabilir
                                                        //range yerine iterate yontemi kullanılır, sonunada limit() yazıyoruzson sayı
        return DoubleStream.iterate(1, t->t+1).limit(n).reduce(1,(x,y)->x*y);

    }
    // ÖRNEK28: Bir double diziyi (notlar) Stream nesnesine dönüştürerek bu dizi içerisinde bulunan
// sayıların 50 den büyük olanlarını ayrı bir listeye kaydererek yazdıran metodu tanımlayınız
    public static List<Double> doubleDiziCevirList(){
        Double[] notlar={88.5,52.3,88.9,100.0,99.6,40.6,34.7,27.6,};//elimizdeki HAZIR DİZİ VARSA,dizi bu stream a çevireceğiz
                                                                //stream.of kullanıyoruz
        //Integer x dizimiz olsa  Stream<Integer> y = Stream.of(x)
        //50 den buyuk olanları filtrele ve collect et sakla ve listele --->toList
        Stream<Double> streamNotlar = Stream.of(notlar);
        return streamNotlar.filter(t->t>50.0).collect(Collectors.toList());//filter.skip(3) dersek ilk 3 ten sonrasını listele anlamı vardır

    }
}
