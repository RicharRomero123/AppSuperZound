package com.example.appsuperzound.ui.screens.FavouriteAlbum

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.appsuperzound.data.local.AppSuperZoundDao
import com.example.appsuperzound.data.model.SuperZound
import com.example.appsuperzound.ui.screens.SuperZoundViewModel


@Composable
fun FavoriteAlbum(appSuperZoundDao: AppSuperZoundDao, viewModel: SuperZoundViewModel){


    Row {
        FavoriteList(appSuperZoundDao, viewModel)
    }
    Spacer(modifier = Modifier.padding(4.dp))

}



@Composable
fun FavoriteList(appSuperZoundDao: AppSuperZoundDao, viewModel: SuperZoundViewModel){
    val albums = remember { mutableStateListOf<SuperZound>() }
    Column() {
        Text(text = "FAVOURITE ALBUMS",textAlign = TextAlign.Center,modifier = Modifier.fillMaxWidth())
        val tasks = appSuperZoundDao.getAll()
        LazyColumn{
            items(tasks){step->
                FavouriteCard(step.strAlbum3DCase,step.strAlbum ,step.strGenre, deleteHero = {

                })
            }
        }
    }

}

@Composable
fun FavouriteCard(strAlbum3DCase: String, strAlbum: String, strGenre: String,deleteHero: () -> Unit, modifier: Modifier = Modifier) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Row {
            FavouriteImage(strAlbum3DCase)
            FavouriteRow(strAlbum,strGenre,deleteHero)
        }
    }
}


@Composable
fun FavouriteRow(strAlbum: String, strGenre: String, deleteHero: () -> Unit,modifier: Modifier = Modifier){

    Row {
        Spacer(modifier = modifier.width(8.dp))
        Column(modifier = modifier.weight(7f)) {
            Text(text = strAlbum)
            Text(text = strGenre)
        }
        IconButton(
            modifier = modifier.weight(1f),
            onClick = {
                deleteHero()
            }) {
            Icon(
                Icons.Filled.Clear,
                contentDescription = null,
            )
        }
    }
}


@Composable
fun FavouriteImage(strAlbum3DCase: String, modifier: Modifier = Modifier){
    AsyncImage(model = strAlbum3DCase, contentDescription = null,
        modifier = Modifier.size(width = 50.dp, height = 25.dp))
}