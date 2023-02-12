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
                index++
                if (index >= array.size) {
                    index = array.size
                    for (n in 0 until 100) {
                        println("")
                    }
                    println("テキスト終了")
                } else {
                    for (n in 0 until 100) {
                        println("")
                    }
                    println(array[index] + "。")
                }
            }

            KeyEvent.VK_ENTER -> {
                index++
                if (index >= array.size) {
                    index = array.size
                    for (n in 0 until 100) {
                        println("")
                    }
                    println("テキスト終了")
                } else {
                    for (n in 0 until 100) {
                        println("")
                    }
                    println(array[index] + "。")
                }
            }

            KeyEvent.VK_UP -> {
                index--
                if (index <= -1) {
                    index = -1
                    for (n in 0 until 100) {
                        println("")
                    }
                    println("最初のtextです")
                } else {
                    for (n in 0 until 100) {
                        println("")
                    }
                    println(array[index] + "。")
                }
            }
        }
    }
}