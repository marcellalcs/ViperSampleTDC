package linearlayout.android.com.vipersampletdc

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        generatePhraseButton.setOnClickListener{
            val intent =  Intent(this, SecondActivity::class.java)
            intent.putExtra("phrase", getData());

            startActivity(intent)
        }

    }

    private fun getData(): String {
        val address = "https://talaikis.com/api/quotes/random/"

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        try {
            val url = URL(address)

            val connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "GET"
            connection.connect()

            val response = BufferedReader(InputStreamReader(connection.inputStream))

            return response.readLine()

        } catch (e: IOException) {
            e.printStackTrace()
        }

        return ""
    }
}
