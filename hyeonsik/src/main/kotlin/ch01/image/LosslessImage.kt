package main.ch01.image

import main.ch01.algorithm.PngAlgorithm

class LosslessImage(
    content: String,
) : Image(content, PngAlgorithm())
