package ch01.strategy.compressor;

public class GIFImageCompressor implements ImageCompressor {
    @Override
    public byte[] compress(byte[] imageData) {
        // GIF 압축 로직
        System.out.println("GIF Image Compressing...");
        return imageData;
    }
}
