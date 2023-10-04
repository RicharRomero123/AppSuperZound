package com.example.appsuperzound.ui.screens

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.appsuperzound.data.local.AppDataBase
import com.example.appsuperzound.data.model.SuperZound
import com.example.appsuperzound.data.remote.AppSuperZoundClient
import com.example.appsuperzound.repository.SuperZoundRepository

class SuperZoundViewModel(application: Application): AndroidViewModel(application) {
    private var superHeroService = AppSuperZoundClient.AppSuperZoundService()
    private var superHeroDao = AppDataBase.getInstance(application)
    val database = superHeroDao.AppSuperZoundDao()
    private var superHeroRepository = SuperZoundRepository(superHeroService,database)
    private var _superHeroes= superHeroRepository.superHeroes

    val superHeroes get()= _superHeroes

    private var _name = MutableLiveData<String>()
    val name get() = _name


    fun update(name: String){
        _name.value = name
    }

    fun fetchByName(){
        superHeroRepository.fetchByName(name.value!!)
        _superHeroes.value = superHeroRepository.superHeroes.value
    }

    fun insert(superZound: SuperZound){
        superHeroRepository.insert(superZound)
    }

    fun delete(superZound: SuperZound){
        superHeroRepository.delete(superZound)
    }











}