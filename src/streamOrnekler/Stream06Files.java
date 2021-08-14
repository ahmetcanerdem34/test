package streamOrnekler;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Stream;

public class Stream06Files {
    private static URI path;

    //Files.lines()--> bu method ne yapıyor bu method içerisinde path.of ile dosya yolu belirtip javay açekebiliriz
    //

    public static void main(String[] args) throws IOException {
        Stream<String> satirlar = Files.lines(Path.of("src/streamOrnekler/mars..txt"));//mars string olduğu için String, ınt değil
        //burası bize dosyanın yolunu bulursa bize aktarıcak dosyayı
        //Baiına Stream String ekleyerek dosyayı streamledik


        satirlar.forEach(System.out::println);//yazdırdık ve gitti aldı geldi
/*
        Korkma, sönmez bu şafaklarda yüzen al sancak;
        Sönmeden yurdumun üstünde tüten en son ocak.
        O benim milletimin yıldızıdır, parlayacak;
        O benimdir, o benim milletimindir ancak.

                Çatma, kurban olayım çehreni ey nazlı hilâl!
                Kahraman ırkıma bir gül… ne bu şiddet bu celâl?
                Sana olmaz dökülen kanlarımız sonra helâl,
                Hakkıdır, Hakk'a tapan, milletimin istiklâl.
 */
        System.out.println("*****************************");

        //bu marş içindeki herşeyi buyuk harf olarak yazdırsın
        //yukarda forEach kullandığımız için burda tekrar kullanamayız stream i çünkü stream de akış tekk seferdir yeniden tanımlarız, of get aynı
    //parantez içerisine path yazsakta yeterli olur yyukarda değer isteyecekir
        Files.lines(Paths.get("src/streamOrnekler/mars..txt")).
                map(t-> t.toUpperCase()).
                forEach(System.out::println);
/*
KORKMA, SÖNMEZ BU ŞAFAKLARDA YÜZEN AL SANCAK;
SÖNMEDEN YURDUMUN ÜSTÜNDE TÜTEN EN SON OCAK.
O BENİM MİLLETİMİN YILDIZIDIR, PARLAYACAK;
O BENİMDİR, O BENİM MİLLETİMİNDİR ANCAK.

ÇATMA, KURBAN OLAYIM ÇEHRENİ EY NAZLI HİLÂL!
KAHRAMAN IRKIMA BİR GÜL… NE BU ŞİDDET BU CELÂL?
SANA OLMAZ DÖKÜLEN KANLARIMIZ SONRA HELÂL,
HAKKIDIR, HAKK'A TAPAN, MİLLETİMİN İSTİKLÂL.
 */

        //dosyadan sadee ilk satırı okuyarak buyuk harf olarak konsola yazdıralım

        //ilk satırı nasıl yazarız limit() öğrenmiştik içine sayı yazızorduk ilk o kısmı alıyordu 5 dersek ilk 5

        Files.lines(Paths.get("src/streamOrnekler/mars..txt")).limit(1).map(x-> x.toUpperCase()).
                                                                                            forEach(System.out::println);
    //files.lines path kısmında butun marş var ve line ile satrı satır bölündü
        // .limiti ile 1 . satırı alıyoruz. buyuk ahrfe çeviriyoruz ve onu yazdırıyoruz
        //limit(1) deyince yalnızca her satırı 1 eleman olarak duusnuyor ve 1. yi alıyor

        //3. ve 4. satırı almak istiyorsak

        Files.lines(Path.of("src/streamOrnekler/mars..txt")).map(String::toUpperCase).skip(2).limit(2).forEach(System.out::println);
        //skip ile ilk 2 satırı kaydırdı almadık yani, sonrada limit(2) diyerek skipten sonraki ilk 2 satır alınır

        Files.lines(Paths.get("src/streamOrnekler/mars..txt")).map(t-> t.toUpperCase()).limit(4).skip(2).forEach(System.out::println);//buda olur


        //bu kelimesi marş içesinde kaç adet geçiyor

        System.out.println(Files.lines(Paths.get("src/streamOrnekler/mars..txt")).map(t-> t.equalsIgnoreCase("o")).count());
                                    //sonrasında forEach yazmaam cunu count ta terminaldir arda arda kullanılmaz

    //map() ve flatMap(9 arasındaki fark nedir interwiev sorusu-- map stream ın transformasyonu yapan guncelleyendir
        //flapMap ise iç içe olan collections ları klasik bir liste haline getiriyor--destructor yapıyı bozuyor yani
        // Map : Stream'in transformasyon method'udur. Veriyi degistirir.
      // FlapMap : Nested olan Collection'lari dum duz bir hale getiriyor, islenmesi kolay olsun diye.

        //dosyadaki tuf farklı kelimleri altalta yazdıralım split""

        //marşı aldık   linlara böldik,  split ile boluşlara yani kelimelere böldük
        Files.lines(Path.of("src/streamOrnekler/mars..txt")).
                map(t->t.toLowerCase().split(" ")).//burda splitle kelimelee böldu arada space var
                flatMap(Arrays::stream).//kelimlerden olusan bir dum düz bir list oldu şimdi
                distinct().//aynı olanları attık
                forEach(System.out::println);

        //kelimeler içerisinde M veya m harfi olanları sayalım ve sonucu yazdıralım

       long mSayisi = Files.lines(Paths.get("src/streamOrnekler/mars..txt")).
               map(t->t.toLowerCase().split("")).
                flatMap(Arrays::stream).
                filter(t-> t.equals("m")).
                count();//long ile çalışır

        System.out.println("M harfinin sayısı :"+ mSayisi);//M harfinin sayısı :19

        //Boşluk ve noktalama işaretleri hariç dosyada kaç adet karakter kullanıldığını
// hesaplayarak sonucu konsola yazdıran uygulamayı yazınız
        // \\

        //  \\W "a-z" U "A-Z" U "0-9" U "_" hariç tüm karakterler demektir.
        System.out.println(Files.lines(Paths.get("src/streamOrnekler/mars..txt")).
                map(t->t.replace("_","").
                replaceAll("\\W","").split("")).
                flatMap(Arrays::stream).
                count());
        // bazı noktalama işaretlerini şu şekilde silebiliriz==> map(t->t.replaceAll("^[a-zA-Z]", ""): harflerin dışındakiler
        // ya da
        //map(t->t.replaceAll("\\W", "")     \\W :harf ve rakam dışındakiler
    }
}
