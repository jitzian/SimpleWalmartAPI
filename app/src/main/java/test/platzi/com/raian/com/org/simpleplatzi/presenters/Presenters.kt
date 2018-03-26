package test.platzi.com.raian.com.org.simpleplatzi.presenters

interface IMainPresenter{
    fun validateInputUserNameLength(userName : String?):Boolean
    fun validateInputPasswordLength(password: String?):Boolean
    fun executeAuthentication(userName:String?, password:String?)
    fun redirectToWelcomeActivity()

}

interface IWelcomePresenter {

}