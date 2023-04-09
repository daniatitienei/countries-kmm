package com.ad_coding.countrieskmm.presentation.countries

import com.ad_coding.countrieskmm.domain.core.util.toCommonStateFlow
import com.ad_coding.countrieskmm.domain.repository.CountryClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.DisposableHandle
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CountriesViewModel(
    private val countryClient: CountryClient,
    private val coroutineScope: CoroutineScope? = null
) {
    private val viewModelScope = coroutineScope ?: CoroutineScope(Dispatchers.Main)

    private val _state = MutableStateFlow(CountriesState())
    val state = _state.toCommonStateFlow()

    init {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true
                )
            }

            _state.update {
                it.copy(
                    countries = countryClient.getCountries(),
                    isLoading = false
                )
            }
        }
    }
}