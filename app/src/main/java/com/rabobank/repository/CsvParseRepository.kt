package com.rabobank.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.io.BufferedReader
import java.io.InputStreamReader
import android.content.Context
import com.rabobank.parser.CsvParser


class CsvParseRepository(private val applicationContext: Context) {

    private val parseMutableLiveData = MutableLiveData<String>()

    val parseLiveData: LiveData<String>
        get() = parseMutableLiveData

    suspend fun getParseData() {
        parseMutableLiveData.postValue(CsvParser(applicationContext).parseRow());
    }
}


