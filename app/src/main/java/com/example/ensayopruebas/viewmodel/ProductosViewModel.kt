package com.example.ensayopruebas.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.ensayopruebas.modelo.ProductosRepositorio
import com.example.ensayopruebas.pojo.Productos

class ProductosViewModel (application: Application): AndroidViewModel(application){


    private val repository =  ProductosRepositorio(application)
    private val productosList = repository.passLiveDataToViewModel()


    //obtener del servidor usando retrofit
    fun fetchFromServer() {
        repository.fetchDataFromServer()
    }

    //obtener lista de personajes de la base de datos
    fun getDataFromDB(): LiveData<List<Productos>> {
        return productosList
    }


}