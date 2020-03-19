package com.beloushkin.test.memorynotesapp.framework

import com.beloushkin.test.core.usecase.AddNote
import com.beloushkin.test.core.usecase.GetAllNotes
import com.beloushkin.test.core.usecase.GetNote
import com.beloushkin.test.core.usecase.RemoveNote

data class UseCases(
    val addNote: AddNote,
    val getAllNotes: GetAllNotes,
    val getNote: GetNote,
    val removeNote: RemoveNote
)