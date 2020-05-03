package bot.box.covidtracker.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import bot.box.covidtracker.data.PreferenceHelper
import bot.box.covidtracker.data.repository.IRepository

class HomeViewModel(
    private val mApplication: Application,
    private val iRepository: IRepository,
    mPreferenceHelper: PreferenceHelper
) : AndroidViewModel(mApplication)