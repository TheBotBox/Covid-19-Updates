package bot.box.domain.model

import com.google.gson.annotations.SerializedName

data class UpdateResponse(
    @SerializedName("update")
    val update: String,
    @SerializedName("timestamp")
    val timeStamp: Long
)