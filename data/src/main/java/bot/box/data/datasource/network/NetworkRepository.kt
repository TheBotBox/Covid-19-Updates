package bot.box.data.datasource.network

import bot.box.domain.client.ApiClient
import bot.box.domain.datasource.network.INetworkRepository
import bot.box.domain.factory.IApiFactory
import bot.box.domain.model.CovidResponse
import io.reactivex.Single

class NetworkRepository(private val factory: IApiFactory) :
    INetworkRepository {
    override fun getData(): Single<CovidResponse> = factory.apiClient.getData()
}