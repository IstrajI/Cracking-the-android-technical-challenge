package com.nikitin.ui_components.navigation.models

import android.os.Bundle
class SecondFeatureNavArgs(val arg: Int) {
    companion object {
        const val ARG = "arg_name"
        fun fromBundle(bundle: Bundle): SecondFeatureNavArgs {
            val arg = bundle.getString(ARG, "0").toInt()
            return SecondFeatureNavArgs(arg)
        }
    }
}