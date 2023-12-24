package com.example.androidretrofit.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.androidretrofit.data.db.InfoEntity
import com.example.androidretrofit.data.db.toInfo
import com.example.androidretrofit.presentation.viewModel.InfoViewModel
import com.example.androidretrofit.presentation.viewModel.InfoViewModelFactory
import com.example.androidretrofit.ui.theme.AndroidRetrofitTheme

class MainActivity : ComponentActivity() {
    private val movieViewModel by viewModels<InfoViewModel> { InfoViewModelFactory(this) }
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidRetrofitTheme {
                val navController = rememberNavController()

                Scaffold(
                    content = {
                        InfoList(movieList = movieViewModel.infoListResponse)
                        movieViewModel.getInfoList()
                    },
                    bottomBar = {
                        BottomBar(navController = navController)
                    }
                )
            }
        }
    }
}

@Composable
fun InfoList(movieList: List<InfoEntity>) {
    val navController = rememberNavController()

    LazyColumn {
        itemsIndexed(items = movieList) { index, item ->
            InfoItem(movie = item.toInfo())
        }
    }
}