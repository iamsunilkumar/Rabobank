package com.rabobank.activity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cheezycode.randomquote.viewmodels.MainViewModelFactory
import com.rabobank.ParseApplication
import com.rabobank.R
import com.rabobank.viewmodels.MainViewModel

class MainActivity : BaseActivity() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var txtData = findViewById<TextView>(R.id.data)
        val repository = (application as ParseApplication).csvParseRepository
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.parsedata.observe(this, Observer {
            txtData.text = it
        })
    }
}