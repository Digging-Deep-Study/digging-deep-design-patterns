package ch01.strategy;

import java.io.*;
import java.nio.file.Files;

import ch01.strategy.compressor.*;

import static ch01.strategy.factory.CompressorFactory.getCompressor;

public class Main {
    public static void main(String[] args) throws IOException {
        // get image file from args
        File imageFile = new File(args[0]);
        byte[] imageData = Files.readAllBytes(imageFile.toPath());

        // get file format from image
        String format = imageFile.getName().substring(imageFile.getName().lastIndexOf(".") + 1);
        ImageCompressor compressor = getCompressor(format);
        byte[] compressedImageData = compressor.compress(imageData);

        // save compressed image to ./images/
        String imgLocation = imageFile.getPath().substring(0, imageFile.getPath().lastIndexOf("/"));
        FileOutputStream fos = new FileOutputStream(imgLocation + "/compressed_image." + format);
        fos.write(compressedImageData);

        fos.close();
    }
}