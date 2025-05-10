package com.practice.chapter;

public class StrategyPattern {
    private static final Compressible jpegCompressor = () -> System.out.println("Compressing .jpeg");
    private static final Compressible gifCompressor = () -> System.out.println("Compressing .gif");
    private static final Compressible pngCompressor = () -> System.out.println("Compressing .png");

    public static void main(String[] args) {
        Image image = new Image();

        image.setCompressor(jpegCompressor);
        image.compress();

        image.setCompressor(gifCompressor);
        image.compress();

        image.setCompressor(pngCompressor);
        image.compress();
    }

    static class Image {
        private Compressible compressor;

        public void setCompressor(Compressible compressor) {
            this.compressor = compressor;
        }

        public void compress() {
            if (compressor == null) {
                throw new IllegalStateException("Compressor not set");
            }
            compressor.compress();
        }
    }

    @FunctionalInterface
    interface Compressible {
        void compress();
    }
}
