package com.ad_coding.countrieskmm.presentation.country

import com.ad_coding.countrieskmm.domain.core.util.toCommonStateFlow
import com.ad_coding.countrieskmm.domain.repository.CountryClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CountryViewModel(
    private val countryCode: String,
    private val countryClient: CountryClient,
    private val coroutineScope: CoroutineScope? = null
) {

    private val viewModelScope = coroutineScope ?: CoroutineScope(Dispatchers.Main)

    private val _state = MutableStateFlow(CountryState())
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
                    country = countryClient.getCountry(countryCode),
                    isLoading = false
                )
            }
        }
    }
}