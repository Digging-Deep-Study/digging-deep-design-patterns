package main.chapter5.scenario2

fun main() {
    val button = Button("Click Me")
    val textField = TextField("Enter text here")
    val panel = Panel("My Panel")

    panel.addComponent(button)
    panel.addComponent(textField)

    println(panel.render())
    println(panel.print())
}

interface Component {
    fun render(): String
    fun print(): String
}

interface UI {
    fun addComponent(component: UIComponent)
    fun removeComponent(component: UIComponent)
    fun render(): String
    fun print(): String
}

abstract class UIComponent : Component, UI {
    abstract override fun render(): String
}

class Button(private val label: String) : UIComponent() {
    override fun addComponent(component: UIComponent) {
        throw UnsupportedOperationException("component를 Button에 추가할 수 없습니다")
    }

    override fun removeComponent(component: UIComponent) {
        throw UnsupportedOperationException("component를 Button에서 제거할 수 없습니다")
    }

    override fun render(): String = "<button>$label</button>"
    override fun print(): String = "Button: $label"
}

class TextField(private val placeholder: String) : UIComponent() {
    override fun addComponent(component: UIComponent) {
        throw UnsupportedOperationException("component를 TextField에 추가할 수 없습니다")
    }

    override fun removeComponent(component: UIComponent) {
        throw UnsupportedOperationException("component를 TextField에서 제거할 수 없습니다")
    }

    override fun render(): String = "<input type='text' placeholder='$placeholder'>"
    override fun print(): String = "TextField: $placeholder"
}

class Panel(private val title: String) : UIComponent() {
    private val components: MutableList<UIComponent> = mutableListOf()

    override fun addComponent(component: UIComponent) {
        components.add(component)
    }

    override fun removeComponent(component: UIComponent) {
        components.remove(component)
    }

    override fun render(): String {
        val renderedComponents = components.joinToString("\n") { it.render() }
        return "<div class='panel'><h2>$title</h2>$renderedComponents</div>"
    }

    override fun print(): String {
        val printedComponents = components.joinToString("\n") { it.print() }
        return "Panel: $title\n$printedComponents"
    }
}