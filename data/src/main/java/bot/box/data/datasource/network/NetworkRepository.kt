package bot.box.data.datasource.network

import bot.box.domain.client.ApiClient
import bot.box.domain.datasource.network.INetworkRepository
import bot.box.domain.factory.IApiFactory

class NetworkRepository(private val apiClient: IApiFactory) :
    INetworkRepository {


}