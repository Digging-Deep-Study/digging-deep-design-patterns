package ch01.strategy.compressor;

public class PNGImageCompressor implements ImageCompressor {
    @Override
    public byte[] compress(byte[] imageData) {
        // PNG 압축 로직
        System.out.println("PNG Image Compressing...");
        return imageData;
    }
}