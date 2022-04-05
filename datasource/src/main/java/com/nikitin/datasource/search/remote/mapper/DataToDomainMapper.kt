package com.nikitin.datasource.search.remote.mapper

import com.nikitin.core.search.model.DomainModel
import com.nikitin.datasource.search.remote.model.ResponseModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataToDomainMapper @Inject constructor() {
    fun toWhat(from: ResponseModel): DomainModel {
        return from.run {
            DomainModel(totalCount = totalCount)
        }
    }
}