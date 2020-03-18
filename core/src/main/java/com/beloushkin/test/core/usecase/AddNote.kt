package com.beloushkin.test.core.usecase

import com.beloushkin.test.core.data.Note
import com.beloushkin.test.core.repository.NoteRepository

class AddNote(private val noteRepository: NoteRepository) {
    suspend operator fun invoke(note: Note) = noteRepository.addNote(note)
}