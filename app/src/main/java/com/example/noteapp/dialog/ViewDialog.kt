package com.example.noteapp.dialog

import android.app.Dialog
import android.content.Context
import android.view.Window
import android.widget.EditText
import android.widget.TextView
import com.example.noteapp.R
import com.example.noteapp.adapter.NoteAdapter
import com.example.noteapp.model.Note

class ViewDialog(private val context: Context) {

    fun openNewNoteDialog(noteAdapter: NoteAdapter) {
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.item_dialog)

        val edtNewNote = dialog.findViewById<EditText>(R.id.edtNewNote)

        val tvCancel = dialog.findViewById<TextView>(R.id.tvCancel)

        tvCancel.setOnClickListener {
            dialog.dismiss()
        }

        val tvSave = dialog.findViewById<TextView>(R.id.tvSave)

        tvSave.setOnClickListener {
            noteAdapter.addNote(Note("March 1", edtNewNote.text.toString()))
            dialog.dismiss()
        }

        dialog.show()
    }
}