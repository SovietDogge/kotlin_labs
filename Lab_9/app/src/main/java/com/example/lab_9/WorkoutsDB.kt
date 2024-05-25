package com.example.lab_9

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase

@Database(entities = [Workout::class], version = 1)
abstract class WorkoutsDB: RoomDatabase() {
    abstract fun workoutDao(): WorkoutDao
}

@Entity(tableName = "workouts")
data class Workout(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "during") val during: String?,
    @ColumnInfo(name = "date") val date: String?
)

@Dao
interface WorkoutDao {
    @Query("SELECT * FROM workouts")
    fun getAll(): List<Workout>

    @Insert
    fun insertAll(vararg workouts: Workout)

    @Delete
    fun delete (workout: Workout)

    @Query("DELETE FROM workouts WHERE id = :workoutId")
    fun deleteById(workoutId: Int)
}
