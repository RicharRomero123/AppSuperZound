package com.example.appsuperzound.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity("SuperZound")
data class AppSuperZoundEntity(
    @PrimaryKey()
    val id: String,
    @ColumnInfo("strAlbum")
    val strAlbum: String,
    @ColumnInfo("strArtist")
    val strArtist: String,
    @ColumnInfo("strAlbumThumb")
    val strAlbumThumb: String,
    @ColumnInfo("intYearReleased")
    val intYearReleased: String,
    @ColumnInfo("strGenre")
    val strGenre: String,
    @ColumnInfo("strAlbum3DCase")
    val strAlbum3DCase: String,
)
