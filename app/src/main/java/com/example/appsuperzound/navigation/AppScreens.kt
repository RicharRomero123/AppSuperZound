package com.example.appsuperzound.navigation

sealed class AppScreens(val route: String){
    object FavouriteAlbum: AppScreens("FavoriteAlbum")
    object ListAlbum: AppScreens("ListAlbum")
    object Home: AppScreens("Home")
}
