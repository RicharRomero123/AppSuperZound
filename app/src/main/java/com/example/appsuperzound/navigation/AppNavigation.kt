package com.example.appsuperzound.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appsuperzound.data.local.AppSuperZoundDao
import com.example.appsuperzound.ui.screens.FavouriteAlbum.FavoriteAlbum
import com.example.appsuperzound.ui.screens.Home.Home
import com.example.appsuperzound.ui.screens.ListAlbum.ListAlbum
import com.example.appsuperzound.ui.screens.SuperZoundViewModel

@Composable
fun AppNavigation(appSuperZoundDao: AppSuperZoundDao,viewModel: SuperZoundViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.Home.route, builder = {
        composable(route = AppScreens.FavouriteAlbum.route){
            FavoriteAlbum(appSuperZoundDao, viewModel)
        }
        composable(route = AppScreens.ListAlbum.route){
            ListAlbum(viewModel)
        }
        composable(route = AppScreens.Home.route){
            Home(navController)
        }
    })

}