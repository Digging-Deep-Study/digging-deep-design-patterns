package main.ch01.file

import main.ch01.image.*

object FileExtension {

    fun File.toImage(): Image {
        val mapper: Map<FilePurpose, (String) -> Image> = mapOf(
            FilePurpose.MAIN_BANNER to { content -> WebImage(content) },
            FilePurpose.CATEGORY_BANNER to { content -> WebImage(content) },
            FilePurpose.USER_PROFILE to { content -> WebImage(content) },
            FilePurpose.SELLER_PROFILE to { content -> WebImage(content) },
            FilePurpose.PRODUCT_THUMBNAIL to { content -> WebImage(content) },
            FilePurpose.PRODUCT_DETAIL to { content -> WebImage(content) },
            FilePurpose.LOADING_ANIMATION to { content -> AnimatedImage(content) },
            FilePurpose.PROMOTIONAL_ANIMATION to { content -> AnimatedImage(content) },
            FilePurpose.HIGH_QUALITY_IMAGE to { content -> LosslessImage(content) },
            FilePurpose.RAW_IMAGE to { content -> RawImage(content) },
        )

        return mapper[this.purpose]?.invoke(this.content)
            ?: throw IllegalArgumentException("Unsupported FilePurpose: ${this.purpose}")
    }

}