package com.rabobank.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rabobank.repository.CsvParseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel (private val repository: CsvParseRepository) : ViewModel()
{
    init {
        viewModelScope.launch(Dispatchers.IO){
            repository.getParseData()
        }
    }
    val parsedata : LiveData<String>
    get() = repository.parseLiveData
}