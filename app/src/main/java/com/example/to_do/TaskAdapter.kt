package com.example.to_do

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.to_do.databinding.RecyclerRowBinding

class TaskAdapter (val taskList: ArrayList<Tasks> ): RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    class TaskViewHolder(val binding: RecyclerRowBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.binding.textTaskView.text = taskList[position].task

    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    fun addTask(task: Tasks) {
        taskList.add(task)
        notifyItemInserted(taskList.size - 1) // Yeni öğe eklendiğini bildir
    }

}