import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import javax.swing.JFrame

object TextWindow {
    private var index = -1

    class TestWindow(title: String?, width: Int, height: Int, linesArray: Array<String>) : JFrame(title),
        KeyListener {
        private val array = linesArray

        init {
            defaultCloseOperation = EXIT_ON_CLOSE
            setSize(width, height)
            setLocationRelativeTo(null)
            layout = null
            isResizable = false

            //キー入力の有効化
            addKeyListener(this)
        }

        override fun keyPressed(e: KeyEvent) {
            when (e.keyCode) {
                KeyEvent.VK_DOWN -> {
                    toNextText(array)
                }

                KeyEvent.VK_ENTER -> {
                    toNextText(array)
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

        //使わないものリスト
        override fun keyTyped(e: KeyEvent) {}
        override fun keyReleased(e: KeyEvent) {}
    }

    fun toNextText(array: Array<String>) {
        index++
        if (index >= array.size) {
            index = array.size
            makeText("テキスト終了")
        } else {
            makeText(array[index])
        }
    }

    private fun makeText(text: String) {
        for (n in 0 until 100) {
            println("")
        }
        println(text)
    }
}