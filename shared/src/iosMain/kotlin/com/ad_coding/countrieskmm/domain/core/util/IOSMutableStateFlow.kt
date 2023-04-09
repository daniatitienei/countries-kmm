package com.ad_coding.countrieskmm.domain.core.util

import com.ad_coding.countrieskmm.domain.core.util.CommonMutableStateFlow
import kotlinx.coroutines.flow.MutableStateFlow

class IOSMutableStateFlow<T>(
    initialValue: T
) : CommonMutableStateFlow<T>(MutableStateFlow(initialValue))