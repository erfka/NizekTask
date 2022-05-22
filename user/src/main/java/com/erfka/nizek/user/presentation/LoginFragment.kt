package com.erfka.nizek.user.presentation

import androidx.navigation.fragment.NavHostFragment
import com.erfka.nizek.base.basefragment.BaseFragmentWithDataBinding
import com.erfka.nizek.user.R
import com.erfka.nizek.user.databinding.FragmentLoginBinding

class LoginFragment : BaseFragmentWithDataBinding<FragmentLoginBinding>(R.layout.fragment_login) {


    override fun setupViews() {

        binding.tvToRegister.setOnClickListener {
            val action = LoginFragmentDirections.toRegister()
            NavHostFragment.findNavController(this).navigate(action)
        }

    }

    override fun observe() {

    }

}