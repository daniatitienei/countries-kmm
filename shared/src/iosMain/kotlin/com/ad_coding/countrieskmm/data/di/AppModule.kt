package com.ad_coding.countrieskmm.data.di

import com.ad_coding.countrieskmm.data.repository.ApolloCountryClient
import com.apollographql.apollo3.ApolloClient

class AppModule {
    private val apolloClient = ApolloClient
        .Builder()
        .serverUrl("https://countries.trevorblades.com/graphql")
        .build()

    val countryClient = ApolloCountryClient(
        apolloClient = apolloClient
    )
}