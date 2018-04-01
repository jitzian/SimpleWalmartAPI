package test.platzi.com.raian.com.org.simpleplatzi.ui.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import test.platzi.com.raian.com.org.simpleplatzi.R
import test.platzi.com.raian.com.org.simpleplatzi.presenters.IInitialWelcomeFragmentPresenter
import test.platzi.com.raian.com.org.simpleplatzi.presenters.IInitialWelcomeFragmentPresenterImpl

class InitialWelcomeFragment : Fragment() {
    private var TAG : String = InitialWelcomeFragment::class.java.simpleName
    private var rootView: View? = null
    private lateinit var mRecyclerViewInitialWelcome : RecyclerView
    private lateinit var presenter : IInitialWelcomeFragmentPresenter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        rootView = inflater?.inflate(R.layout.fragment_initial_welcome, container, false)

        presenter = IInitialWelcomeFragmentPresenterImpl(context)
        presenter.loadRandomProducts()

        return rootView
    }




}// Required empty public constructor
