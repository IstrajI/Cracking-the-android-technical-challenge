package com.nikitin.ui_first_feature.inner

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nikitin.domain.search.Interactor
import com.nikitin.ui_first_feature.mapper.DomainModelToUIModelMapper
import com.nikitin.ui_first_feature.model.UIModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class InnerFirstViewModel @Inject constructor(
    private val interactor: Interactor,
    private val domainModelToUIModelMapper: DomainModelToUIModelMapper
) : ViewModel() {
    private val _testValue =
        MutableLiveData<UIModel>()
    var testValue: LiveData<UIModel> = _testValue

    private val _isLoading =
        MutableLiveData<Boolean>()
    var isLoading: LiveData<Boolean> = _isLoading

    private val _error =
        MutableLiveData<String?>()
    var error: LiveData<String?> = _error

    fun performAction(input: String) = viewModelScope.launch(Dispatchers.IO) {
        val result = interactor.doAction(testInput = input)
        result.fold(onSuccess = {
            val data =
                domainModelToUIModelMapper.mapUIModel(it)
            _testValue.postValue(data)
        }, onFailure = {
            _error.postValue(it.message)
        })
        _isLoading.postValue(false)
    }

    fun setErrorShown() {
        _error.value = null
    }
}