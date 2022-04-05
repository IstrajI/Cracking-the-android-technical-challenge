package com.nikitin.datasource.search.remote.source

import com.nikitin.core.search.model.DomainModel

interface RemoteDataSource {
    suspend fun searchRepository(name: String): Result<DomainModel>
}