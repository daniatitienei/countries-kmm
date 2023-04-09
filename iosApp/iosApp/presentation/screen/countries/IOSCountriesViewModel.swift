//
//  IOSCountriesViewModel.swift
//  iosApp
//
//  Created by Atitienei Daniel on 09.04.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared

extension CountriesScreen {
    
    @MainActor class IOSCountriesViewModel: ObservableObject {
        private var viewModel: CountriesViewModel
        
        private var countryClient: CountryClient
        
        @Published var state: CountriesState = CountriesState(
            countries: [],
            isLoading: false
        )
        
        init(countryClient: CountryClient) {
            self.countryClient = countryClient
            self.viewModel = CountriesViewModel(
                countryClient: countryClient,
                coroutineScope: nil
            )
        }
        
        private var handle: DisposableHandle?
        
        func startObserving() {
            handle = viewModel.state.subscribe { state in
                if let state {
                    self.state = state
                }
            }
        }
        
        func dispose() {
            handle?.dispose()
        }
    }
}
