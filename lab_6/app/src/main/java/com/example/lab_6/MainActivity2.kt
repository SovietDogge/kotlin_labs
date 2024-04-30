package com.example.lab_6

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.lab_6.databinding.Activity2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: Activity2Binding;
    private var user: User? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        user = intent.getParcelableExtra("user");
        user?.let {
            val userInfo = "Name: ${it.name}\nAge: ${it.age}"
            binding.text22.text = userInfo
        }

        binding.button2.setOnClickListener {
            finish()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable("user", user)
        Log.d("Message", "onSaveInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        user = savedInstanceState.getParcelable("user")
        Log.d("Message", "onRestoreInstanceState")
    }
}
