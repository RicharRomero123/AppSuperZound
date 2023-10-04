package com.example.appsuperzound.ui.screens.Home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.appsuperzound.R
import com.example.appsuperzound.navigation.AppScreens

@Composable
fun Home(navController: NavController){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Imagen de Branding
            AsyncImage(model = R.drawable.baseline_library_music_24, contentDescription =
                "Branding Image", modifier = Modifier.size(200.dp)
            )

            // Espacio entre la imagen y los botones
            Spacer(modifier = Modifier.height(16.dp))

            // Botones
            Button(
                onClick = { navController.navigate(AppScreens.ListAlbum.route) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("List Album")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { navController.navigate(AppScreens.FavouriteAlbum.route)},
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Favourites Album")
            }
        }
    }
}