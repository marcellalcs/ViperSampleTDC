package linearlayout.android.com.vipersampletdc.interactor.service

import io.reactivex.Observable
import linearlayout.android.com.vipersampletdc.entity.PhraseResultEntity
import retrofit2.http.GET
import retrofit2.http.Path

interface PhrasesService {

        @GET("quotes/")
        fun fetchRandomPhrase() : Observable<PhraseResultEntity>
}