package com.rabobank.parser

import android.content.Context
import androidx.lifecycle.MutableLiveData
import java.io.BufferedReader
import java.io.InputStreamReader

class CsvParser(private val applicationContext: Context) {

    ///val parseMutableLiveData = MutableLiveData<String>()

    fun parseRow() : String
    {
        var displayData : String = ""
        var line: String?
        val bufferedReader = BufferedReader(InputStreamReader(applicationContext.assets.open("issues.csv")))

        do {
            line = bufferedReader.readLine()
            if (line != null) {
                val row : List<String> = line!!.split(",")
                displayData = displayData + row[0] + "\t" + row[1] + row[2] + "\t" + row[3] + "\n"
            }
        } while (line != null)
       // parseMutableLiveData.postValue(displayData)

        return displayData
    }
}