package linearlayout.android.com.vipersampletdc.presenter

import android.util.Log
import io.reactivex.disposables.Disposable
import linearlayout.android.com.vipersampletdc.interactor.PhraseInteractor
import linearlayout.android.com.vipersampletdc.view.PhraseActivity

class PhrasePresenter(var view: PhraseActivity) {

    var interactor: PhraseInteractor = PhraseInteractor()
    var disposable: Disposable? = null

    fun generateRandomPhrase() {
        disposable = interactor.fetchPhrases().subscribe({ randomPhrase ->
            randomPhrase?.let {
                view.setPhraseText(randomPhrase)
            }
        }, { e ->
            Log.e("PhrasePresenter", e.message, e)
        })
    }

    fun disposeCalls() {
        if (disposable != null && disposable?.isDisposed == false) {
            disposable?.dispose()
        }
    }
}
