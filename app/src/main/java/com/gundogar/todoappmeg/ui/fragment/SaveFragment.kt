package com.gundogar.todoappmeg.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.gundogar.todoappmeg.databinding.FragmentSaveBinding
import com.gundogar.todoappmeg.ui.viewmodel.SaveViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SaveFragment : Fragment() {

    private lateinit var binding: FragmentSaveBinding
    private val viewModel: SaveViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSaveBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonSave.setOnClickListener {
            save()
        }
    }

    fun save() {
        viewModel.save(binding.editTextName.text.toString())
    }
}