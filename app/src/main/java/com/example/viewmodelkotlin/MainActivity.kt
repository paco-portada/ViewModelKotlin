package com.example.viewmodelkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodelkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var viewmodel: MainActivityViewModel
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        binding.button.setOnClickListener(this)

        viewmodel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        binding.textView.text = viewmodel.number.toString()
    }
    override fun onClick(view: View) {
        if (view === binding.button) {
            viewmodel.addNumber()
            binding.textView.text = viewmodel.number.toString()
        }
    }
}