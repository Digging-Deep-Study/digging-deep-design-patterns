package main.ch01.algorithm

class PngAlgorithm : Algorithm {

    companion object {
        const val PNG_HEADER = "PNG"
    }

    override fun compress(content: String): String {
        return PNG_HEADER + content + PNG_HEADER
    }

}