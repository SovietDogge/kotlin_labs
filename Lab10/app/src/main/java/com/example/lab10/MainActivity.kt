package com.example.lab10

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.lab10.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getComments()

        binding.button.setOnClickListener {
            addComment()
        }
    }

    private fun getComments(){
        val retrofit = RetrofitClient.getInstance()
        val apiInterface = retrofit.create(ApiInterface::class.java)
        lifecycleScope.launch {
            val response = apiInterface.getComments()
            binding.textView.text = response.body()?.body
        }
    }

    private fun addComment(){
        val retrofit = RetrofitClient.getInstance()
        val apiInterface = retrofit.create(ApiInterface::class.java)
        lifecycleScope.launch {
            try {
                val comment = Comment(
                    id = 0,
                    postId = 0,
                    name = binding.name.text.toString(),
                    email = binding.email.text.toString(),
                    body = binding.body.text.toString()
                )
                val response = apiInterface.addComment(comment)
                if (response.isSuccessful && response.body() != null) {
                    Toast.makeText(applicationContext, "new comment with id of ${response.body()?.id} has been added", Toast.LENGTH_SHORT).show()
                }
            } catch (Ex: Exception) {
                Toast.makeText(applicationContext, "error", Toast.LENGTH_SHORT).show()
            }
        }
    }
}