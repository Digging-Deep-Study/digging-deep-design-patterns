package ch01

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import main.ch01.Uploader
import main.ch01.file.File
import main.ch01.file.FilePurpose
import main.ch01.image.WebImage

class UploaderTest : StringSpec({

    "실행해보기!" {
        // given
        val file = File(FilePurpose.MAIN_BANNER, "Banner Content")
        val uploader = Uploader()

        uploader.upload(file)
    }

})
