package test.platzi.com.raian.com.org.simpleplatzi.ui

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.dxtt.coolmenu.CoolMenuFrameLayout
import kotlinx.android.synthetic.main.activity_welcome.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import test.platzi.com.raian.com.org.simpleplatzi.R
import test.platzi.com.raian.com.org.simpleplatzi.presenters.IWelcomePresenter
import test.platzi.com.raian.com.org.simpleplatzi.presenters.IWelcomePresenterImpl

class WelcomeActivityTest : AppCompatActivity() {

    val TAG = WelcomeActivityTest::class.java.simpleName
    private lateinit var coolMenuFrameLayout : CoolMenuFrameLayout
    private var presenter : IWelcomePresenter = IWelcomePresenterImpl(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        setControls()

    }

    fun setControls(){
        coolMenuFrameLayout = findViewById(R.id.coolMenuFrameLayout)
        presenter.setTitlesList(coolMenuFrameLayout)
    }

    fun <T> callback(fn: (Throwable?, Response<T>?) -> Unit): Callback<T> {
        return object : Callback<T> {
            override fun onResponse(call: Call<T>, response: retrofit2.Response<T>) = fn(null, response)
            override fun onFailure(call: Call<T>, t: Throwable) = fn(t, null)
        }
    }

}
