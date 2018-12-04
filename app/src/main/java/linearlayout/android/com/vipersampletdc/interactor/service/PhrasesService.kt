package linearlayout.android.com.vipersampletdc.interactor.service

import io.reactivex.Observable
import linearlayout.android.com.vipersampletdc.entity.PhraseEntity
import retrofit2.http.GET

interface PhrasesService {

        @GET("quotes/random")
        fun fetchRandomPhrase() : Observable<PhraseEntity>
}