package test.platzi.com.raian.com.org.simpleplatzi

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import test.platzi.com.raian.com.org.simpleplatzi.presenters.IMainPresenter
import test.platzi.com.raian.com.org.simpleplatzi.presenters.IMainPresenterImpl

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName

    private lateinit var mEditTextUsername: EditText
    private lateinit var mEditTextPassword: EditText
    private lateinit var mButtonSignIn: Button

    private lateinit var mainPresenter : IMainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println(TAG)

        mainPresenter = IMainPresenterImpl(this)

        mEditTextUsername = findViewById(R.id.mEditTextUsername)
        mEditTextPassword = findViewById(R.id.mEditTextPassword)
        mButtonSignIn = findViewById(R.id.mButtonSignIn)

        mButtonSignIn.setOnClickListener(View.OnClickListener {
            if (mainPresenter.validateInputUserNameLength(mEditTextUsername.text?.toString()) &&
                    mainPresenter.validateInputPasswordLength(mEditTextPassword.text?.toString())){
                Toast.makeText(this, "Inputs are valid", Toast.LENGTH_LONG).show()
                mainPresenter.executeAuthentication(mEditTextUsername?.text?.toString(), mEditTextPassword?.text?.toString())
            }

        })

    }


}
