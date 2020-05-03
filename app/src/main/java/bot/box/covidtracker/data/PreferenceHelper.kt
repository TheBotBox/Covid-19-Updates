package bot.box.covidtracker.data

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class PreferenceHelper(context: Context) {
    private val sharedPref: SharedPreferences =
        context.getSharedPreferences("CAMPAIGN", Context.MODE_PRIVATE)

    fun clearData() {
        sharedPref.edit { clear() }
    }
}