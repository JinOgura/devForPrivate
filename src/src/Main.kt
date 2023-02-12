import java.io.Console
import java.io.File
import java.io.OutputStream
import java.io.PrintStream

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val fileName = "C:\\Users\\rkfeo\\Downloads\\da.txt"
        val file = File(fileName)

        val text = file.readText()
        val linesArray = text.split("。".toRegex()).toTypedArray()

        val gw = TestWindow("テストウィンドウ", 400, 300, linesArray)
        gw.isVisible = true
    }
}