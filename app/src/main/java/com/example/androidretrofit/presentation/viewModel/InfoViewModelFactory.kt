package com.example.androidretrofit.presentation.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class InfoViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(InfoViewModel::class.java)) {
            return InfoViewModel(context) as T
        }
        throw IllegalArgumentException("")
    }
}