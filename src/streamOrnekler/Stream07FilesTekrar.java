package streamOrnekler;

import javax.swing.tree.TreePath;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Stream;

public class Stream07FilesTekrar {



    public static void main(String[] args) throws IOException {

        Stream<String> satirlar = Files.lines(Path.of("src/streamOrnekler/mars..txt"));


        satirlar.forEach(System.out::println);//mars şiirinin tum satırlarını yazdır anlamında
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

        System.out.println("*******************************");

        //marşın tamamını buyuk harf ile yazdıralım,

        Files.lines(Path.of("src/streamOrnekler/mars..txt")).map(t->t.toUpperCase()).forEach(System.out::println);


        //marşş  dosyasının adece ilk satırını alıp buyuk olarak konsola yazdıralım

        Files.lines(Path.of("src/streamOrnekler/mars..txt")).limit(1).map(x->x.toUpperCase()).forEach(System.out::println);

        //3. ve 4. satırı alıp yuazdıralım

        Files.lines(Path.of("src/streamOrnekler/mars..txt")).map(String::toUpperCase).skip(2).limit(2).forEach(System.out::println);

        //bu kelimesi marşta kaç defa geçiyor

        Files.lines(Path.of("src/streamOrnekler/mars..txt")).map(x-> x.equalsIgnoreCase("bu")).count();

        //dosyadaki tum farklı keşlimeleri yazdıralım alt alta

        Files.lines(Path.of("src/streamOrnekler/mars..txt")).map(x->x.toLowerCase().split("")).
                flatMap(Arrays::stream).
                distinct().
                forEach(System.out::println);

        // içerisinde m  ve M harfleri olan kelimeler i yazdıralım

        long mSayisi=Files.lines(Path.of("src/streamOrnekler/mars..txt")).
                map(x->x.toLowerCase().split("")).//burda splitle kelimelee böldu arada hiçlik var
                flatMap(Arrays::stream).
                filter(t-> t.equals("m")).count();

        System.out.println(mSayisi);

        //Boşluk ve noktalama işaretleri hariç dosyada kaç adet karakter kullanıldığını
// hesaplayarak sonucu konsola yazdıran uygulamayı yazınız




    }
}
