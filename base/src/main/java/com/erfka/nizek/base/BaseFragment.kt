package com.erfka.nizek.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding>() : Fragment() {

    private var _binding: VB? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = getViewBinding(inflater, container)

        setupViews()
        observe()

        return _binding?.root
    }

    abstract fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): VB

    abstract fun setupViews()

    open fun observe() {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun hideKeyboardFrom(context: Context, view: View) {
        val imm: InputMethodManager =
            context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

}