package com.ad_coding.countrieskmm.domain.model

data class DetailedCountry(
    val name: String,
    val code: String,
    val emoji: String,
    val capital: String,
    val currency: String,
    val languages: List<String>,
    val continent: String
)