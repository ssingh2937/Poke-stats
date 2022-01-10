package com.sandhu.pokstats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.sandhu.pokstats.model.PokemonList
import kotlinx.android.synthetic.main.activity_main.*

class PokeListActivity : AppCompatActivity() {
    private lateinit var pokeListAdapter: PokeListAdapter
    private lateinit var pokeListViewModel: PokeListActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        initViewModel();
    }

    private fun initRecyclerView(){
        pokeListAdapter = PokeListAdapter()
        pokeRecyclerList.layoutManager = GridLayoutManager(this, 2)
        pokeRecyclerList.adapter = pokeListAdapter
    }

    private fun initViewModel() {
        pokeListViewModel = ViewModelProvider(this).get(PokeListActivityViewModel::class.java)
        pokeListViewModel.getLiveDataObserver().observe(this, object :Observer<PokemonList>{
            override fun onChanged(p0: PokemonList?) {
                if(p0  != null){
                    pokeListAdapter.setUpdatedData(p0.pokemon)
                    pokeListAdapter.notifyDataSetChanged()
                } else {
                    Toast.makeText(this@PokeListActivity, "error in getting the data", Toast.LENGTH_SHORT).show()
                }
            }
        })
        pokeListViewModel.makeApiCall()
    }
}