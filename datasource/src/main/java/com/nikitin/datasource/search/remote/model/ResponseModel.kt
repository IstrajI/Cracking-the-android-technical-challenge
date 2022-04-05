package com.nikitin.datasource.search.remote.model

import com.google.gson.annotations.SerializedName

data class ResponseModel(
    @SerializedName("total_count") var totalCount: Int
)