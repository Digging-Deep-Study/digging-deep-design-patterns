package ch01.strategy.factory;

import ch01.strategy.compressor.*;

public class CompressorFactory {
    public static final ImageCompressor getCompressor(String format) {
        format = format.toUpperCase();

        switch (format) {
            case "JPG":
            case "JPEG":
                return new JPEGImageCompressor();
            case "PNG":
                return new PNGImageCompressor();
            case "GIF":
                return new GIFImageCompressor();
            default:
                throw new IllegalArgumentException("Unsupported format: " + format);
        }
    }
}
