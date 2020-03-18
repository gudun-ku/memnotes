package com.beloushkin.test.core.usecase

import com.beloushkin.test.core.repository.NoteRepository

class GetNote(private val noteRepository: NoteRepository){
    suspend operator fun invoke(id: Long) = noteRepository.getNote(id)
}