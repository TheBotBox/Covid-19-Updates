package bot.box.covidtracker.data.repository

import bot.box.covidtracker.data.network.factory.IApiFactory

class RepositoryImpl(private val clientFactory: IApiFactory) : IRepository