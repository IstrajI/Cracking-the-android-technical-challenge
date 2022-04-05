package com.nikitin.datasource.search.remote.source

import com.nikitin.datasource.network.API
import com.nikitin.datasource.search.remote.mapper.DataToDomainMapper
import com.nikitin.core.search.model.DomainModel
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSourceImpl @Inject constructor(
    private val api: API,
    private val dataToDomainMapper: DataToDomainMapper
) : RemoteDataSource {
    override suspend fun searchRepository(name: String): Result<DomainModel> {
        val response = api.makeGet(name)
        val body = response.body()

        return try {
            if (response.isSuccessful && body!= null) {
                Result.success(dataToDomainMapper.toWhat(body))
            } else {
                Result.failure(Exception(response.errorBody()?.string()?:""))
            }
        } catch (exception: IOException) {
            Result.failure(exception)
        }
    }
}