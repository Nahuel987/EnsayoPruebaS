package com.example.ensayopruebas.vista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ensayopruebas.R
import com.example.ensayopruebas.pojo.Productos
import com.example.ensayopruebas.viewmodel.ProductosViewModel

class MainActivity : AppCompatActivity() {

    var listaProductos= ArrayList<Productos>()
    lateinit var viewAdapter:ProductosAdaptador
    lateinit var mViewModel :ProductosViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView =findViewById(R.id.recycler)
        recyclerView.layoutManager= LinearLayoutManager(this)

        //iniciando el view model
        mViewModel= ViewModelProvider(this).get(ProductosViewModel::class.java)

        //recibe respuesta de retrofit y se ingresan datos a la database
        mViewModel.fetchFromServer()

        //iniciando el adaptador
        viewAdapter= ProductosAdaptador(listaProductos)

        //pasando adaptador al recycler
        recyclerView.adapter=viewAdapter

        mViewModel.getDataFromDB().observe(this, Observer {
            viewAdapter.updateData(it)
        })

    }
}