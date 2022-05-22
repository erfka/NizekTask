package com.erfka.nizek.user.presentation


import androidx.navigation.fragment.NavHostFragment
import com.erfka.nizek.user.R
import com.erfka.nizek.user.databinding.FragmentRegisterBinding

class RegisterFragment :
    BaseFragmentWithDataBinding<FragmentRegisterBinding>(R.layout.fragment_register) {

    override fun setupViews() {
        binding.tvToLogin.setOnClickListener {
            val action = RegisterFragmentDirections.toLogin()
            NavHostFragment.findNavController(this).navigate(action)
        }
    }

    override fun observe() {

    }

}