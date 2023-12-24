package com.example.androidretrofit.presentation.viewModel

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidretrofit.data.api.ApiService
import com.example.androidretrofit.data.db.AppDatabase
import com.example.androidretrofit.data.db.InfoDao
import com.example.androidretrofit.data.db.InfoEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InfoViewModel @Inject constructor() : ViewModel() {
    var infoListResponse: List<InfoEntity> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")

    private lateinit var infoDao: InfoDao

    fun initialize(context: Context) {
        infoDao = AppDatabase.getInstance(context).infoDao()
    }
    fun getInfoList() {
        viewModelScope.launch {
            try {
                infoListResponse = infoDao.getInfo()

                if (infoListResponse.isEmpty()) {
                    val apiService = ApiService.getInstance()
                    val infoFromApi = apiService.getInfo()

                    val infoEntities = infoFromApi.map {
                        InfoEntity(
                            title = it.title,
                            desc = it.desc,
                            image = it.image,
                            tag = it.tag,
                            category = it.category,
                            author = it.author,
                            date = it.date
                        )
                    }
                    infoDao.insertInfo(infoEntities)

                    infoListResponse = infoEntities
                }
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}