package com.erfka.nizek.user.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment


abstract class BaseFragmentWithDataBinding<T : ViewDataBinding>(@LayoutRes private val layoutResId: Int) :
    Fragment() {

    private var _binding: T? = null
    val binding: T get() = _binding!!

    open fun T.initialize() {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, layoutResId, container, false)

        binding.lifecycleOwner = viewLifecycleOwner

        binding.initialize()

        setupViews()
        observe()

        return binding.root
    }

    override fun onPause() {
        super.onPause()
        if (isRemoving)
            _binding?.unbind()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding?.unbind()
        _binding = null
    }

    abstract fun setupViews()

    open fun observe() {

    }

}