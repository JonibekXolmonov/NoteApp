package com.example.noteapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.R
import com.example.noteapp.model.Note

class NoteAdapter(val notes: ArrayList<Note>) : RecyclerView.Adapter<NoteAdapter.NoteVH>() {

    inner class NoteVH(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind() {
            val note: Note = notes[adapterPosition]
            if (note.date == null) {
                view.findViewById<TextView>(R.id.tvDescription).text = "Good note app)))"
            }
            view.findViewById<TextView>(R.id.tvDate).text = note.date
            view.findViewById<TextView>(R.id.tvDescription).text = note.description

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteVH =
        NoteVH(LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false))

    override fun onBindViewHolder(holder: NoteVH, position: Int) = holder.bind()

    override fun getItemCount(): Int = notes.size

    @SuppressLint("NotifyDataSetChanged")
    fun addNote(note: Note) {
        notes.add(note)
        notifyDataSetChanged()
    }
}