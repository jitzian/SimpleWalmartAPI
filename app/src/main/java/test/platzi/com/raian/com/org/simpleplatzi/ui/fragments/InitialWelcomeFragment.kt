package test.platzi.com.raian.com.org.simpleplatzi.ui.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import test.platzi.com.raian.com.org.simpleplatzi.R
import test.platzi.com.raian.com.org.simpleplatzi.adapters.RVCustomAdapter
import test.platzi.com.raian.com.org.simpleplatzi.constants.GlobalConstants
import test.platzi.com.raian.com.org.simpleplatzi.model.Item
import test.platzi.com.raian.com.org.simpleplatzi.model.ResultQueryWalmartProduct
import test.platzi.com.raian.com.org.simpleplatzi.presenters.IInitialWelcomeFragmentPresenter
import test.platzi.com.raian.com.org.simpleplatzi.providers.RetrofitProvider
import test.platzi.com.raian.com.org.simpleplatzi.rest.RestService

class InitialWelcomeFragment : Fragment() {
    private var TAG : String = InitialWelcomeFragment::class.java.simpleName
    private var rootView: View? = null
    private lateinit var presenter : IInitialWelcomeFragmentPresenter

    private lateinit var mEditTextSearchInitialWelcome : EditText
    private lateinit var mRecyclerViewInitialWelcome : RecyclerView
    private var adapter : RVCustomAdapter?= null
    private lateinit var layoutManager : RecyclerView.LayoutManager

    private var retrofit : Retrofit? = null

    private lateinit var lstRes :List<Item>


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        rootView = inflater?.inflate(R.layout.fragment_initial_welcome, container, false)
        initializeView()
        addListeners()

//        presenter = IInitialWelcomeFragmentPresenterImpl(context)

        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        retrofit = RetrofitProvider.getInstance().getRetrofit(GlobalConstants.baseURLWalmart)
        val restService:RestService? = retrofit?.create(RestService::class.java)

        restService?.getProductsUsingQueryFilter("condoms")?.enqueue(object: Callback<ResultQueryWalmartProduct>{
            override fun onResponse(call: Call<ResultQueryWalmartProduct>?, response: Response<ResultQueryWalmartProduct>?) {

                response?.body()?.let {
                    lstRes = response.body()!!.items!!
                }

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
        mEditTextSearchInitialWelcome = rootView?.findViewById(R.id.mEditTextSearchInitialWelcome) as EditText
        mRecyclerViewInitialWelcome = rootView?.findViewById(R.id.mRecyclerViewInitialWelcome) as RecyclerView
        mRecyclerViewInitialWelcome.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(context)
        mRecyclerViewInitialWelcome.layoutManager = layoutManager

    }

    private fun addListeners(){
        mEditTextSearchInitialWelcome.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
                filter(p0.toString())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }

    private fun filter(input: String){
        val filteredProducts = mutableListOf<Item>()
        for(s in lstRes){
            if(s.name?.toLowerCase()?.contains(input.toLowerCase())!!){
                filteredProducts.add(s)
            }
        }
        adapter?.filterList(filteredProducts as ArrayList<Item>)
    }

}// Required empty public constructor
