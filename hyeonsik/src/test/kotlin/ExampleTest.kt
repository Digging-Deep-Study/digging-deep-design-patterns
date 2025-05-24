import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ExampleTest : StringSpec({

    "1 + 1은 2여야 한다" {
        (1 + 1) shouldBe 2
    }

})
