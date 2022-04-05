package com.nikitin.ui_components

import android.util.Log
import androidx.core.net.toUri
import androidx.navigation.NavDeepLinkRequest
import com.nikitin.ui_components.navigation.models.SecondFeatureNavArgs
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DeepLinkNavigator @Inject constructor() {
    private val SECOND_FEATURE_DEEP_LINK = "deeplink://com.nikitin.githubsearchchallenge/details_feature_fragment"
    fun getSecondFeatureNavDeepLinkRequest(navArgs: SecondFeatureNavArgs): NavDeepLinkRequest {
        val deepLinkString = "$SECOND_FEATURE_DEEP_LINK?${SecondFeatureNavArgs.ARG}=${navArgs.arg}"
        return NavDeepLinkRequest.Builder
            .fromUri(deepLinkString.toUri())
            .build()
    }
}