package com.example.noteapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.adapter.NoteAdapter
import com.example.noteapp.dialog.ViewDialog
import com.example.noteapp.model.Note
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var rvNotes: RecyclerView
    private lateinit var noteAdapter: NoteAdapter

    private lateinit var viewDialog: ViewDialog

    private lateinit var btnAddNote: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        rvNotes = findViewById(R.id.rvNotes)
        btnAddNote = findViewById(R.id.btnAddNote)
        viewDialog = ViewDialog(this)

        refreshAdapter(getAllNotes())

        btnAddNote.setOnClickListener {
            viewDialog.openNewNoteDialog(noteAdapter)
        }
    }


    private fun getAllNotes(): ArrayList<Note> {
        return ArrayList<Note>().apply {
            this.add(Note("March 15", "Play football"))
            this.add(Note("March 16", "Play football"))
            this.add(Note("March 18", "Play football"))
        }
    }

    private fun refreshAdapter(allNotes: ArrayList<Note>) {
        noteAdapter = NoteAdapter(allNotes)
        rvNotes.adapter = noteAdapter
    }
}