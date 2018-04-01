package test.platzi.com.raian.com.org.simpleplatzi.presenters

import com.dxtt.coolmenu.CoolMenuFrameLayout
import test.platzi.com.raian.com.org.simpleplatzi.model.ResultQueryWalmartProduct

interface IMainPresenter{
    fun validateInputUserNameLength(userName : String?):Boolean
    fun validateInputPasswordLength(password: String?):Boolean
    fun executeAuthentication(userName:String?, password:String?)
    fun redirectToWelcomeActivity()
}

interface IWelcomePresenter {
    fun setTitlesList(coolMenuFrameLayout : CoolMenuFrameLayout)
}

interface IInitialWelcomeFragmentPresenter{
    fun loadRandomProducts() : ResultQueryWalmartProduct?

}