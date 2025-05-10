package ch01.strategy.compressor;

public class JPEGImageCompressor implements ImageCompressor {
    @Override
    public byte[] compress(byte[] imageData) {
        // JPEG 압축 로직  
        System.out.println("JPG Image Compressing...");
        
        return imageData;
    }
}
