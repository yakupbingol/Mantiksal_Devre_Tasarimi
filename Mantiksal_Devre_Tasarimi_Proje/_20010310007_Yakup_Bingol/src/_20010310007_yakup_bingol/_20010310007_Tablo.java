package _20010310007_yakup_bingol;

import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;

public class _20010310007_Tablo {

    private ArrayList<String> liste = null;
    private int fonkSayisi = 0;
    private int degiskenSayisi = 0;

    public _20010310007_Tablo(ArrayList<String> liste) {
        this.liste = liste;
        this.fonkSayisi = fonkSayAl(liste);
        this.degiskenSayisi = degiskenSayAl(liste);
        diziOlustur(liste, fonkSayisi, degiskenSayisi);
    }

    public static void diziOlustur(ArrayList<String> liste, int fonkSayisi, int degiskenSayisi) {

        String[][] dizi = new String[liste.size()][liste.get(0).length()];
        System.out.println("dogruluk_tablosu.txt dosyasi okundu.\n");
        for (int i = 0; i < liste.size(); i++) {
            for (int j = 0; j < liste.get(0).length(); j++) {
                dizi[i][j] = liste.get(i).substring(j, j + 1);
            }
        }

        minTermYazdir(dizi, fonkSayisi, degiskenSayisi);
        maxTermYazdir(dizi, fonkSayisi, degiskenSayisi);
        kullanýcýDeger(dizi, fonkSayisi, degiskenSayisi);

    }

    public static void minTermYazdir(String[][] dizi, int fonkSayisi, int degiskenSayisi) {
        for (int i = 0; i < fonkSayisi; i++) {
            System.out.print(dizi[0][degiskenSayisi + i] + "=€(");
            for (int j = 1; j < dizi.length; j++) {
                if (dizi[j][degiskenSayisi + i].equals("1")) {
                    System.out.print((j - 1) + ",");
                }
            }

            System.out.print(") = ");

            for (int j = 1; j < dizi.length; j++) {
                if (dizi[j][degiskenSayisi + i].equals("1")) {
                    System.out.print(("m" + (j - 1) + " +"));
                }
            }
            System.out.print("=");

            for (int j = 1; j < dizi.length; j++) {
                if (dizi[j][i + degiskenSayisi].equals("1")) {
                    System.out.print("+ ");
                    for (int k = 0; k < degiskenSayisi; k++) {
                        if (dizi[j][k].equals("0")) {
                            System.out.print(dizi[0][k] + "'");
                        } else {
                            System.out.print(dizi[0][k]);
                        }
                    }

                }

            }
            System.out.println();
        }

    }

    public static void maxTermYazdir(String[][] dizi, int fonkSayisi, int degiskenSayisi) {

        for (int i = 0; i < fonkSayisi; i++) {
            System.out.print(dizi[0][degiskenSayisi + i] + "=U(");
            for (int j = 1; j < dizi.length; j++) {

                if (dizi[j][degiskenSayisi + i].equals("0")) {
                    if (j > 1) {
                        System.out.print(",");
                    }
                    System.out.print((j - 1));
                }
            }

            System.out.print(") = ");

            for (int j = 1; j < dizi.length; j++) {

                if (dizi[j][degiskenSayisi + i].equals("0")) {
                    if (j > 1) {
                        System.out.print(".");
                    }
                    System.out.print(("M" + (j - 1)));
                }
            }
            System.out.print("=");

            for (int j = 1; j < dizi.length; j++) {
                if (dizi[j][i + degiskenSayisi].equals("0")) {
                    if (j > 1) {
                        System.out.print(".");
                    }
                    System.out.print("(");
                    for (int k = 0; k < degiskenSayisi; k++) {
                        if (k > 0) {
                            System.out.print("+");
                        }
                        if (dizi[j][k].equals("1")) {
                            System.out.print(dizi[0][k] + "'");
                        } else {
                            System.out.print(dizi[0][k]);
                        }

                    }
                    System.out.print(")");

                }

            }
            System.out.println();
        }

    }

    public static void kullanýcýDeger(String[][] dizi, int fonkSayisi, int degiskenSayisi) {

        for (int i = 0; i < fonkSayisi; i++) {
            String term = "";

            for (int j = 0; j < degiskenSayisi; j++) {

                System.out.println("Lütfen " + dizi[0][degiskenSayisi + i]
                        + " fonksiyonu için " + dizi[0][j] + " degiskeninin degerini giriniz:");
                Scanner input = new Scanner(System.in);
                String deger = input.next();
                term = term.concat(deger);
            }
            System.out.println("Girilen degerlere gore " + dizi[0][degiskenSayisi + i] + " fonksiyonunun cikisi "
                    + dizi[ikilik(term) + 1][degiskenSayisi + i] + " dir.");
            System.out.println();
        }

    }

    static int ikilik(String term) {

        return Integer.parseInt(term, 2);
    }

    public static void print(String[][] dizi) {
        for (int i = 0; i < dizi.length; i++) {
            for (int j = 0; j < dizi[0].length; j++) {
                System.out.print(dizi[i][j]);
            }
            System.out.println();
        }
    }

    public static int degiskenSayAl(ArrayList<String> liste) {
        return (int) (Math.log(liste.size() - 1) / Math.log(2));
    }

    public static int fonkSayAl(ArrayList<String> liste) {
        return liste.get(0).length() - degiskenSayAl(liste);
    }

}
