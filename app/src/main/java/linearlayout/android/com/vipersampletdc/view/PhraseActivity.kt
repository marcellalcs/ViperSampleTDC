package linearlayout.android.com.vipersampletdc.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.phrase_activity.*
import linearlayout.android.com.vipersampletdc.R
import linearlayout.android.com.vipersampletdc.presenter.PhrasePresenter

class PhraseActivity : AppCompatActivity() {

    private var presenter: PhrasePresenter = PhrasePresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.phrase_activity)

        presenter.setInitialPhrase()

        newPhraseButton.setOnClickListener {
            presenter.generateRandomPhrase()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.disposeCalls()
    }

    fun setPhraseText(text: String){
        phraseTextView.text = text
    }
}