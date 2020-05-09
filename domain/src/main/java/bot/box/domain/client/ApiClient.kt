package bot.box.domain.client

import bot.box.domain.model.CovidResponse
import bot.box.domain.model.UpdateResponse
import io.reactivex.Single
import retrofit2.http.GET

interface ApiClient {
    @GET("data.json")
    fun getData(): Single<CovidResponse>

    @GET("/updatelog/log.json")
    fun getUpdates(): Single<List<UpdateResponse>>
}