package com.sachy.androidstructure.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sachy.androidstructure.AppStates

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel(),
    LoginRepository.LoginRepositoryCallback {

    lateinit var username: String
    lateinit var password: String
    var response: LoginResponse? = null
    lateinit var massage:String
    /**Declare the LD instance*/
    private val _loginState: MutableLiveData<String> = MutableLiveData()

    /**Declare public Getter for LD*/
    val loginState: LiveData<String>
        get() = _loginState

    /**Forward flow*/
    fun login() {
        loginRepository.login(username, password, this)
    }


    /**Backward flow callback*/
    override fun loginSuccess(msg: LoginResponse?) {
        response = msg
        _loginState.value = AppStates.LOGIN_SUCCESS
    }

    override fun loginFailure(msg: String) {
        massage = msg
        _loginState.value = AppStates.LOGIN_ERROR
    }

    /**Override definition of ViewModel constructor to pass argument*/
    class LoginViewModelFactory(private val loginRepository: LoginRepository) :
        ViewModelProvider.NewInstanceFactory() {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return LoginViewModel(loginRepository) as T
        }
    }
}