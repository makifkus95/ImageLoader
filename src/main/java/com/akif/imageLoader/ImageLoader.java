package com.akif.imageLoader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;

import static com.akif.imageLoader.App.sc;

public class ImageLoader {

    public static void loader(String link, String isim) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream("E:\\img\\orginal\\"+isim); //bir dosya konumu belirlendi

        BufferedImage bufImage = ImageIO.read(new URL(link));//bufferedImage ile link'ten gelen fotoğrafı bufImage değişkenine attık
        ByteArrayOutputStream baos = new ByteArrayOutputStream(); // baos adında byte dizisi oluşturduk
        ImageIO.write( bufImage, "png", baos );//bufImage değişkeninde olan resimin byte verilerini baos'a yazdırdık

        byte[] imageInByte = baos.toByteArray(); //bytestreamlerini elde ettik
        fileOutputStream.write(imageInByte);//baos resminin byte verisini dosyaya yazdırdık

        float width = bufImage.getWidth();
        float height = bufImage.getHeight();
        System.out.println("Resim orjinal boyutları: "+width+ "  " + height);

        if (width > 300 || height > 300) {
            //byte[] newimageInByte = new Resize().imageResize(imageInByte,300,300);
            byte[] out = null;
            System.out.print("new name: ");
            String name = sc.nextLine();

            try(FileOutputStream fileOutputStream2 = new FileOutputStream("E:\\img\\resize\\"+name)){
                out = new Resize().imageResize(imageInByte, 300,300);
                fileOutputStream2.write(out);
            }
        }
    }
    public static double imageSize(String isim){
        File file = new File("E:\\img\\"+isim);

        double bytes = file.length();
        double kilobytes = (bytes / 1024);
        double megabytes = (kilobytes / 1024);

        return megabytes;
    }

}
