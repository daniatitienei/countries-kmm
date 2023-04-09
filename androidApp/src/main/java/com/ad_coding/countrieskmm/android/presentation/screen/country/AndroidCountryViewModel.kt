package com.ad_coding.countrieskmm.android.presentation.screen.country

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ad_coding.countrieskmm.domain.repository.CountryClient
import com.ad_coding.countrieskmm.presentation.country.CountryViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AndroidCountryViewModel @Inject constructor(
    private val countryClient: CountryClient,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val viewModel by lazy {
        CountryViewModel(
            countryClient = countryClient,
            coroutineScope = viewModelScope,
            countryCode = savedStateHandle.get<String>("id").orEmpty()
        )
    }

    val state = viewModel.state
}