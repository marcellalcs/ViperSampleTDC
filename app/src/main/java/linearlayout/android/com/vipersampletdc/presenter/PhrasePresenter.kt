package linearlayout.android.com.vipersampletdc.presenter

import android.util.Log
import io.reactivex.disposables.Disposable
import linearlayout.android.com.vipersampletdc.interactor.PhraseInteractor
import linearlayout.android.com.vipersampletdc.view.PhraseActivity

private const val PHRASE_INTENT_EXTRA = "initialPhrase"

class PhrasePresenter(var view: PhraseActivity) {

    var interactor: PhraseInteractor = PhraseInteractor()
    var disposable: Disposable? = null

    fun generateRandomPhrase() {
        disposable = interactor.fetchPhrase().subscribe({ randomPhrase ->
            randomPhrase?.let {
                view.setPhraseText(randomPhrase.phrase)
            }
        }, { e ->
            Log.e("PhrasePresenter", e.message, e)
        })
    }

    fun setInitialPhrase() {
        val intent = view.intent
        val initialPhrase = intent.getStringExtra(PHRASE_INTENT_EXTRA)
        view.setPhraseText(initialPhrase)
    }

    fun disposeCalls() {
        if (disposable != null && disposable?.isDisposed == false) {
            disposable?.dispose()
        }
    }
}
