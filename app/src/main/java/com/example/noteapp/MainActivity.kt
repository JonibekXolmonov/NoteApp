package com.example.noteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.adapter.NoteAdapter
import com.example.noteapp.dialog.ViewDialog
import com.example.noteapp.manager.SharedPref
import com.example.noteapp.model.Note
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var rvNotes: RecyclerView
    private lateinit var noteAdapter: NoteAdapter

    private lateinit var viewDialog: ViewDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        rvNotes = findViewById(R.id.rvNotes)
        val btnAddNote: FloatingActionButton = findViewById(R.id.btnAddNote)
        viewDialog = ViewDialog(this)

        refreshAdapter(getAllNotes())

        btnAddNote.setOnClickListener {
            viewDialog.openNewNoteDialog(noteAdapter)
        }
    }

    private fun getAllNotes(): ArrayList<Note> {
        return SharedPref(this).getNotes() ?: return arrayListOf(Note(null, null))
    }

    private fun refreshAdapter(allNotes: ArrayList<Note>) {
        noteAdapter = NoteAdapter(allNotes)
        rvNotes.adapter = noteAdapter
    }
}