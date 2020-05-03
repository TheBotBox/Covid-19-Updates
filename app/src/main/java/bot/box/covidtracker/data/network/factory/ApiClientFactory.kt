package bot.box.covidtracker.data.network.factory

import bot.box.covidtracker.data.network.client.ApiClient
import retrofit2.Retrofit

class ApiClientFactory(private val mRetrofit: Retrofit) : IApiFactory {

    override val apiClient: ApiClient
        get() = mRetrofit.create(ApiClient::class.java)
}