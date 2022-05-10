package com.example.cpsc411petownerapp.todolist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.cpsc411petownerapp.R
import com.example.cpsc411petownerapp.database.todoData.TodoDatabase
import com.example.cpsc411petownerapp.databinding.TodoListFragmentBinding

/**
 * Fragment that displays the input text fields and to-do list
 */
class TodoListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Create data binding
        val binding: TodoListFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.todo_list_fragment, container, false)

        // Get reference to the application
        val application = requireNotNull(this.activity).application

        // Retrieve To-do data access object.
        val dataSource = TodoDatabase.getInstance(application).todoDao

        // Create a factory that generates TodoViewModels connected to the database.
        val viewModelFactory = TodoViewModelFactory(dataSource, application)

        // Generate an TodoViewModel using the factory.
        val todoViewModel =
            ViewModelProvider(
                this, viewModelFactory).get(TodoViewModel::class.java)

        // Connect the TodoViewModel with the variable in the layout
        binding.todoViewModel = todoViewModel
        // Assign the lifecycle owner to the activity so it manages the data accordingly.
        binding.lifecycleOwner = this

        // Provide a lambda function that is called when the RecyclerView item is selected.
        var todoAdapter = TodoListAdapter(TodoListener {
                taskId ->
            // Navigate to the to-do view and provide the id of the task referenced
            // by the select RecyclerView item.
            this.findNavController().navigate(
                TodoListFragmentDirections
                    .actionTodoListFragmentToTodoItemFragment(taskId)
            )
        })
        // Attach to-do adapter.
        binding.todoRecyclerview.adapter = todoAdapter

        // Submit an updated list to the to-do listAdapter whenever it changes. Take note
        // todoList is a LiveData object.
        todoViewModel.todoList.observe(viewLifecycleOwner, Observer {
            it?.let {
                todoAdapter.submitList(it)
            }
        })
        return binding.root
    }
}