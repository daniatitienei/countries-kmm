//
//  CountryViewModel.swift
//  iosApp
//
//  Created by Atitienei Daniel on 09.04.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared

extension CountryScreen {
    
    @MainActor class IOSCountryViewModel: ObservableObject {
        
        private var viewModel: CountryViewModel
        
        private var countryClient: CountryClient

        @Published var state: CountryState = CountryState(
            country: nil,
            isLoading: false
        )
        
        init(countryClient: CountryClient, countryCode: String) {
            self.countryClient = countryClient
            self.viewModel = CountryViewModel(
                countryCode: countryCode,
                countryClient: countryClient,
                coroutineScope: nil
            )
        }
        
        var handle: DisposableHandle? = nil
        
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
