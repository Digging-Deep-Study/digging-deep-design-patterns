package main.ch01.algorithm

class JpegAlgorithm : Algorithm {

    companion object {
        const val JPEG_HEADER = "JPEG"
    }

    override fun compress(content: String): String {
        return JPEG_HEADER + content.substring(
            0,
            if(content.length - 5 > 0)
                content.length - 5
            else
                content.length
        )
    }

}