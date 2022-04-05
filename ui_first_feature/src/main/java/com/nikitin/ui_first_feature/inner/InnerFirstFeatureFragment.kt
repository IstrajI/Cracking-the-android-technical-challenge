package com.nikitin.ui_first_feature.inner

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.nikitin.base.BaseFragment
import com.nikitin.extensions.requireGrandParentFragment
import com.nikitin.ui_first_feature.FirstFeatureFragment
import com.nikitin.ui_first_feature.FirstFeatureViewModel
import com.nikitin.ui_first_feature.databinding.FragmentFirstFeatureInnerBinding


class InnerFirstFeatureFragment : BaseFragment<FragmentFirstFeatureInnerBinding>() {
    private val viewModel by viewModels<InnerFirstViewModel> { viewModelFactory }
    private val featureViewModel by viewModels<FirstFeatureViewModel>({ requireGrandParentFragment() }) { viewModelFactory }
    override val bindingInflater =
        { layoutInflater: LayoutInflater, viewGroup: ViewGroup?, attachToParent: Boolean ->
            FragmentFirstFeatureInnerBinding.inflate(
                layoutInflater,
                viewGroup,
                attachToParent
            )
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initInput()
        initButton()
        initStates()
    }

    private fun initInput() {
        featureViewModel.searchQuery.observe(viewLifecycleOwner) {
            if (it.isNullOrEmpty()) return@observe
            viewModel.performAction(it)
        }
    }

    private fun initButton() {
        viewModel.testValue.observe(viewLifecycleOwner) {
            binding.button.isEnabled = true
        }
        binding.button.setOnClickListener {
            (requireGrandParentFragment() as FirstFeatureFragment).startSecondFeature(viewModel.testValue.value!!)
        }
    }

    private fun initStates() {
        viewModel.error.observe(viewLifecycleOwner) {
            if (it == null) return@observe
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            viewModel.setErrorShown()
        }

        viewModel.isLoading.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = it
        }
    }
}