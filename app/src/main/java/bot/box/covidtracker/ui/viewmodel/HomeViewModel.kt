package bot.box.covidtracker.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import bot.box.domain.datasource.network.INetworkRepository

import bot.box.domain.datasource.preferennce.IPreference
import retrofit2.Retrofit

class HomeViewModel(
    private val mApplication: Application,
    private val iNetworkRepository: INetworkRepository,
    private val iPreference: IPreference
) : AndroidViewModel(mApplication){

}