package com.curso.android.app.practica.proyectoticmasdam.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.curso.android.app.practica.proyectoticmasdam.R
import com.curso.android.app.practica.proyectoticmasdam.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

        private lateinit var binding: ActivityMainBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            val mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

            binding  = DataBindingUtil.setContentView(
                    this, R.layout.activity_main)

            binding.viewmodel = mainViewModel

            binding.lifecycleOwner = this

            mainViewModel.comparator.observe(this){
                mainViewModel.comparatorChain()
            }

            binding.comparatorButton.setOnClickListener{
                mainViewModel.verifyChain()
            }
        }
}


