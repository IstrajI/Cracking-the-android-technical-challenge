package com.nikitin.ui_first_feature.di.module

import androidx.lifecycle.ViewModel
import com.nikitin.core.di.keys.ViewModelKey
import com.nikitin.ui_first_feature.FirstFeatureFragment
import com.nikitin.ui_first_feature.FirstFeatureViewModel
import com.nikitin.ui_first_feature.di.scope.FirstFeatureScope
import com.nikitin.ui_first_feature.inner.InnerFirstFeatureFragment
import com.nikitin.ui_first_feature.inner.InnerFirstViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class FirstFeatureModule {

    @FirstFeatureScope
    @ContributesAndroidInjector
    abstract fun firstFeatureFragment(): FirstFeatureFragment

    @Binds
    @IntoMap
    @ViewModelKey(FirstFeatureViewModel::class)
    abstract fun firstFeatureViewModel(firstFeatureViewModel: FirstFeatureViewModel): ViewModel

    @FirstFeatureScope
    @ContributesAndroidInjector
    abstract fun aInnerFirstFeatureFragment(): InnerFirstFeatureFragment

    @Binds
    @IntoMap
    @ViewModelKey(InnerFirstViewModel::class)
    abstract fun aInnerFirstViewModel(InnerFirstViewModel: InnerFirstViewModel): ViewModel
}