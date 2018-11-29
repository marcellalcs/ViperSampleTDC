package linearlayout.android.com.vipersampletdc

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.second_activity.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        val phrase = intent.getStringExtra("phrase")
        secondActivityContent.text = phrase
    }
}