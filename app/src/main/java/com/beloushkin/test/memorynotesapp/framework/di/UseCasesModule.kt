package com.beloushkin.test.memorynotesapp.framework.di

import com.beloushkin.test.core.repository.NoteRepository
import com.beloushkin.test.core.usecase.AddNote
import com.beloushkin.test.core.usecase.GetAllNotes
import com.beloushkin.test.core.usecase.GetNote
import com.beloushkin.test.core.usecase.RemoveNote
import com.beloushkin.test.memorynotesapp.framework.UseCases
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {

    @Provides
    fun getUseCases(repository: NoteRepository) = UseCases(
    AddNote(repository),
    GetAllNotes(repository),
    GetNote(repository),
    RemoveNote(repository)
    )
}