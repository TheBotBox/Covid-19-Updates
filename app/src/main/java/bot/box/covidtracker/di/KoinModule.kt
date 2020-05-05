package bot.box.covidtracker.di


import bot.box.covidtracker.ui.viewmodel.HomeViewModel
import bot.box.data.datasource.network.NetworkRepository
import bot.box.data.datasource.preference.PreferenceHelper

import bot.box.data.factory.ApiClientFactory
import bot.box.domain.datasource.network.INetworkRepository
import bot.box.domain.datasource.preferennce.IPreference
import bot.box.domain.factory.IApiFactory
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit


val koinNetworkModule = module(override = true) {
    single<Retrofit> { provideRetrofit }
    single<IApiFactory> { ApiClientFactory(get()) }
}

val koinApplicationModule = module(override = true) {
    single<IPreference> { PreferenceHelper(get()) }
    single<INetworkRepository> { NetworkRepository(get()) }
}

val koinViewModel = module {
    viewModel { HomeViewModel(get(), get(), get()) }
}