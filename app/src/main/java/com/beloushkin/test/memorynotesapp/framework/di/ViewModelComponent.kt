package com.beloushkin.test.memorynotesapp.framework.di

import com.beloushkin.test.memorynotesapp.framework.ListViewModel
import com.beloushkin.test.memorynotesapp.framework.NoteViewModel
import dagger.Component

@Component(modules = [ApplicationModule::class, RepositoryModule::class, UseCasesModule::class])
interface ViewModelComponent {
    fun inject(noteViewModel: NoteViewModel)
    fun inject(listViewModel: ListViewModel)
}