package com.ad_coding.countrieskmm.domain.repository

import com.ad_coding.countrieskmm.domain.model.DetailedCountry
import com.ad_coding.countrieskmm.domain.model.SimpleCountry

interface CountryClient {
    suspend fun getCountries(): List<SimpleCountry>
    suspend fun getCountry(code: String): DetailedCountry?
}