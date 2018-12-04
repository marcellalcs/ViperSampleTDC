package linearlayout.android.com.vipersampletdc.interactor.utils

fun <T> List<T>.getRandomElement(): T? {
    return if (this.isEmpty()) {
        null
    } else {
        val randomIndex = Math.floor(Math.random() * Math.floor(this.size.toDouble())).toInt()
        this[randomIndex]
    }
}