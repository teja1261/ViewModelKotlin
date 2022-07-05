package com.example.viewmodeldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var buttonInc: Button
    lateinit var buttonDec: Button
    private lateinit var viewModel:MainViewActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.tv_count)

        buttonInc = findViewById(R.id.bt_increment)
        buttonDec = findViewById(R.id.bt_decrement)

        viewModel = ViewModelProvider(this).get(MainViewActivity::class.java)

        viewModel.count.observe(this, Observer {
            textView.text = it.toString()
            if(it > 0){
                textView.setTextColor(ContextCompat.getColor(this, R.color.green))
            }else{
                textView.setTextColor(ContextCompat.getColor(this, R.color.red))
            }
        })

        buttonInc.setOnClickListener {
            viewModel.incrementCount()

        }

        buttonDec.setOnClickListener {
           viewModel.decrementCount()
        }
    }
}