package com.ad_coding.countrieskmm.presentation.countries

import com.ad_coding.countrieskmm.domain.model.SimpleCountry

data class CountriesState(
    val countries: List<SimpleCountry> = emptyList(),
    val isLoading: Boolean = false
)
