package com.example.appsuperzound.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.appsuperzound.data.local.AppSuperZoundDao
import com.example.appsuperzound.data.local.AppSuperZoundEntity
import com.example.appsuperzound.data.model.SuperZound
import com.example.appsuperzound.data.remote.AppSuperZoundResponse
import com.example.appsuperzound.data.remote.AppSuperZoundService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SuperZoundRepository(
    private val appSuperZoundService: AppSuperZoundService,
    private val appSuperZoundDao: AppSuperZoundDao) {

        private val _superHeroes = MutableLiveData<List<SuperZound>>(emptyList())
        val superHeroes get() = _superHeroes
        fun fetchByName(name: String){
            val fetchByName =  appSuperZoundService.getAllAlbums("album")

            fetchByName.enqueue(object : Callback<AppSuperZoundResponse> { //
                override fun onResponse(
                    call: Call<AppSuperZoundResponse>,
                    response: Response<AppSuperZoundResponse>
                ) {
                    if (response.isSuccessful){
                        if (response.body()!!.loved == null){
                            _superHeroes.value = emptyList()
                        }else{
                            _superHeroes.value = response.body()!!.loved!!
                            for(superHero in _superHeroes.value!!){
                                superHero.favorite = appSuperZoundDao.fetchById(superHero.id).isNotEmpty()
                            }
                        }


                    }

                }

                override fun onFailure(call: Call<AppSuperZoundResponse>, t: Throwable) {
                    Log.d("SuperHeroRepository", t.message.toString())
                }

            })
        }



    fun insert(superZound: SuperZound){
        val superHeroEntity = AppSuperZoundEntity(superZound.id,superZound.strAlbum,superZound.strArtist,superZound.strAlbumThumb,superZound.intYearReleased,superZound.strGenre,superZound.strAlbum3DCase)
        appSuperZoundDao.insertProduct(superHeroEntity)
        superZound.favorite = true
    }

    fun delete(superZound: SuperZound){
        val superHeroEntity = AppSuperZoundEntity(superZound.id,superZound.strAlbum,superZound.strArtist,superZound.strAlbumThumb,superZound.intYearReleased,superZound.strGenre,superZound.strAlbum3DCase)
        appSuperZoundDao.delete(superHeroEntity)
        superZound.favorite = false
    }
}