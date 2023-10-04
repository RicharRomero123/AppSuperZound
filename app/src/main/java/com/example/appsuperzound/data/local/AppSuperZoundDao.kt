package com.example.appsuperzound.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface AppSuperZoundDao {
    @Query("select * from SuperZound where id=:id") // Se crea en la Entity
    fun fetchById(id: String): List<AppSuperZoundEntity>
    @Insert()
    fun insertProduct(appSuperZoundEntity: AppSuperZoundEntity)
    @Query("SELECT * FROM SuperZound")
    fun getAll(): List<AppSuperZoundEntity>
    @Delete
    fun delete(appSuperZoundEntity: AppSuperZoundEntity)
}