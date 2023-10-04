package com.example.appsuperzound

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.appsuperzound.data.local.AppDataBase
import com.example.appsuperzound.data.local.AppSuperZoundDao
import com.example.appsuperzound.navigation.AppNavigation
import com.example.appsuperzound.ui.screens.FavouriteAlbum.FavoriteAlbum
import com.example.appsuperzound.ui.screens.ListAlbum.ListAlbum
import com.example.appsuperzound.ui.screens.SuperZoundViewModel
import com.example.appsuperzound.ui.theme.AppSuperZoundTheme

class MainActivity : ComponentActivity() {
    private lateinit var taskDao: AppSuperZoundDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppSuperZoundTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel: SuperZoundViewModel by viewModels()
                    val taskDatabase = AppDataBase.getInstance(applicationContext)
                    taskDao = taskDatabase.AppSuperZoundDao()
                    //ListAlbum(viewModel)
                    AppNavigation(taskDao, viewModel )
                    //FavoriteAlbum(taskDao, viewModel)
                }
            }
        }
    }
}
