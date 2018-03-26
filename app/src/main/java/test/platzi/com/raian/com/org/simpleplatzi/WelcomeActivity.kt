package test.platzi.com.raian.com.org.simpleplatzi

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_welcome.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WelcomeActivity : AppCompatActivity() {
    val TAG = WelcomeActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

    }

    fun <T> callback(fn: (Throwable?, Response<T>?) -> Unit): Callback<T> {
        return object : Callback<T> {
            override fun onResponse(call: Call<T>, response: retrofit2.Response<T>) = fn(null, response)
            override fun onFailure(call: Call<T>, t: Throwable) = fn(t, null)
        }
    }

}
