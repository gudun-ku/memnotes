package com.beloushkin.test.memorynotesapp.presentation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.beloushkin.test.memorynotesapp.R
import com.beloushkin.test.memorynotesapp.framework.ListViewModel
import kotlinx.android.synthetic.main.fragment_list.*


class ListFragment : Fragment(),ListAction {

    private var notesListAdapter = NotesListAdapter(arrayListOf(), this)
    private lateinit var viewModel:ListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        notesListView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = notesListAdapter
        }

        addNote.setOnClickListener { goToNoteDetails() }

        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        observeViewModel()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getNotes()
    }

    private fun observeViewModel() {
        viewModel.notes.observe(this, Observer { notesList ->
            notesListAdapter.updateNotes(notesList.sortedByDescending { it.updateTime  })
            loadingView.visibility = View.GONE
            notesListView.visibility = View.VISIBLE
        })
    }

    private fun goToNoteDetails(id: Long = 0L) {
        val action = ListFragmentDirections.actionGoToNote(id)
        Navigation.findNavController(notesListView).navigate(action)
    }

    override fun onClick(id: Long) {
        goToNoteDetails(id)
    }
}
