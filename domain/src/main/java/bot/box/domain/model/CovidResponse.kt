package bot.box.domain.model

import bot.box.domain.common.inNumeric
import com.google.gson.annotations.SerializedName

data class CovidResponse(
    @SerializedName("cases_time_series")
    val covidDaily: List<CovidDaily>,
    @SerializedName("statewise")
    val statewise: List<State>
)

data class CovidDaily(
    @SerializedName("dailyconfirmed")
    val dailyconfirmed: String,
    @SerializedName("dailydeceased")
    val dailydeceased: String,
    @SerializedName("dailyrecovered")
    val dailyrecovered: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("totalconfirmed")
    var totalconfirmed: String,
    @SerializedName("totaldeceased")
    val totaldeceased: String,
    @SerializedName("totalrecovered")
    val totalrecovered: String
) {
    fun getTotalActiveCases() =
        totalconfirmed.inNumeric - (totaldeceased.inNumeric + (totalrecovered.inNumeric))

    fun getDailyActiveCases() =
        dailyconfirmed.inNumeric - (dailydeceased.inNumeric + (dailyrecovered.inNumeric))
}

data class State(
    @SerializedName("active")
    val active: String,
    @SerializedName("confirmed")
    val confirmed: String,
    @SerializedName("deaths")
    val deaths: String,
    @SerializedName("deltaconfirmed")
    val deltaconfirmed: String,
    @SerializedName("deltadeaths")
    val deltadeaths: String,
    @SerializedName("deltarecovered")
    val deltarecovered: String,
    @SerializedName("lastupdatedtime")
    val lastupdatedtime: String,
    @SerializedName("recovered")
    val recovered: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("statecode")
    val statecode: String,
    @SerializedName("statenotes")
    val statenotes: String
)