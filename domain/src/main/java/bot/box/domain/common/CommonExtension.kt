package bot.box.domain.common

fun String.inNumeric(): Int {
    return try {
        if (isNullOrEmpty()) 0 else if (this!!.toInt() < 0) 0 else this.toInt()
    } catch (e: Exception) {
        0
    }
}

val String.inNumeric: Int
    get() {
        return try {
            if (isNullOrEmpty()) 0 else if (this!!.toInt() < 0) 0 else this.toInt()
        } catch (e: Exception) {
            0
        }
    }


fun Int.percentage(second: String): Int {
    return if (this == null) {
        0
    } else {
        try {
            (second.inNumeric * 100).div(this)
        } catch (e: java.lang.Exception) {
            return 0
        }
    }
}