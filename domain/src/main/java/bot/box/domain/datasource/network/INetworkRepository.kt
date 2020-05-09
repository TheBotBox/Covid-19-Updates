package bot.box.domain.datasource.network

import bot.box.domain.model.CovidResponse
import bot.box.domain.model.UpdateResponse
import io.reactivex.Single

interface INetworkRepository {
    /**
     * will populate HomeFragment data
     */
    fun getCovidData(): Single<CovidResponse>

    /**
     * will populate UpdateFragment data
     */
    fun getUpdates(): Single<List<UpdateResponse>>
}