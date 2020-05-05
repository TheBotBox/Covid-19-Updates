package bot.box.data.datasource.preference

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import bot.box.domain.datasource.preferennce.IPreference

class PreferenceHelper(context: Context) : IPreference {
    private val sharedPref: SharedPreferences by lazy {
        context.getSharedPreferences("COVID", Context.MODE_PRIVATE)
    }

    fun clearData() {
        sharedPref.edit { clear() }
    }
}