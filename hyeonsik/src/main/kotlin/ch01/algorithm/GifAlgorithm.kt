package main.ch01.algorithm

class GifAlgorithm : Algorithm {

    companion object {
        const val GIF_HEADER = "GIF"
    }

    override fun compress(content: String): String {
        return GIF_HEADER +
                content + "1_" +
                content + "2_" +
                content + "3_" +
                GIF_HEADER
    }

}