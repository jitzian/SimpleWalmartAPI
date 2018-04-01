package test.platzi.com.raian.com.org.simpleplatzi.presenters

import android.content.Context
import test.platzi.com.raian.com.org.simpleplatzi.interactors.IRestInteractor
import test.platzi.com.raian.com.org.simpleplatzi.interactors.IRestInteractorImpl
import test.platzi.com.raian.com.org.simpleplatzi.model.ResultQueryWalmartProduct

class IInitialWelcomeFragmentPresenterImpl (var context: Context) : IInitialWelcomeFragmentPresenter{
    private var restInteractor : IRestInteractor = IRestInteractorImpl()

    override fun loadRandomProducts(): ResultQueryWalmartProduct {
        return restInteractor.getProductsUsingQueryFilter("")
    }

}