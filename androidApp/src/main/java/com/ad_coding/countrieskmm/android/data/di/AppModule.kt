package com.ad_coding.countrieskmm.android.data.di

import com.ad_coding.countrieskmm.data.repository.ApolloCountryClient
import com.ad_coding.countrieskmm.domain.repository.CountryClient
import com.apollographql.apollo3.ApolloClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient =
        ApolloClient
            .Builder()
            .serverUrl("https://countries.trevorblades.com/graphql")
            .build()

    @Provides
    @Singleton
    fun provideCountryClient(apolloClient: ApolloClient): CountryClient =
        ApolloCountryClient(
            apolloClient = apolloClient
        )
}