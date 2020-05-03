package bot.box.covidtracker.data.network.factory

import bot.box.covidtracker.data.network.client.ApiClient

interface IApiFactory {
    val apiClient: ApiClient
}