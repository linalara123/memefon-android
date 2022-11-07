package com.demoapp.memefon.di

import com.demoapp.memefon.data.MemefonDataSource
import com.demoapp.memefon.data.MemefonLocalDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataSourceModule {
    @Binds
    abstract fun bindMemefonDataSource(
        memefonDataSource: MemefonLocalDataSource
    ): MemefonDataSource
}