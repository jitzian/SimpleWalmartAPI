package test.platzi.com.raian.com.org.simpleplatzi.presenters

import android.content.Context
import android.content.Intent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import test.platzi.com.raian.com.org.simpleplatzi.constants.GlobalConstants
import test.platzi.com.raian.com.org.simpleplatzi.model.ResultAuthorization
import test.platzi.com.raian.com.org.simpleplatzi.providers.RetrofitProvider
import test.platzi.com.raian.com.org.simpleplatzi.rest.RestService
import test.platzi.com.raian.com.org.simpleplatzi.ui.WelcomeActivity
import test.platzi.com.raian.com.org.simpleplatzi.ui.utility.encodeBase64ToServer

class IMainPresenterImpl (var context : Context?) : IMainPresenter{

    private var TAG = IMainPresenterImpl::class.java.simpleName
    private lateinit var retrofit : Retrofit
    private lateinit var restService: RestService

    override fun validateInputUserNameLength(userName: String?): Boolean {
        var isValidLength = false
        userName?.let {
            isValidLength = userName.isNotEmpty()
        }
        return isValidLength
    }

    override fun validateInputPasswordLength(password: String?): Boolean {
        var isValidLength = false
        password?.let {
            isValidLength = password.isNotEmpty()
        }
        return isValidLength
    }

    override fun executeAuthentication(userName: String?, password: String?) {
        val authHeader = encodeBase64ToServer(userName, password)
        println("executeAuthentication : $userName : $password : $authHeader")

        retrofit = RetrofitProvider.getInstance().getRetrofit(GlobalConstants.baseURLAuthorization)
        restService = retrofit.create(RestService::class.java)

        var resultAuthorization = restService.getAuthorizationResponse(authHeader)
        resultAuthorization.enqueue(object : Callback<ResultAuthorization>{
            override fun onFailure(call: Call<ResultAuthorization>?, t: Throwable?) {
                println("This is a failure: ${t?.message} : ${t?.cause}")
            }

            override fun onResponse(call: Call<ResultAuthorization>?, response: Response<ResultAuthorization>?) {
                println("Everything worked out: ${response?.message()} : ${response?.body()} : ${response?.code()}")
                redirectToWelcomeActivity()
            }

        })

    }

    override fun redirectToWelcomeActivity() {
        var intent = Intent(context, WelcomeActivity::class.java)
        context?.startActivity(intent)
    }


}