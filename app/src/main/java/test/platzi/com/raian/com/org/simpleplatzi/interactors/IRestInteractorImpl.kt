package test.platzi.com.raian.com.org.simpleplatzi.interactors

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import test.platzi.com.raian.com.org.simpleplatzi.constants.GlobalConstants
import test.platzi.com.raian.com.org.simpleplatzi.model.ResultQueryWalmartProduct
import test.platzi.com.raian.com.org.simpleplatzi.providers.RetrofitProvider
import test.platzi.com.raian.com.org.simpleplatzi.rest.RestService

class IRestInteractorImpl : IRestInteractor{
    private val TAG = IRestInteractorImpl::class.java.simpleName
    private var result : ResultQueryWalmartProduct? = null

    override fun getProductsUsingQueryFilter(query: String): ResultQueryWalmartProduct? {

        val retrofit = RetrofitProvider.getInstance().getRetrofit(GlobalConstants.baseURLWalmart)
        val restService = retrofit.create(RestService::class.java)

        restService.getProductsUsingQueryFilter(query).enqueue(object : Callback<ResultQueryWalmartProduct>{
            override fun onResponse(call: Call<ResultQueryWalmartProduct>?, response: Response<ResultQueryWalmartProduct>?) {
                println("$TAG --> $response")
                result = response?.body()!!
            }

            override fun onFailure(call: Call<ResultQueryWalmartProduct>?, t: Throwable?) {
                println("$TAG --> ${t?.message}")
            }

        })

        return result
    }

}