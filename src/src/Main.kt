import java.io.File

object Main {
    private var gw: TestWindow? = null

    @JvmStatic
    fun main(args: Array<String>) {
        operate()
    }

    fun reset() {
        gw?.dispose()
        operate()
    }

    private fun operate() {
        val fileName = "C:\\Users\\rkfeo\\Downloads\\da.txt"
        val file = File(fileName)

        val text = file.readText().replace("?", "?はてなだよ").replace("。", "。コンマだよ")
        var linesArray = text.split("コンマだよ", "\r\n", "\n", "はてなだよ")
        linesArray = linesArray.filter { item -> item.isNotEmpty() }
        gw = TestWindow("テストウィンドウ", 400, 300, linesArray.toTypedArray())
        gw?.isVisible = true
    }
}