package linearlayout.android.com.vipersampletdc.interactor.utils

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import linearlayout.android.com.vipersampletdc.interactor.service.PhrasesService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_PHRASES_URL: String = "https://talaikis.com/api/"

object HTTPManager {
    val phrasesService by lazy { createPhraseService() }

    private fun createPhraseService(): PhrasesService {
        val gson = GsonBuilder()
                .setLenient()
                .create()

        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_PHRASES_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        return retrofit.create(PhrasesService::class.java)
    }
}