package bot.box.covidtracker.util

import android.text.format.DateUtils
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

object AppUtility {

    fun relativeTime(str: String? = null): String {
        return try {
            "Updated " + DateUtils.getRelativeTimeSpanString(
                SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault()).parse("$str").time,
                System.currentTimeMillis(),
                DateUtils.MINUTE_IN_MILLIS
            ).toString()
        } catch (e: Exception) {
            return str ?: ""
        }
    }

}