package bot.box.domain.factory

import bot.box.domain.client.ApiClient


interface IApiFactory {
    val apiClient: ApiClient
}