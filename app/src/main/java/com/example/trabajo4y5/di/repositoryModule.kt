package com.example.trabajo4y5.di



import com.example.trabajo4y5.repository.NewsRepositoryImp
import com.example.trabajo4y5.repository.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun newsRepository(repositoryImp: NewsRepositoryImp): NewsRepository
}