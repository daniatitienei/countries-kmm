//
//  CountriesScreen.swift
//  iosApp
//
//  Created by Atitienei Daniel on 09.04.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct CountriesScreen: View {
    
    private var countryClient: CountryClient
    @ObservedObject private var viewModel: IOSCountriesViewModel
    
    init(countryClient: CountryClient) {
        self.countryClient = countryClient
        self.viewModel = IOSCountriesViewModel(countryClient: countryClient)
    }
    
    var body: some View {
        List {
            ForEach(self.viewModel.state.countries, id: \.code) { country in
                NavigationLink(destination: CountryScreen(
                    countryCode: country.code,
                    countryClient: countryClient
                )) {
                    HStack {
                        Text(country.emoji)
                        
                        VStack(alignment: .leading) {
                            Text(country.name)
                            Text(country.capital)
                                .font(.subheadline)
                        }
                        
                        Spacer()
                        
                        Text(country.code)
                    }
                }
            }
        }
        .navigationTitle("Countries")
        .onAppear {
            viewModel.startObserving()
        }
        .onDisappear {
            viewModel.dispose()
        }
    }
}
