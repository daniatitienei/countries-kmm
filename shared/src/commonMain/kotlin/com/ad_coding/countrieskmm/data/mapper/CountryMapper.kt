package com.ad_coding.countrieskmm.data.mapper

import com.ad_coding.CountriesQuery
import com.ad_coding.CountryQuery
import com.ad_coding.countrieskmm.domain.model.DetailedCountry
import com.ad_coding.countrieskmm.domain.model.SimpleCountry

fun CountryQuery.Country.toDetailedCountry(): DetailedCountry =
    DetailedCountry(
        code = code,
        name = name,
        emoji = emoji,
        continent = continent.name,
        capital = capital ?: "No capital",
        currency = currency ?: "No currency",
        languages = languages.map { it.name },
    )

fun CountriesQuery.Country.toSimpleCountry(): SimpleCountry =
    SimpleCountry(
        name = name,
        code = code,
        emoji = emoji,
        capital = capital ?: "No capital",
    )