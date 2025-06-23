package com.gundogar.todoappmeg.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.gundogar.todoappmeg.databinding.FragmentHomeBinding
import com.gundogar.todoappmeg.ui.viewmodel.HomeViewModel
import com.gundogar.todoappmeg.ui.adapter.TodoAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.searchResults.collect { todos ->
                    binding.recyclerViewToDos.adapter = TodoAdapter(todos, onDeleteClick = {
                        viewModel.deleteTodo(it)
                    }) {
                        val action = HomeFragmentDirections.actionHomeFragmentToUpdateFragment(it)
                        findNavController().navigate(action)
                    }
                }

            }
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.setSearchQuery(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.setSearchQuery(query)
                return true
            }
        })

        binding.fab.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToSaveFragment()
            findNavController().navigate(action)
        }



    }

}