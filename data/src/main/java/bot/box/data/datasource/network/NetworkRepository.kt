package bot.box.data.datasource.network

import bot.box.domain.client.ApiClient
import bot.box.domain.datasource.network.INetworkRepository
import bot.box.domain.factory.IApiFactory
import bot.box.domain.model.CovidResponse
import bot.box.domain.model.UpdateResponse
import io.reactivex.Single

class NetworkRepository(private val factory: IApiFactory) :
    INetworkRepository {
    override fun getCovidData(): Single<CovidResponse> = factory.apiClient.getData()

    override fun getUpdates(): Single<List<UpdateResponse>> = factory.apiClient.getUpdates()
}