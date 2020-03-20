package com.beloushkin.test.core.usecase

import com.beloushkin.test.core.data.Note

class GetWordCount {

    operator fun invoke(note: Note): Int = getCount(note.title) + getCount(note.content)

    private fun getCount(str: String) =
        str.split(" ", "\n")
            .filter {
                it.contains(Regex(".*[a-zA-Z0-9].*"))
            }
            .count()
}