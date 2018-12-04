package linearlayout.android.com.vipersampletdc.interactor

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import linearlayout.android.com.vipersampletdc.entity.PhraseEntity
import linearlayout.android.com.vipersampletdc.interactor.utils.HTTPManager
import linearlayout.android.com.vipersampletdc.interactor.utils.getRandomElement

class PhraseInteractor {

    fun fetchPhrase(): Observable<PhraseEntity> {
        return HTTPManager.phrasesService.fetchRandomPhrase()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}