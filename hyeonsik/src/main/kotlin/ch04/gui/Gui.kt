package main.ch04.gui

interface Button {
    fun paint()
    val type: String
}

interface Checkbox {
    fun paint()
    val type: String
}

interface Menu {
    fun show()
    val type: String
}


// 추상 팩토리 (Abstract Factory)
interface GUIFactory {
    fun createButton(): Button
    fun createCheckbox(): Checkbox
    fun createMenu(): Menu
}

// 팩토리 구현
class WindowsFactory : GUIFactory {
    override fun createButton(): Button = WindowsButton()
    override fun createCheckbox(): Checkbox = WindowsCheckbox()
    override fun createMenu(): Menu = WindowsMenu()
}

class MacFactory : GUIFactory {
    override fun createButton(): Button = MacButton()
    override fun createCheckbox(): Checkbox = MacCheckbox()
    override fun createMenu(): Menu = MacMenu()
}

class LinuxFactory : GUIFactory {
    override fun createButton(): Button = LinuxButton()
    override fun createCheckbox(): Checkbox = LinuxCheckbox()
    override fun createMenu(): Menu = LinuxMenu()
}


// Windows
class WindowsButton : Button {
    override val type = "Windows 버튼"
    override fun paint() = println("$type: 그려집니다.")
}

class WindowsCheckbox : Checkbox {
    override val type = "Windows 체크박스"
    override fun paint() = println("$type: 그려집니다.")
}

class WindowsMenu : Menu {
    override val type = "Windows 메뉴"
    override fun show() = println("$type: 보여집니다.")
}

// macOS
class MacButton : Button {
    override val type = "macOS 버튼"
    override fun paint() = println("$type: 고급지게 그려집니다.")
}

class MacCheckbox : Checkbox {
    override val type = "macOS 체크박스"
    override fun paint() = println("$type: 감성적으로로 그려집니다.")
}

class MacMenu : Menu {
    override val type = "macOS 메뉴"
    override fun show() = println("$type: 비싸보이게 보여집니다.")
}

// Linux
class LinuxButton : Button {
    override val type = "Linux 버튼"
    override fun paint() = println("$type: CUI로 그려집니다.")
}

class LinuxCheckbox : Checkbox {
    override val type = "Linux 체크박스"
    override fun paint() = println("$type: CUI로 그려집니다.")
}

class LinuxMenu : Menu {
    override val type = "Linux 메뉴"
    override fun show() = println("$type: CUI로 보여집니다.")
}


// Application
// 직접적으로 구현체(예를들어 macOs같은)에 의존성 X
class Application(private val factory: GUIFactory) {
    private lateinit var button: Button
    private lateinit var checkbox: Checkbox
    private lateinit var menu: Menu

    fun createUI() {
        button = factory.createButton()
        checkbox = factory.createCheckbox()
        menu = factory.createMenu()
        println("--- ${factory::class.simpleName?.replace("Factory","")} UI 생성 완료 ---")
    }

    fun paintUI() {
        button.paint()
        checkbox.paint()
        menu.show()
    }
}


///////////////////////////////////////////////////////////////////////////////
//
// main
//
///////////////////////////////////////////////////////////////////////////////
fun main() {
    val osName = "win"
    println("현재 운영체제: $osName")

    val factory: GUIFactory = when {
        osName.contains("win") -> WindowsFactory()
        osName.contains("mac") -> MacFactory()
        osName.contains("lin") -> LinuxFactory()
        else -> {
            println("알 수 없는 운영체제입니다.")
            WindowsFactory()
        }
    }

    val app = Application(factory)
    app.createUI()
    app.paintUI()



    println("\n--- 다른 OS UI 강제 생성 테스트 ---")
    val macApp = Application(MacFactory())
    macApp.createUI()
    macApp.paintUI()

    val linuxApp = Application(LinuxFactory())
    linuxApp.createUI()
    linuxApp.paintUI()
}
