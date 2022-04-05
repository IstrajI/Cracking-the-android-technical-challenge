package com.nikitin.ui_second_feature.di.module

import androidx.lifecycle.ViewModel
import com.nikitin.core.di.keys.ViewModelKey
import com.nikitin.ui_second_feature.SecondFeatureFragment
import com.nikitin.ui_second_feature.SecondFeatureViewModel
import com.nikitin.ui_second_feature.di.scope.SecondFeatureScope
import com.nikitin.ui_second_feature.inner.InnerFragmentSecondFeature
import com.nikitin.ui_second_feature.inner.InnerFragmentSecondFeatureViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class SecondFeatureModule {
    @SecondFeatureScope
    @ContributesAndroidInjector
    abstract fun secondFeatureFragment(): SecondFeatureFragment

    @Binds
    @IntoMap
    @ViewModelKey(SecondFeatureViewModel::class)
    abstract fun secondFeatureViewModel(secondFeatureViewModel: SecondFeatureViewModel): ViewModel

    @SecondFeatureScope
    @ContributesAndroidInjector
    abstract fun innerFragmentSecondFeature(): InnerFragmentSecondFeature

    @Binds
    @IntoMap
    @ViewModelKey(InnerFragmentSecondFeatureViewModel::class)
    abstract fun innerFragmentSecondFeatureViewModel(innerFragmentSecondFeatureViewModel: InnerFragmentSecondFeatureViewModel): ViewModel
}