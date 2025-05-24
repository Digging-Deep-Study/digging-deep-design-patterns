package main.ch01.image

import main.ch01.algorithm.NoAlgorithm

class RawImage(
    content: String,
) : Image(content, NoAlgorithm())
