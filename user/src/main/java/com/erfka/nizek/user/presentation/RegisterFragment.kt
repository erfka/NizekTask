package com.erfka.nizek.user.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.erfka.nizek.base.BaseFragment
import com.erfka.nizek.base.ResultWrapper
import com.erfka.nizek.user.databinding.FragmentRegisterBinding
import com.erfka.nizek.user.domain.model.User
import com.erfka.nizek.user.presentation.viewmodel.RegisterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : BaseFragment<FragmentRegisterBinding>() {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentRegisterBinding {
        return FragmentRegisterBinding.inflate(inflater, container, false)
    }

    private val viewModel: RegisterViewModel by viewModels()

    override fun setupViews() {
        binding.tvToLogin.setOnClickListener {
            goToLoginFragment()
        }

        binding.btnRegister.setOnClickListener {
            viewModel.registerIfUserNotExists(getUser(), binding.etPassword.text.toString())
        }
    }

    private fun goToLoginFragment() {
        val action = RegisterFragmentDirections.toLogin()
        NavHostFragment.findNavController(this).navigate(action)
    }

    private fun getUser(): User {
        return User(
            binding.etFullName.text.toString(),
            binding.etUsername.text.toString()
        )
    }

    override fun observe() {
        viewModel.tryRegisterUser.observe(viewLifecycleOwner) {
            when (it) {
                is ResultWrapper.Loading -> {
                    //Todo: show a loading animation
                }
                is ResultWrapper.Success -> {
                    Toast.makeText(context, it.successData, Toast.LENGTH_LONG).show()
                    goToLoginFragment()
                }
                is ResultWrapper.Error -> {
                    Toast.makeText(context, it.errorMessage, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

}