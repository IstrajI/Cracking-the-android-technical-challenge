package com.nikitin.domain.search

import com.nikitin.datasource.search.remote.source.RemoteDataSource
import com.nikitin.core.search.model.DomainModel
import javax.inject.Inject

class Interactor @Inject constructor(private val remoteDataSource: RemoteDataSource) {
    suspend fun doAction(testInput: String): Result<DomainModel> {
        return remoteDataSource.searchRepository(name = testInput)
    }
}