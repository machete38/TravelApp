package com.example.travelapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.travelapp.data.Place
import com.example.travelapp.databinding.ActivityMainBinding
import com.example.travelapp.view.PlaceAdapter


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var placeAdapter: PlaceAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRvAdapter()
    }

    private fun setRvAdapter() {
        placeAdapter = PlaceAdapter { place ->
            val intent = Intent(this@MainActivity, PlaceDetailsActivity::class.java).apply {
                putExtra("name", place.name)
                putExtra("imageUrl", place.imageUrl)
                putExtra("description", place.description)
            }
            startActivity(intent)
        }
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = placeAdapter
        }
        placeAdapter.submitList(createPlacesList())
    }

    private fun createPlacesList(): List<Place> {
        return listOf(
            Place(
                "Париж",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4b/La_Tour_Eiffel_vue_de_la_Tour_Saint-Jacques%2C_Paris_août_2014_%282%29.jpg/800px-La_Tour_Eiffel_vue_de_la_Tour_Saint-Jacques%2C_Paris_août_2014_%282%29.jpg",
                "Париж - столица Франции, известная своей архитектурой, искусством и кухней."
            ), Place(
                "Токио",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Skyscrapers_of_Shinjuku_2009_January.jpg/640px-Skyscrapers_of_Shinjuku_2009_January.jpg",
                "Токио - столица Японии, сочетающая в себе ультрасовременные технологии и традиционную культуру."
            ),
            Place(
                "Нью-Йорк",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSqAygj7gg6oojEOGsPKlWViCmqtWApbjAAfw&s",
                "Нью-Йорк - крупнейший город США, известный своими небоскребами и культурным разнообразием."
            )
        )

    }
}