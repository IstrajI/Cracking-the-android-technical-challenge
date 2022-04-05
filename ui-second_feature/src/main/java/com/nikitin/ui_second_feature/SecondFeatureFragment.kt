package com.nikitin.ui_second_feature

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.nikitin.base.BaseFeatureFragment
import com.nikitin.ui_components.navigation.models.SecondFeatureNavArgs
import com.nikitin.ui_second_feature.databinding.FragmentSecondFeatureBinding

class SecondFeatureFragment: BaseFeatureFragment<FragmentSecondFeatureBinding>() {
    private val viewModel by viewModels<SecondFeatureViewModel> { viewModelFactory }
    override val bindingInflater =
        { layoutInflater: LayoutInflater, viewGroup: ViewGroup?, attachToParent: Boolean ->
            FragmentSecondFeatureBinding.inflate(
                layoutInflater,
                viewGroup,
                attachToParent
            )
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val featureArgs = SecondFeatureNavArgs.fromBundle(it)
            viewModel.setFeatureArguments(featureArgs)
        }
    }
}