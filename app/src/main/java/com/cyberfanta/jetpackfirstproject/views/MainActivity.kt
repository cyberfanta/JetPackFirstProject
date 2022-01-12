package com.cyberfanta.jetpackfirstproject.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.cyberfanta.jetpackfirstproject.databinding.ActivityMainBinding
import com.cyberfanta.jetpackfirstproject.viewmodel.ViewModelMain
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    private lateinit var ui: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = ActivityMainBinding.inflate(layoutInflater)
        setContentView(ui.root)

        val model = ViewModelProvider(this).get(ViewModelMain::class.java)
        val urlImage: MutableLiveData<String?>? = model.callUrlImage()

        urlImage?.observe(this, {
            Picasso.get().load(it).into(ui.imagePhoto)
            Picasso.get().load(it).into(ui.imagePhoto2)
        })

        ui.button.setOnClickListener {
            model.randomNumbersUrl()
        }
    }
}
