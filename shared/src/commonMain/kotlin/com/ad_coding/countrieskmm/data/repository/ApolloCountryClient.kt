package com.ad_coding.countrieskmm.data.repository

import com.ad_coding.CountriesQuery
import com.ad_coding.CountryQuery
import com.ad_coding.countrieskmm.data.mapper.toDetailedCountry
import com.ad_coding.countrieskmm.data.mapper.toSimpleCountry
import com.ad_coding.countrieskmm.domain.model.DetailedCountry
import com.ad_coding.countrieskmm.domain.model.SimpleCountry
import com.ad_coding.countrieskmm.domain.repository.CountryClient
import com.apollographql.apollo3.ApolloClient

class ApolloCountryClient(
    private val apolloClient: ApolloClient
) : CountryClient {

    override suspend fun getCountries(): List<SimpleCountry> =
        apolloClient
            .query(CountriesQuery())
            .execute()
            .data
            ?.countries
            ?.map { it.toSimpleCountry() }
            .orEmpty()


    override suspend fun getCountry(code: String): DetailedCountry? =
        apolloClient
            .query(CountryQuery(code))
            .execute()
            .data
            ?.country
            ?.toDetailedCountry()

}