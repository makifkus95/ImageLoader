package com.akif.imageLoader;

import java.io.IOException;
import java.util.Scanner;

public class App
{

    public static Scanner sc = new Scanner(System.in);
    public static void main( String[] args ) throws IOException {

        String[] array = {"https://up.picr.de/30443424jo.png",
                "https://www.animod.de/magazin/wp-content/uploads/2019/02/Amsterdam-H%C3%A4user-und-Basilika-St-Nikolaus.jpg",
        "https://img-fotki.yandex.ru/get/9061/125352602.265/0_e6322_52d06b41_XL.jpg",
        "https://cdn.chip.gen.tr/images/content/20101009161302/resim-formatlari-ve-gercekler.jpg"};

        String fileName;
        for (String array1 : array) {

            System.out.print("orginal name: ");
            fileName = sc.nextLine();
            ImageLoader.loader(array1, fileName);
        }
    }
}

/*
* FileOutputStream fos = new FileOutputStream ...........dosyaya veri yazma(true)
*
* dosyaya bir string yazdırmak istersek byte arraya dönüştürmek zorundayız
* byte[] byte = string.getBytes();
* fos.write(byte)
*
*
* fileInputStream fis = new fileInputStream(); dosyadan veri okumak
*string ifadeyi okurken fis.read() -> byte şeklinde okuyoruz char tipine dönüştürmemiz lazım.
* her seferinde 1 byte okunur yani bir karakter okunur
*
* while(int deger = fis.read() != -1){
*   string += (char) deger;
*
* */