package bot.box.covidtracker.util

import android.text.format.DateUtils
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("humanReadable")
fun setRelativeTime(tv: TextView, time: Long? = 0) {
    tv.text = if (time != null && time > 0) {
        try {
            DateUtils.getRelativeTimeSpanString(time * 1000)
        } catch (e: Exception) {
            ""
        }
    } else ""
}