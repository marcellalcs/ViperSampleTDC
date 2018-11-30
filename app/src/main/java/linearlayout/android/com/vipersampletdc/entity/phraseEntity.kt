package linearlayout.android.com.vipersampletdc.entity

import com.google.gson.annotations.SerializedName

data class PhraseEntity(@SerializedName("quote") var phrase: String, @SerializedName("author") var author: String)