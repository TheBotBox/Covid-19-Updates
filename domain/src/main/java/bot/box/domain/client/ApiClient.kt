package bot.box.domain.client

import bot.box.domain.model.CovidResponse
import io.reactivex.Single
import retrofit2.http.GET

interface ApiClient {
    @GET("data.json")
    fun getData(): Single<CovidResponse>
}