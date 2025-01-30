package com.example.travelapp

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.travelapp.databinding.ActivityPlaceDetailsBinding

class PlaceDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlaceDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlaceDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getIntentParams()

    }

    private fun getIntentParams() {
        val name = intent.getStringExtra("name") ?: "No name"
        val img = intent.getStringExtra("imageUrl") ?: "https://projetcartylion.fr/wp-content/uploads/2020/08/Placeholder.png"
        val desc = intent.getStringExtra("description") ?: "No description"
        setViewInfo(name,img,desc)
    }

    private fun setViewInfo(name: String, img: String, desc: String) {
        Glide.with(this).load(img).into(binding.placeImage)
        binding.placeDescription.text = desc
        initializeToolbars(name)
    }

    private fun initializeToolbars(name: String) {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        binding.collapsingToolbar.title = name
    }
}
