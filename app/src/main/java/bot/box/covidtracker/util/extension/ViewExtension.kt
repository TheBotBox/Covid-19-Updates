package bot.box.covidtracker.util.extension

import android.view.View

fun View.gone() {
    visibility = View.GONE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.isVisible(): Boolean = visibility == View.VISIBLE
fun View.isGone(): Boolean = visibility == View.GONE
fun View.isInvisible(): Boolean = visibility == View.INVISIBLE
