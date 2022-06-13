package com.bignerdranch.android.beatbox

import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.beatbox.databinding.ListItemSoundBinding

class SoundHolder(
    private val binding: ListItemSoundBinding,
    beatBox: BeatBox
):
    RecyclerView.ViewHolder(binding.root) {

    init {
        binding.viewModel = SoundViewModel(beatBox)
    }

    fun bind(sound: Sound) {
        binding.apply {
            viewModel?.sound = sound
            executePendingBindings()
        }
    }
}