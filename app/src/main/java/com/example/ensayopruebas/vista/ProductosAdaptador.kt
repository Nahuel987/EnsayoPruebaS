package com.example.ensayopruebas.vista

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ensayopruebas.R
import com.example.ensayopruebas.pojo.Productos
import kotlinx.android.synthetic.main.contendor_items.view.*

class ProductosAdaptador (var list: List<Productos>): RecyclerView.Adapter<ProductosAdaptador.ProductosHolder>() {

    fun updateData(listProductos: List<Productos>) {
        Log.d("ACTUALIZA", "update ${listProductos.size}")
        list = listProductos

        //metodo del recyclerView
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductosHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contendor_items,parent,false)
        return ProductosHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ProductosHolder, position: Int) {

        val producto=list[position]
        holder.id.text=producto.id.toString()
        holder.name.text=producto.name
        holder.price.text=producto.price

        //mostrar con GLIDE
        val imgURL:String=producto.image

        Glide.with(holder.img.getContext())
            .load(imgURL)
            .centerCrop()
            .into(holder.img)
    }


    class ProductosHolder (view: View):RecyclerView.ViewHolder(view)
    {

        val id:TextView=itemView.findViewById(R.id.txtId)
        val name:TextView=itemView.findViewById(R.id.txtName)
        val price: TextView =itemView.findViewById(R.id.txtPrice)
        val img:ImageView=itemView.findViewById(R.id.image)

    }//class ViewHolder
}