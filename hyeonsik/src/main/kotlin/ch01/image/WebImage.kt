package main.ch01.image

import main.ch01.algorithm.JpegAlgorithm

class WebImage(
    content: String,
) : Image(content, JpegAlgorithm())
