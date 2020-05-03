package bot.box.covidtracker.di

import bot.box.covidtracker.data.PreferenceHelper
import bot.box.covidtracker.data.network.factory.ApiClientFactory
import bot.box.covidtracker.data.network.factory.IApiFactory
import bot.box.covidtracker.data.repository.IRepository
import bot.box.covidtracker.data.repository.RepositoryImpl
import bot.box.covidtracker.ui.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val koinNetworkModule = module {
    single<Retrofit> { provideRetrofit }
    single<IApiFactory> { ApiClientFactory(get<Retrofit>()) }
}

val koinApplicationModule = module(override = true) {
    single { PreferenceHelper(get()) }
    single<IRepository> { RepositoryImpl(get()) }
}

val koinViewModel = module {
    viewModel { HomeViewModel(get(), get(), get()) }
}