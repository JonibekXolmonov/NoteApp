package com.example.noteapp.manager

import android.content.Context
import com.example.noteapp.model.Note
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class SharedPref(private val context: Context) {

    val sharedPref = context.getSharedPreferences("Notes", Context.MODE_PRIVATE)

    companion object {
        const val key = "note"
    }

    private var gson = Gson()

    fun saveNotes(notes: ArrayList<Note>) {
        sharedPref.edit().putString(key, gson.toJson(notes)).apply()
    }

    fun getNotes(): ArrayList<Note>? {
        val notesListJson = sharedPref.getString(key, "")
        val type: Type = object : TypeToken<java.util.ArrayList<Note>>() {}.type

        return gson.fromJson(notesListJson, type)
    }
}