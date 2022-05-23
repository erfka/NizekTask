package com.erfka.nizek.user.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.erfka.nizek.base.BaseFragment
import com.erfka.nizek.base.ResultWrapper
import com.erfka.nizek.user.databinding.FragmentLoginBinding
import com.erfka.nizek.user.presentation.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>() {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentLoginBinding {
        return FragmentLoginBinding.inflate(inflater, container, false)
    }

    private val viewModel: LoginViewModel by viewModels()

    override fun setupViews() {

        binding.tvToRegister.setOnClickListener {
            val action = LoginFragmentDirections.toRegister()
            NavHostFragment.findNavController(this).navigate(action)
        }

        binding.btnLogin.setOnClickListener {
            viewModel.tryLoginUser(
                binding.etUsername.text.toString(),
                binding.etPassword.text.toString()
            )
        }


    }

    override fun observe() {

        viewModel.tryLoginUser.observe(viewLifecycleOwner) {

            when (it) {
                is ResultWrapper.Loading -> {
                    //Todo: show a loading animation
                }
                is ResultWrapper.Success -> {
                    Toast.makeText(context, it.successData, Toast.LENGTH_LONG).show()
                    //open Main
                }
                is ResultWrapper.Error -> {
                    Toast.makeText(context, it.errorMessage, Toast.LENGTH_LONG).show()
                }
            }

        }
    }


}