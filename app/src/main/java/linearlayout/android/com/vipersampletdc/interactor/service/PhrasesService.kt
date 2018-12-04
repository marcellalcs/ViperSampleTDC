package linearlayout.android.com.vipersampletdc.interactor.service

import io.reactivex.Observable
import linearlayout.android.com.vipersampletdc.entity.PhraseResultEntity
import retrofit2.http.GET
import retrofit2.http.Path

interface PhrasesService {

        @GET("random/{quantity}")
        fun fetchRandomPhrase(@Path("quantity") quantity : Int) : Observable<PhraseResultEntity>
}