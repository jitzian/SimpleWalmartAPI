package test.platzi.com.raian.com.org.simpleplatzi.ui.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import test.platzi.com.raian.com.org.simpleplatzi.R
import test.platzi.com.raian.com.org.simpleplatzi.adapters.RVCustomAdapter
import test.platzi.com.raian.com.org.simpleplatzi.constants.GlobalConstants
import test.platzi.com.raian.com.org.simpleplatzi.model.ResultQueryWalmartProduct
import test.platzi.com.raian.com.org.simpleplatzi.presenters.IInitialWelcomeFragmentPresenter
import test.platzi.com.raian.com.org.simpleplatzi.providers.RetrofitProvider
import test.platzi.com.raian.com.org.simpleplatzi.rest.RestService

class InitialWelcomeFragment : Fragment() {
    private var TAG : String = InitialWelcomeFragment::class.java.simpleName
    private var rootView: View? = null
    private lateinit var presenter : IInitialWelcomeFragmentPresenter

    private lateinit var mRecyclerViewInitialWelcome : RecyclerView
    private var adapter : RVCustomAdapter?= null
    private lateinit var layoutManager : RecyclerView.LayoutManager

    private var retrofit : Retrofit? = null


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        rootView = inflater?.inflate(R.layout.fragment_initial_welcome, container, false)
        initializeView()
//        presenter = IInitialWelcomeFragmentPresenterImpl(context)

        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        retrofit = RetrofitProvider.getInstance().getRetrofit(GlobalConstants.baseURLWalmart)
        val restService:RestService? = retrofit?.create(RestService::class.java)

        restService?.getProductsUsingQueryFilter("condoms")?.enqueue(object: Callback<ResultQueryWalmartProduct>{
            override fun onResponse(call: Call<ResultQueryWalmartProduct>?, response: Response<ResultQueryWalmartProduct>?) {
                println("onResponse:: ${response?.body()?.items?.size}")
                adapter = RVCustomAdapter(response?.body()?.items, context)
                activity.runOnUiThread({
                    mRecyclerViewInitialWelcome.adapter = adapter
                })
            }

            override fun onFailure(call: Call<ResultQueryWalmartProduct>?, t: Throwable?) {
                println("onFailure:: ${t?.message}")
            }

        })

    }

    private fun initializeView(){
        mRecyclerViewInitialWelcome = rootView?.findViewById(R.id.mRecyclerViewInitialWelcome) as RecyclerView
        mRecyclerViewInitialWelcome.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(context)
        mRecyclerViewInitialWelcome.layoutManager = layoutManager

    }

}// Required empty public constructor
