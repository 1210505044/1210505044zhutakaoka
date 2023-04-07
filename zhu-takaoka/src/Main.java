
import java.lang.*;

public class Main {


    public static String alfabe = "ABCABCEEABCDEABCD";
    public static String model = "ABCD";


    //MODELİN KARAKTER SAYISINI BELİRTTİM.
    //ARADIĞIMIZ YERDEKİ KARAKTER SAYISINI BELİRTTİM.
    public static int alfabesayi = 17;
    public static int modelsayi = 4;

    // YABANCI ALFABEYE GÖRE YAPTIĞIM İÇİN 26 KARAKTER BOYUTUNDA BİR 26*26 MATRİSİ OLUŞTURDUM
    public static int[][] ZTBC = new int[26][26];

    // hesaplamanın yapıldığı bir fonksiyon yapıldı.
    public static void ZTBCCalculation()
    {

        int i, j;


        /*Fonksiyonun burada yaptığı hesaplamaya özet geçersek ardışık olan iki elemanı karşılaştırıp ABCD modelini oluşturmaya çalışıyor.
        Modelin ilk elemanı 'A' olduğu için A ile başlayan indeksleri bularak oralarda sıralama yapıyor.
        */

        for (i = 0; i < 26; ++i)
            for (j = 0; j < 26; ++j)
                ZTBC[i][j] = modelsayi;

        for (i = 0; i < 26; ++i)
            ZTBC[i][model.charAt(0) - 'A']
                    = modelsayi - 1;
        for (i = 1; i < modelsayi - 1; ++i)
            ZTBC[model.charAt(i - 1) - 'A']
                    [model.charAt(i) - 'A']
                    = modelsayi - 1 - i;
    }


    public static void main(String args[])
    {

        int i, j;

        // Fonksiyonu çağırdık.
        ZTBCCalculation();


        j = 0;

        while (j <= alfabesayi - modelsayi) {

            i = modelsayi - 1;
            while (i >= 0
                    && model.charAt(i)
                    == alfabe.charAt(i + j))
                --i;
            if (i < 0) {

                // Sonuç bize modelde gösterilem ABCD sıralamasına uyan karakterlerin index numarasını ekrana yazdırdı.
                System.out.println("MODEL BULUNDU:" + (j + 1)) ;
                j += modelsayi;
            }

            else
                j += ZTBC[alfabe.charAt(j + modelsayi - 2)
                        - 'A']
                        [alfabe.charAt(j + modelsayi - 1)
                        - 'A'];
        }
        System.out.println("Sonuç bize modelde gösterilem ABCD sıralamasına uyan karakterlerin index numarasını ekrana yazdırdı.");
    }
}