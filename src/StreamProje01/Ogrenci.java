package StreamProje01;

//bu öğrenci clasında objeler oluşruracağız ve lambda yöntemiyle sıralayacağız
public class Ogrenci {//ogrenci class ımız oluşturduk, bu öğrencilerin ismi, soyismi, yas diplomanot, cinsiyet

    private String ad;
    private String soyAd;
    private int yas;
    private double diplomaNotu;
    private String cinsiyet;
    //parametreli constroctır oluşturalım
    // Constructor icin sag tikla -> Generate -> Constructor -> Hepsini sec ok'a bas
    public Ogrenci(String ad, String soyAd, int yas, double diplomaNotu, String cinsiyet) {
        this.ad = ad;
        this.soyAd = soyAd;
        this.yas = yas;
        this.diplomaNotu = diplomaNotu;
        this.cinsiyet = cinsiyet;
    }
    //get ve set leri oluştur
    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyAd() {
        return soyAd;
    }

    public void setSoyAd(String soyAd) {
        this.soyAd = soyAd;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public double getDiplomaNotu() {
        return diplomaNotu;
    }

    public void setDiplomaNotu(double diplomaNotu) {
        this.diplomaNotu = diplomaNotu;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }
    //bir nesne içerisinde tum verileri yazdırmak için toString kullanılır
    //almak istemediklerinizi tıklamaya bilirsiniz
    //

    @Override
    public String toString() {
        return
                "ad='" + ad + '\'' +
                ", soyAd='" + soyAd + '\'' +
                ", yas=" + yas +
                ", diplomaNotu=" + diplomaNotu +
                ", cinsiyet='" + cinsiyet + '\'';
    }
}
