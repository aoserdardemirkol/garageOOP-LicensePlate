package com.garageOOPLicensePlate;

import java.util.Scanner;
import static java.lang.Integer.parseInt;

public class Main {
    public static int garajBoyut;
    public static int aracTipi;
    public static String plaka;

    public static void main(String[] args) {
        acilisyazilariniYaz();

        Scanner klavye = new Scanner(System.in);

        while (true) {
            System.out.print("---------- Garaj Boyutunu Giriniz: ");
            garajBoyut = klavye.nextInt();

            if (garajBoyut >= 5 && garajBoyut <= 50)
                break;
            else
                System.out.println("---------- Garaj Boyutu 5 ile 50 arasında olmalıdır...");
        }

        Garaj grj = new Garaj(garajBoyut);

        while (true) {
            System.out.print("---------- Araç Girişi için 'G' Araç Çıkışı için 'C' Araçları Listelemek için 'L' Kapatmak için 'K': ");

            String islem = klavye.next();

            String[] ayir = islem.split("-");
            String islemTipi = ayir[0].toUpperCase();

            if (ayir.length > 1) {
                aracTipi = parseInt(ayir[1]);
                plaka = ayir[2].toUpperCase();
            }

            if (islemTipi.equals("G")) {
                String islemDonus = Islem.islemSec(new Giris(), islemTipi, grj, aracTipi, plaka);
                System.out.println(islemDonus);
            }
            else if (islemTipi.equals("C")){
                String islemDonus = Islem.islemSec(new Cikis(), islemTipi, grj, aracTipi, plaka);
                System.out.println(islemDonus);
            }
            else if (islemTipi.equals("L")){
                String islemDonus = Islem.islemSec(new Liste(), islemTipi, grj, aracTipi, plaka);
                System.out.println(islemDonus);
            }
            else if (islemTipi.equals("K"))
                break;
        }
    }

    static void acilisyazilariniYaz() {
        System.out.println("-------------------- Garaj Console App --------------------");
        System.out.println("---------------------- Giriş Tipleri ----------------------");
        System.out.println("---------- Tip 1: 'Bisiklet'    Kapladığı Alan: '1' -------");
        System.out.println("---------- Tip 2: 'Motorsiklet' Kapladığı Alan: '1' -------");
        System.out.println("---------- Tip 3: 'Araba'       Kapladığı Alan: '2' -------");
        System.out.println("---------- Tip 4: 'Kamyonet'    Kapladığı Alan: '3' -------");
        System.out.println("---------- Tip 5: 'Otobüs'      Kapladığı Alan: '5' -------");
        System.out.println("---------- Tip 6: 'Tır'         Kapladığı Alan: '8' -------");
        System.out.println("-----------------------------------------------------------");
        System.out.println("---------- Örnek Giriş: 'g-3-43UK622' || 'G-3-43UK622' ----");
        System.out.println("-----------------------------------------------------------");
    }
}