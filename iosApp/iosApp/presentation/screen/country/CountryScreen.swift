//
//  CountryScreen.swift
//  iosApp
//
//  Created by Atitienei Daniel on 09.04.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct CountryScreen: View {
    
    private var countryCode: String
    private var countryClient: CountryClient
    @ObservedObject private var viewModel: IOSCountryViewModel
    
    init(countryCode: String, countryClient: CountryClient) {
        self.countryCode = countryCode
        self.countryClient = countryClient
        self.viewModel = IOSCountryViewModel(
            countryClient: countryClient,
            countryCode: countryCode
        )
    }
    
    var body: some View {
        VStack {
            let country = viewModel.state.country
    
            Text(country?.emoji ?? "")
            Text(country?.name ?? "")
            Text(country?.capital ?? "")
            Text(country?.currency ?? "")
            Text(country?.continent ?? "")
            
            ForEach(country?.languages ?? [], id: \.count) { language in
                Text(language)
            }
        }
        .padding(.horizontal)
        .padding(.vertical)
        .onAppear {
            viewModel.startObserving()
        }
        .onDisappear {
            viewModel.dispose()
        }
    }
}
