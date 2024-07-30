package com.example.to_do

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.to_do.databinding.ActivityToDoListBinding

class ToDoListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityToDoListBinding
    private lateinit var taskList: ArrayList<Tasks>
    private lateinit var adapter: TaskAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityToDoListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        taskList = ArrayList() // Task listesi başlatılıyor
        adapter = TaskAdapter(taskList)
        binding.tasksRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.tasksRecyclerView.adapter = adapter

    }

    fun addButton(view: View){
        val taskText = binding.editTextText.text.toString() // 'taskText' değişkeni kullanılıyor
        if (taskText.isNotEmpty()) {
            val newTask = Tasks(taskText)
            adapter.addTask(newTask)
            binding.editTextText.text.clear() // Girdi kutusunu temizle
        }

    }

}