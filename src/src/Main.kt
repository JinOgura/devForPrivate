import java.io.Console
import java.io.File
import java.io.OutputStream
import java.io.PrintStream

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val fileName = "C:\\Users\\rkfeo\\Downloads\\da.txt"
        val file = File(fileName)

        val text = file.readText().replace("\\s".toRegex(), "").replace("?", "?はてなだよ").replace("。", "。コンマだよ")
        val linesArray = text.split("コンマだよ","\n", "はてなだよ")

        val gw = TestWindow("テストウィンドウ", 400, 300, linesArray.toTypedArray())
        gw.isVisible = true
    }
}