package com.nikitin.githubsearchchallenge.di.component

import android.app.Application
import com.nikitin.core.di.module.CoreModule
import com.nikitin.datasource.di.module.DatasourceModule
import com.nikitin.githubsearchchallenge.MyApplication
import com.nikitin.githubsearchchallenge.di.module.*
import com.nikitin.ui_second_feature.di.module.SecondFeatureModule
import com.nikitin.ui_first_feature.di.module.FirstFeatureModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

//: change first feature module name
//: change second feature module name
@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
        DatasourceModule::class,
        AppModule::class,
        CoreModule::class,
        MainBindingModule::class,
        FirstFeatureModule::class,
        SecondFeatureModule::class]
)
interface AppComponent : AndroidInjector<MyApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }
}