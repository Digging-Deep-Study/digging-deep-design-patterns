package ch01.strategy.compressor;

public interface ImageCompressor {
    byte[] compress(byte[] imageData);
}
