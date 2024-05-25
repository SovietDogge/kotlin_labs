package com.example.lab_9

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.lab_9.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    companion object {
        lateinit var database: WorkoutsDB
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = Room.databaseBuilder(
            applicationContext,
            WorkoutsDB::class.java, "workout_database"
        ).build()
        val workoutDao = database.workoutDao()

        binding.addWorkoutButton.setOnClickListener{
            val name = binding.titleEdit.text.toString()
            val during = binding.durationEdit.text.toString()
            val date = binding.dateEdit.text.toString()
            val workout = Workout(name = name, during = during, date = date)
            GlobalScope.launch {
                workoutDao.insertAll(workout)
            }

            Toast.makeText(applicationContext, "Workout added", Toast.LENGTH_LONG).show()
        }

        binding.allTrainsButton.setOnClickListener{
            GlobalScope.launch {
                val contacts = workoutDao.getAll()
                var workoutInfo = ""
                contacts.forEach{
                    workoutInfo += "${it.name} ${it.during} ${it.date}\n"
                }
                runOnUiThread{
                    binding.textView.text = workoutInfo
                }
            }
        }

        binding.deleteButton.setOnClickListener{
            val workoutId = binding.idEdit.text.toString().toIntOrNull()

            if (workoutId == null || workoutId < 0) {
                Toast.makeText(this, "Invalid index. Please enter a valid number.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            lifecycleScope.launch(Dispatchers.IO) {
                val workouts = workoutDao.getAll()
                val workoutToDelete = workouts[workoutId]
                workoutDao.deleteById(workoutToDelete.id)
             }
            }
        }
}

