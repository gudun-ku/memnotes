package com.beloushkin.test.memorynotesapp.framework.di

import android.app.Application
import com.beloushkin.test.core.repository.NoteRepository
import com.beloushkin.test.memorynotesapp.framework.RoomNoteDataSource
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideRepository(app: Application) = NoteRepository(RoomNoteDataSource(app))
}