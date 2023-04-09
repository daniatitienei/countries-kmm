package com.ad_coding.countrieskmm.presentation.country

import com.ad_coding.countrieskmm.domain.model.DetailedCountry

data class CountryState(
    val country: DetailedCountry? = null,
    val isLoading: Boolean = false
)
