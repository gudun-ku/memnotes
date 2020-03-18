package com.beloushkin.test.core.usecase

import com.beloushkin.test.core.data.Note
import com.beloushkin.test.core.repository.NoteRepository

class RemoveNote(private val noteRepository: NoteRepository) {
    suspend operator fun invoke(note: Note) = noteRepository.removeNote(note)
}