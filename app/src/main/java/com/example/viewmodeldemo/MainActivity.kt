package com.example.viewmodeldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodeldemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)


        binding.lifecycleOwner = this
        binding.myViewModel = viewModel

//        viewModel.totalCount.observe(this, Observer {
//            binding.tvCount.text = it.toString()
//            if(it > 0){
//                binding.tvCount.setTextColor(ContextCompat.getColor(this, R.color.green))
//            }else{
//                binding.tvCount.setTextColor(ContextCompat.getColor(this, R.color.red))
//            }
//        })

        binding.apply {
            btIncrement.setOnClickListener {
                viewModel.incrementCount()
            }

            btDecrement.setOnClickListener {
                viewModel.decrementCount()
            }
        }
    }
}