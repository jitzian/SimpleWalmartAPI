package test.platzi.com.raian.com.org.simpleplatzi.providers

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import test.platzi.com.raian.com.org.simpleplatzi.constants.GlobalConstants
import java.util.concurrent.Executors

class RetrofitProvider private constructor(){
    companion object {
        private val mInstance = RetrofitProvider()

        @Synchronized
        fun getInstance(): RetrofitProvider{
            return mInstance
        }
    }

    fun getRetrofit(baseURL: String?):Retrofit{
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .callbackExecutor(Executors.newSingleThreadExecutor())
                .baseUrl(baseURL)
                .build()
    }

}