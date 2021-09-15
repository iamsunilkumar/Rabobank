package com.cheezycode.randomquote.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rabobank.repository.CsvParseRepository
import com.rabobank.viewmodels.MainViewModel

class MainViewModelFactory(private val repository: CsvParseRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}