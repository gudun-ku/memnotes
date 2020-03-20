package com.beloushkin.test.memorynotesapp.framework
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.beloushkin.test.core.data.Note
import com.beloushkin.test.core.repository.NoteRepository
import com.beloushkin.test.core.usecase.AddNote
import com.beloushkin.test.core.usecase.GetAllNotes
import com.beloushkin.test.core.usecase.GetNote
import com.beloushkin.test.core.usecase.RemoveNote
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListViewModel(application: Application): AndroidViewModel(application) {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    // must be injected by di
    val repository = NoteRepository(RoomNoteDataSource(application))

    // must be injected by di
    val useCases = UseCases(
        AddNote(repository),
        GetAllNotes(repository),
        GetNote(repository),
        RemoveNote(repository)
    )

    val notes = MutableLiveData<List<Note>>()

    fun getNotes() {
        coroutineScope.launch {
            val noteList = useCases.getAllNotes()
            notes.postValue(noteList)
        }
    }
}