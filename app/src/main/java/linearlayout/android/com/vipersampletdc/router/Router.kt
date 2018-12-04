package linearlayout.android.com.vipersampletdc.router

import android.app.Activity
import android.content.Intent
import linearlayout.android.com.vipersampletdc.view.PhraseActivity

private const val PHRASE_INTENT_EXTRA = "initialPhrase"

fun navigateToPhraseScreen(view: Activity, initialPhrase: String) {
    val intent = Intent(view, PhraseActivity::class.java)
    intent.putExtra(PHRASE_INTENT_EXTRA, initialPhrase)
    view.startActivity(intent)
}