package com.sandhu.pokstats

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sandhu.pokstats.model.PokemonData
import kotlinx.android.synthetic.main.poke_list_row.view.*
import kotlin.coroutines.coroutineContext

class PokeListAdapter: RecyclerView.Adapter<PokeListAdapter.ViewHolder>(){

    private var listData: List<PokemonData>? = null


    fun setUpdatedData(listData: List<PokemonData>){
        this.listData = listData
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.poke_list_row, parent, false)
        Log.e("onCreateViewHolder: ", "view Inflated")
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listData?.get(position))
        //Toast.makeText(, "hello", Toast.LENGTH_SHORT).show()
    }

    override fun getItemCount(): Int {
        if(listData == null) return 0
        else return listData?.size!!
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.name
        val image = itemView.pokeImage
        //val name = itemView.findViewById<TextView>(R.id.name)
        fun bind(data: PokemonData?) {
            name.setText(data?.name)

            Log.e("Url: ", "https://projectpokemon.org/images/normal-sprite/"+ data?.name +".gif")
            Glide.with(itemView.context).asGif()
                .load("https://projectpokemon.org/images/normal-sprite/"+ data?.name?.lowercase() +".gif")
                .placeholder(R.drawable.ic_launcher_background)
                .into(image);
            //Glide.with(itemView.context)
                //.load(data?.img)
                //.apply(RequestOptions.centerCropTransform())
                //.dontAnimate()
                //.into(image)
        }

    }


}