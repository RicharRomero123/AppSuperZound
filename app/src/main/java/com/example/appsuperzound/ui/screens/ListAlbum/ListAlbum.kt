package com.example.appsuperzound.ui.screens.ListAlbum

import android.widget.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.appsuperzound.data.model.SuperZound
import com.example.appsuperzound.data.remote.AppSuperZoundClient
import com.example.appsuperzound.data.remote.AppSuperZoundResponse
import com.example.appsuperzound.ui.screens.SuperZoundViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun ListAlbum(viewModel: SuperZoundViewModel,modifier: Modifier = Modifier){


    val albums = remember { mutableStateListOf<SuperZound>() }
    var albumService = AppSuperZoundClient.AppSuperZoundService()
    val response = albumService.getAllAlbums("album")

    response.enqueue(object : Callback<AppSuperZoundResponse>{
        override fun onResponse(
            call: Call<AppSuperZoundResponse>,
            response: Response<AppSuperZoundResponse>
        ) {
            if (response.isSuccessful){
                albums.addAll(response.body()!!.loved)
            }
        }

        override fun onFailure(call: Call<AppSuperZoundResponse>, t: Throwable) {
            TODO("Not yet implemented")
        }

    })

    Column() {
        Text(text = "LIST ALBUM",textAlign = TextAlign.Center,modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.padding(vertical = 8.dp))
        LazyColumn(modifier = modifier) {
            items(albums) {album->
                ListAlbumCard(album, insertHero = { viewModel.insert(album) }, deleteHero = {
                    viewModel.delete(album)
                })
            }
        }
    }

}

@Composable
fun ListAlbumCard(SuperZound: SuperZound,
                  insertHero: () -> Unit,
                  deleteHero: () -> Unit,
                  modifier: Modifier = Modifier
){
    val isFavorite = remember {
        mutableStateOf(false)
    }
    isFavorite.value = SuperZound.favorite

    Card(modifier = modifier
        .fillMaxSize()
        .padding(4.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            AlbumImage(SuperZound)
            AlbumItem(SuperZound)
        }
        IconButton(

            onClick = {
                if (isFavorite.value) { //TRUE
                    deleteHero()
                } else {
                   insertHero()
                }
                isFavorite.value = !isFavorite.value
            },modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Icon(
                Icons.Filled.Favorite,
                contentDescription = null,
                tint = if (isFavorite.value) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
            )
        }
    }
}


@Composable
fun AlbumImage(SuperZound: SuperZound ,modifier: Modifier = Modifier){
    AsyncImage(model = SuperZound.strAlbumThumb, contentDescription = null,
    modifier = Modifier.size(width = 50.dp, height = 25.dp))
}

@Composable
fun AlbumItem(SuperZound: SuperZound, modifier: Modifier = Modifier){
    Text(text = SuperZound.strAlbum + '|', textAlign = TextAlign.Center)
    Spacer(modifier = Modifier.padding(vertical = 8.dp))
    Text(text = SuperZound.strArtist+ '|', textAlign = TextAlign.Center)
    Spacer(modifier = Modifier.padding(vertical = 8.dp))
    Text(text = SuperZound.intYearReleased.toString(), textAlign = TextAlign.Center)

}