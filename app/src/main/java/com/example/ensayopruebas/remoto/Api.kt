package com.example.ensayopruebas.remoto

import com.example.ensayopruebas.pojo.Productos
import retrofit2.Call
import retrofit2.http.GET

interface Api {


    @GET("products")
    fun getAllPersonajes(): Call<List<Productos>>

}