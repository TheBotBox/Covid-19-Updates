package bot.box.data.factory


import bot.box.domain.client.ApiClient
import bot.box.domain.factory.IApiFactory
import retrofit2.Retrofit

class ApiClientFactory(private val mRetrofit: Retrofit) :
    IApiFactory {

    override val apiClient: ApiClient
        get() = mRetrofit.create(ApiClient::class.java)
}
