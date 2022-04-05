package com.nikitin.ui_first_feature

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.nikitin.base.BaseFeatureFragment
import com.nikitin.ui_components.navigation.models.SecondFeatureNavArgs
import com.nikitin.ui_first_feature.databinding.FragmentFirstFeatureBinding
import com.nikitin.ui_first_feature.model.UIModel

class FirstFeatureFragment : BaseFeatureFragment<FragmentFirstFeatureBinding>() {
    private val viewModel by viewModels<FirstFeatureViewModel> { viewModelFactory }
    override val bindingInflater =
        { layoutInflater: LayoutInflater, viewGroup: ViewGroup?, attachToParent: Boolean ->
            FragmentFirstFeatureBinding.inflate(
                layoutInflater,
                viewGroup,
                attachToParent
            )
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("TestPish", "feature hash ${hashCode()}")
        initSearchView()
    }

    private fun initSearchView() {
        binding.inputView.setOnEditorActionListener(TextView.OnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                binding.inputView.clearFocus()
                val inputMethod =
                    requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethod.hideSoftInputFromWindow(binding.inputView.windowToken, 0)
                viewModel.setSearchQuery(binding.inputView.text.toString())
                return@OnEditorActionListener true
            }
            false
        })
    }

    fun startSecondFeature(params: UIModel) {
        val deeplink =             navigator.getSecondFeatureNavDeepLinkRequest(
            SecondFeatureNavArgs(params.testValue)
        )
        Log.d("TestPish", "deeplink ${deeplink}")
        requireParentFragment().findNavController().navigate(deeplink)
    }
}