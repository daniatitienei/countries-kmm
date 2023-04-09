package com.ad_coding.countrieskmm.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ad_coding.countrieskmm.android.presentation.screen.countries.AndroidCountriesViewModel
import com.ad_coding.countrieskmm.android.presentation.screen.countries.CountriesScreen
import com.ad_coding.countrieskmm.android.presentation.screen.country.AndroidCountryViewModel
import com.ad_coding.countrieskmm.android.presentation.screen.country.CountryScreen
import com.ad_coding.countrieskmm.android.presentation.util.Route
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = Route.countries
                ) {
                    composable(route = Route.countries) {
                        val viewModel = hiltViewModel<AndroidCountriesViewModel>()

                        val state by viewModel.state.collectAsState()

                        CountriesScreen(
                            state = state,
                            onCountryClick = {
                                navController.navigate(
                                    route = Route.country.replace("{id}", it)
                                )
                            }
                        )
                    }
                    composable(route = Route.country) {
                        val viewModel = hiltViewModel<AndroidCountryViewModel>()

                        val state by viewModel.state.collectAsState()

                        CountryScreen(
                            state = state,
                            navigateBack = {
                                navController.popBackStack()
                            }
                        )
                    }
                }
            }
        }
    }
}