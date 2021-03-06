package bot.box.covidtracker.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import bot.box.covidtracker.util.extension.hasNetwork
import bot.box.covidtracker.util.extension.showToast
import bot.box.domain.datasource.network.INetworkRepository
import bot.box.domain.datasource.preferennce.IPreference
import bot.box.domain.model.CovidDaily
import bot.box.domain.model.CovidResponse
import bot.box.domain.model.State
import bot.box.domain.model.UpdateResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomeViewModel(
    private val mApplication: Application,
    private val iNetworkRepository: INetworkRepository,
    private val iPreference: IPreference
) : AndroidViewModel(mApplication) {
    private val disposable = CompositeDisposable()

    var mConnectionStatus: ((Boolean) -> Unit)? = null

    /***************************HomeFragment work starts*******************************************************************/

    private val covidDaily: MutableLiveData<List<CovidDaily>> = MutableLiveData() // for daily
    val _covidDaily: LiveData<List<CovidDaily>>
        get() = covidDaily

    private val mStateWise: MutableLiveData<State> = MutableLiveData() //for first time of state
    val _mStateWise: LiveData<State>
        get() = mStateWise

    fun getCovidData() {
        if (!mApplication.hasNetwork()) {
            mApplication showToast "No Internet Connection"
            return
        }
        disposable.add(
            iNetworkRepository.getCovidData()
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { mConnectionStatus?.invoke(true) }
                .doOnError { mConnectionStatus?.invoke(false) }
                .doOnSuccess { mConnectionStatus?.invoke(false) }
                .subscribe({
                    mStateWise.value = it.statewise.first()
                    covidDaily.value = it.covidDaily.reversed()
                }, {
                    mApplication showToast (it.message ?: "Something went wrong")
                })
        )
    }
    /***************************HomeFragment work ends*******************************************************************/

    /***************************UpdateFragment work starts*******************************************************************/
    private val mUpdates: MutableLiveData<List<UpdateResponse>> = MutableLiveData()
    val _covidUpdates: LiveData<List<UpdateResponse>> get() = mUpdates

    private val isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val _isLoading: LiveData<Boolean> get() = isLoading

    fun getUpdates() {
        if (!mApplication.hasNetwork) {
            mApplication showToast "No Internet Connection"
        }
        disposable.add(
            iNetworkRepository.getUpdates()
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { isLoading.value = true }
                .doOnError { isLoading.value = false }
                .doOnSuccess { isLoading.value = false }
                .subscribe({
                    mUpdates.value = it.reversed()
                }, {
                    mApplication showToast (it.message ?: "Something went wrong")
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        if (!disposable.isDisposed) disposable.dispose()
    }
}

