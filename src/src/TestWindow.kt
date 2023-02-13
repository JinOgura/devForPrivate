import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import javax.swing.JFrame

class TestWindow(title: String?, width: Int, height: Int, linesArray: Array<String>) : JFrame(title),
    KeyListener {
    private val array = linesArray
    private var index = -1

    init {
        defaultCloseOperation = EXIT_ON_CLOSE
        setSize(width, height)
        setLocationRelativeTo(null)
        layout = null
        isResizable = false

        //キー入力の有効化
        addKeyListener(this)
    }

    override fun keyTyped(e: KeyEvent) {
    }

    override fun keyReleased(e: KeyEvent) {
    }

    override fun keyPressed(e: KeyEvent) {
        when (e.keyCode) {
            KeyEvent.VK_DOWN -> {
                toNextText()
            }

            KeyEvent.VK_ENTER -> {
                toNextText()
            }

            KeyEvent.VK_UP -> {
                index--
                if (index <= -1) {
                    index = -1
                    makeText("最初のtextです")
                } else {
                    makeText(array[index])
                }
            }

            KeyEvent.VK_LEFT -> {
               Main.reset()
            }
        }
    }

    private fun makeText(text: String) {
        for (n in 0 until 100) {
            println("")
        }
        println(text)
    }

    private fun toNextText() {
        index++
        if (index >= array.size) {
            index = array.size
            makeText("テキスト終了")
        } else {
            makeText(array[index])
        }
    }
}