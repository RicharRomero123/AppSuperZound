package com.example.appsuperzound.data.model

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class SuperZound(
    @SerializedName("idAlbum")
    val id: String,
    // List Album
    @SerializedName("strArtist")
    val strArtist: String,
    @SerializedName("strAlbumThumb")
    val strAlbumThumb: String,
    @SerializedName("intYearReleased")
    val intYearReleased: String,
    var favorite: Boolean,
    //Favorite
    @SerializedName("strGenre")
    val strGenre: String,
    @SerializedName("strAlbum3DCase")
    val strAlbum3DCase: String,
    @SerializedName("strAlbum")
    val strAlbum: String,
)