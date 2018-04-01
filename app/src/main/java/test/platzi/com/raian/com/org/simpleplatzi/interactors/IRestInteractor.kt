package test.platzi.com.raian.com.org.simpleplatzi.interactors

import test.platzi.com.raian.com.org.simpleplatzi.model.ResultQueryWalmartProduct

interface IRestInteractor{
    fun getProductsUsingQueryFilter(query : String) : ResultQueryWalmartProduct?
}