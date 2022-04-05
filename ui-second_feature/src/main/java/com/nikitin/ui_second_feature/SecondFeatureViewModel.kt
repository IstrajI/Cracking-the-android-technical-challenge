package com.nikitin.ui_second_feature

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nikitin.ui_components.navigation.models.SecondFeatureNavArgs
import javax.inject.Inject

class SecondFeatureViewModel @Inject constructor() : ViewModel() {
    private val _testData =
        MutableLiveData<Int>()
    var testData: LiveData<Int> = _testData
    fun setFeatureArguments(navArgs: SecondFeatureNavArgs) {
        _testData.value = navArgs.arg
    }
}