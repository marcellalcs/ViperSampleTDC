package linearlayout.android.com.vipersampletdc.presenter

import android.util.Log
import io.reactivex.disposables.Disposable
import linearlayout.android.com.vipersampletdc.view.MainActivity
import linearlayout.android.com.vipersampletdc.interactor.PhraseInteractor

class MainPresenter(var view: MainActivity) {

    var interactor: PhraseInteractor = PhraseInteractor()
    var disposable: Disposable? = null

    fun generateRandomPhrase() {
        disposable = interactor.fetchPhrases().subscribe({ randomPhrase ->
            randomPhrase?.let {
                //navigateToPhraseScreen(view, randomPhrase)
            }
        }, { e ->
            Log.e("MainPresenter", e.message, e)
        })
    }

    fun disposeCalls() {
        if (disposable != null && disposable?.isDisposed == false) {
            disposable?.dispose()
        }
    }
}