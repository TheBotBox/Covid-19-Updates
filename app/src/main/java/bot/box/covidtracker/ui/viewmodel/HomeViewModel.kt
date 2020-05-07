package bot.box.covidtracker.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import bot.box.domain.datasource.network.INetworkRepository

import bot.box.domain.datasource.preferennce.IPreference
import bot.box.domain.model.CovidResponse
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.Scheduler
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import java.util.function.BiFunction

class HomeViewModel(
    private val mApplication: Application,
    private val iNetworkRepository: INetworkRepository,
    private val iPreference: IPreference
) : AndroidViewModel(mApplication) {
    private val disposable = CompositeDisposable()

    private val mData: MutableLiveData<CovidResponse> = MutableLiveData()
    val _mData: LiveData<CovidResponse>
        get() = mData

    fun getCovidData() {
        disposable.add(
            iNetworkRepository.getData()
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { }
                .doOnError { }
                .doOnSuccess { }
                .subscribe({
                    mData.value = it
                }, {
                    it.message
                })
        )


        iNetworkRepository.getData().subscribe({

        }, {

        }).dispose()
    }

    fun check(s: String) {}
    override fun onCleared() {
        super.onCleared()
        if (!disposable.isDisposed) disposable.dispose()
    }
}

