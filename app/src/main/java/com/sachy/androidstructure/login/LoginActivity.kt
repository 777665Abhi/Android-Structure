package com.sachy.androidstructure.login

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sachy.androidstructure.AppStates
import com.sachy.androidstructure.R
import com.sachy.androidstructure.databinding.ActivityLoginBinding
import com.sachy.androidstructure.home.HomeActivity
import com.sachy.androidstructure.utils.AppPreferences
import com.sachy.androidstructure.utils.IntentUtil
import com.sachy.androidstructure.utils.ToastUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityLoginBinding
    lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        init()
    }

    private fun init() {
        binding.btLogin.setOnClickListener(this)

        /**1 Create instance of VM and Observing LD*/
        viewModel = ViewModelProvider(
            this,
            LoginViewModel.LoginViewModelFactory(LoginRepository("ApiClient", this))
        ).get(LoginViewModel::class.java)

        // Create the observer which updates the UI.
        val nameObserver = Observer<String> { state ->
            when (state) {
                AppStates.LOGIN_SUCCESS -> {
                    storeUserData()
                    ToastUtil.showToast(this, viewModel.massage)
                    IntentUtil.startActivity(this, HomeActivity::class.java, true)
                }
                AppStates.LOGIN_ERROR -> {
                    ToastUtil.showToast(this, viewModel.massage)
                }
            }
        }

        // Observe the LiveData  for Reactive UI, passing in this activity as the LifecycleOwner and the observer.
        viewModel.loginState.observe(this, nameObserver)
    }

    /**Using coroutines to store data in share preference */
    private fun storeUserData() {
        GlobalScope.launch(Dispatchers.Main) {
            AppPreferences.setLoginStatus(
                this@LoginActivity, true, "" +
                        ""
            )
        }
    }

    /**Onclick*/
    override fun onClick(v: View?) {
        when (v) {
            binding.btLogin -> {
                validateUserInput(binding.etUser.text.toString(), binding.etPass.text.toString())
            }
        }
    }

    /**Data validation*/
    private fun validateUserInput(userName: String, password: String) {
        if (TextUtils.isEmpty(userName) || (TextUtils.isEmpty(password))) {
            ToastUtil.showToast(this, getString(R.string.fill_all))
        } else {
            viewModel.username = binding.etUser.text.toString()
            viewModel.password = binding.etPass.text.toString()
            viewModel.login()
        }
    }
}
