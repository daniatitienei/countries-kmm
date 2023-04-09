@file:OptIn(ExperimentalAnimationApi::class, ExperimentalMaterial3Api::class)

package com.ad_coding.countrieskmm.android.presentation.screen.countries

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ad_coding.countrieskmm.presentation.countries.CountriesState

@Composable
fun CountriesScreen(
    state: CountriesState,
    onCountryClick: (String) -> Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { 
                    Text(text = "Countries")
                }
            )
        }
    ) { padding ->
        AnimatedContent(targetState = state.isLoading, label = "Loading") { isLoading ->
            if (isLoading) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            } else {
                LazyColumn(
                    contentPadding = PaddingValues(
                        top = padding.calculateTopPadding() + 10.dp,
                        bottom = padding.calculateBottomPadding() + 10.dp,
                        start = 20.dp,
                        end = 20.dp
                    )
                ) {
                    items(state.countries) { country ->
                        ListItem(
                            headlineContent = {
                                Text(text = country.name)
                            },
                            supportingContent = {
                                Text(text = country.capital)
                            },
                            leadingContent = {
                                Text(text = country.emoji)
                            },
                            trailingContent = {
                                Text(text = country.code)
                            },
                            modifier = Modifier.clickable {
                                onCountryClick(country.code)
                            }
                        )
                    }
                }
            }
        }
    }
}