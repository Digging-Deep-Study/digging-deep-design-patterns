package main.ch01.image

import main.ch01.algorithm.GifAlgorithm

class AnimatedImage(
    content: String,
) : Image(content, GifAlgorithm())