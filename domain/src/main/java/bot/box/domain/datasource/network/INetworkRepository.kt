package bot.box.domain.datasource.network

import bot.box.domain.model.CovidResponse
import io.reactivex.Single

interface INetworkRepository {
    fun getData(): Single<CovidResponse>
}