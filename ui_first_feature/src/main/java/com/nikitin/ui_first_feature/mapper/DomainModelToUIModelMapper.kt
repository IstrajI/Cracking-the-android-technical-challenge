package com.nikitin.ui_first_feature.mapper

import com.nikitin.core.search.model.DomainModel
import com.nikitin.ui_components.formatter.EmptyFormatter
import com.nikitin.ui_first_feature.model.UIModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DomainModelToUIModelMapper @Inject constructor(
    private val emptyFormatter: EmptyFormatter
) {
    fun mapUIModel(from: DomainModel): UIModel {
        return from.run {
            UIModel(
                testValue = totalCount
            )
        }
    }
}