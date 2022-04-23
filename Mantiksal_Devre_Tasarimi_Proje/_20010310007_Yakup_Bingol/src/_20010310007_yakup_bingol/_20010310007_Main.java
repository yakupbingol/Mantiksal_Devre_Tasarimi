package _20010310007_yakup_bingol;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class _20010310007_Main {

    public static void main(String[] args) {
        dosyaOkuma();
    }

    public static void dosyaOkuma() {
        ArrayList<String> liste = new ArrayList<String>();
        try {
            File file = new File("dogruluk_tablosu.txt");
            Scanner read = new Scanner(file);
            while (read.hasNextLine()) {
                String data = read.nextLine();
                String data2 = data.replace(" ", "");
                String data3 = data2.replace("|", "");
                liste.add(data3);
            }
            read.close();
            _20010310007_Tablo tablo = new _20010310007_Tablo(liste);
        } catch (FileNotFoundException e) {
            System.out.println("Dosya okunurken hata olustu.");
            e.printStackTrace();
        }
    }

    public static void yazdir(ArrayList<String> liste) {
        for (int i = 0; i < liste.size(); i++) {
            System.out.println(liste.get(i));
        }
    }
}
