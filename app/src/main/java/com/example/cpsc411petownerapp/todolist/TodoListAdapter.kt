package com.example.cpsc411petownerapp.todolist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cpsc411petownerapp.database.todoData.Todo
import com.example.cpsc411petownerapp.databinding.TodoItemBinding

/**
 * A RecyclerView adapter that uses the DiffCallback for better performance and a listener to handle
 * clicks/taps on each item.
 */
class TodoListAdapter(val clickListener: TodoListener) : ListAdapter<Todo,
        TodoListAdapter.ItemViewHolder>(IntersectionDiffCallback()) {

    /**
     * Inner class used to store data about each element in the RecyclerView. We provide a binding
     * to make it easy to access elements of the layout.
     */
    class ItemViewHolder(val binding: TodoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        /**
         * Assign an to-do object and clickListener to the ItemViewHolder
         */
        fun bind(item: Todo, clickListener: TodoListener) {
            binding.todo = item
            binding.clickListener = clickListener
        }
    }

    /**
     * Creates a View to visualize one element in the RecyclerView.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // We use an inflater based on the parent (TodoListFragment) and create an
        // ItemViewHolder with binding to the layout to simplify access.
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = TodoItemBinding.inflate(layoutInflater, parent, false)
        return ItemViewHolder(binding)
    }

    /**
     * The function is called whenever the RecyclerView displays a specific element. It provides
     * access to the ItemViewHolder and its position.
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        // Assign the corresponding element from the data and the click listener. Take note getItem
        // is a function provided by ListAdapter.
        holder.bind(getItem(position), clickListener)
    }
}

/**
 * Manages a RecyclerView list using the Eugene W. Myers's difference algorithm to reduce processing.
 */
class IntersectionDiffCallback : DiffUtil.ItemCallback<Todo>() {
    /**
     * We use taskId because it is a unique ID referring to a single element.
     */
    override fun areItemsTheSame(oldItem: Todo, newItem: Todo): Boolean {
        return oldItem.taskId == newItem.taskId
    }

    /**
     * We check all properties to check equality between To-do objects.
     */
    override fun areContentsTheSame(oldItem: Todo, newItem: Todo): Boolean {
        return oldItem.title == newItem.title && oldItem.detail == newItem.detail
    }
}

/**
 * Listener that accepts a lambda function clickListener. It will be called when an element of the
 * RecyclerView is clicked/tapped.
 */
class TodoListener(val clickListener: (taskId: Long) -> Unit) {
    fun onClick(todo: Todo) = clickListener(todo.taskId)
}