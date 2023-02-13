import java.io.File
import kotlin.io.*

object Main {
    private var gw: TestWindow? = null
    private var fileName = ""

    @JvmStatic
    fun main(args: Array<String>) {
        print("読み込みたいテキストファイルの絶対パスを入力してください。")
        fileName = readlnOrNull().toString()
        operate()
    }

    fun reset() {
        gw?.dispose()
        operate()
    }

    private fun operate() {
        val file = File(fileName)

        val text = file.readText().replace("?", "?はてなだよ").replace("。", "。コンマだよ")
        var linesArray = text.split("コンマだよ", "\r\n", "\n", "はてなだよ")
        linesArray = linesArray.filter { item -> item.isNotEmpty() }
        gw = TestWindow("テストウィンドウ", 400, 300, linesArray.toTypedArray())
        gw?.isVisible = true
    }
}