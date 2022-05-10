package com.example.cpsc411petownerapp.todoitem

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.cpsc411petownerapp.R
import com.example.cpsc411petownerapp.database.todoData.TodoDatabase
import com.example.cpsc411petownerapp.databinding.TodoItemFragmentBinding

/**
 * Fragment that displays a single to-do.
 */
class TodoItemFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Retrieve arguments passed from the RecyclerView
        val args = TodoItemFragmentArgs.fromBundle(
            requireArguments()
        )

        // Create data binding
        val binding: TodoItemFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.todo_item_fragment, container, false)

        // Get reference to this application
        val application = requireNotNull(this.activity).application

        // Retrieve To-do data access object.
        val dataSource = TodoDatabase.getInstance(application).todoDao

        // Create a factory that generates an TodoViewModel connected to the database. The
        // taskId passed from the RecyclerView is used to display the corresponding
        // information.
        val viewModelFactory =
            TodoItemViewModelFactory(args.taskId, dataSource, application)

        // Generate an TodoViewModel using the factory.
        val todoItemViewModel =
            ViewModelProvider(
                this, viewModelFactory
            ).get(TodoItemViewModel::class.java)

        // Connect the TodoViewModel with the variable in the layout
        binding.todoItemViewModel = todoItemViewModel
        // Assign the lifecycle owner to the activity so it manages the data accordingly.
        binding.lifecycleOwner = this

        return binding.root
    }
}