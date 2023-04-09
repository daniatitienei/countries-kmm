package com.ad_coding.countrieskmm.android.presentation.screen.countries

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ad_coding.countrieskmm.domain.repository.CountryClient
import com.ad_coding.countrieskmm.presentation.countries.CountriesViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AndroidCountriesViewModel @Inject constructor(
    private val countryClient: CountryClient
) : ViewModel() {

    private val viewModel by lazy {
        CountriesViewModel(
            countryClient = countryClient,
            coroutineScope = viewModelScope
        )
    }

    val state = viewModel.state
}

