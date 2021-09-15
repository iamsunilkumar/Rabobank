package com.rabobank

import android.app.Application
import com.rabobank.repository.CsvParseRepository

class ParseApplication : Application() {

    lateinit var csvParseRepository: CsvParseRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        csvParseRepository = CsvParseRepository(applicationContext)
    }
}