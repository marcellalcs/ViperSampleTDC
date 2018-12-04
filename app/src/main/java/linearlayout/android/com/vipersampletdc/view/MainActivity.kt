package linearlayout.android.com.vipersampletdc.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import linearlayout.android.com.vipersampletdc.R
import linearlayout.android.com.vipersampletdc.presenter.MainPresenter


class MainActivity : AppCompatActivity() {

    private var presenter: MainPresenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        generatePhraseButton.setOnClickListener {
            presenter.generateRandomPhrase()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.disposeCalls()
    }
}
