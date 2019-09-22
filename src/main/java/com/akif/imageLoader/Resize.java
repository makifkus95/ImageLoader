package com.akif.imageLoader;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Resize {


    //orjinal resmin byte dizini ve küçültülmek istenen resim boyutlarını fonksiyona geldi.
    public byte[] imageResize(byte[] bs,int width, int height) throws IOException {
        // convert byte array back to BufferedImage
        InputStream in = new ByteArrayInputStream(bs);
        BufferedImage image = ImageIO.read(in);
        //orjinal resmin byte dizisini kullanarak orjinal resmin boyutlarını öğrendik
        int imageWidth = image.getWidth();
        int imageHeight = image.getHeight();
        //resim boyut oranı
        double ratio = (double) imageWidth / (double) imageHeight;
        //yeni resim boyut oranı
        double newRatio = (double) width / (double) height;

        if ( newRatio < ratio ) {
            height = (int) (width / ratio);
        } else {
            width = (int) (height * ratio);
        }
        System.out.println("Yeni boyutlar: "+width+"  "+height);

        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);//width height veri tipi int olmalı
        BufferedImage imageBuff = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        imageBuff.getGraphics().drawImage(scaledImage, 0, 0, new Color(0,0,0), null);

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();

        ImageIO.write(imageBuff, "png", buffer);

        return buffer.toByteArray();
    }

}
