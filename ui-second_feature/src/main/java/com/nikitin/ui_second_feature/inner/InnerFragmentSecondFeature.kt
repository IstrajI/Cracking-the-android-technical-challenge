package com.nikitin.ui_second_feature.inner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.nikitin.base.BaseFragment
import com.nikitin.extensions.requireGrandParentFragment
import com.nikitin.ui_second_feature.SecondFeatureViewModel
import com.nikitin.ui_second_feature.databinding.FragmentSecondFeatureInnerBinding

class InnerFragmentSecondFeature : BaseFragment<FragmentSecondFeatureInnerBinding>() {
    private val viewModel by viewModels<SecondFeatureViewModel> { viewModelFactory }
    private val featureViewModel by viewModels<SecondFeatureViewModel>({ requireGrandParentFragment() }) { viewModelFactory }
    override val bindingInflater =
        { layoutInflater: LayoutInflater, viewGroup: ViewGroup?, attachToParent: Boolean ->
            FragmentSecondFeatureInnerBinding.inflate(
                layoutInflater,
                viewGroup,
                attachToParent
            )
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        featureViewModel.testData.observe(viewLifecycleOwner) {
            binding.textView.text = it.toString()
        }
    }
}