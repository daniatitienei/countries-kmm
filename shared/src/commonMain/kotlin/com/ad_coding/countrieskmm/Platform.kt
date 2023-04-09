package com.ad_coding.countrieskmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform