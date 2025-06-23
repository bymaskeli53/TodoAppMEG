package com.gundogar.todoappmeg

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.gundogar.todoappmeg.databinding.ItemTodoBinding

class TodoAdapter(var toDosList: List<Todo>,val onDeleteClick: (Todo) -> Unit)
    : RecyclerView.Adapter<TodoAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(var binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val binding = ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardDesignHolder(binding)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val toDo = toDosList.get(position)
        val design = holder.binding

        design.textViewName.text = toDo.name

//        design.cardViewToDo.setOnClickListener {
//            val toUptadeScreen = MainScreenDirections.toUpdateScreen(toDo = toDo)
//            it.findNavController().navigate(toUptadeScreen)
//        }

        design.imageViewDelete.setOnClickListener {
            Snackbar.make(it,"Do you want to delete ${toDo.name} ?", Snackbar.LENGTH_SHORT)
                .setAction("YES") {
                   onDeleteClick(toDo)
                }.show()
        }

    }

    override fun getItemCount(): Int {
        return toDosList.size
    }


}


