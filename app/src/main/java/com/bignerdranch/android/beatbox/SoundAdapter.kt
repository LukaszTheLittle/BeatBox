package com.bignerdranch.android.beatbox

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.beatbox.databinding.ListItemSoundBinding

class SoundAdapter(private val beatBox: BeatBox) :
    RecyclerView.Adapter<SoundHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoundHolder {
        val binding = DataBindingUtil.inflate<ListItemSoundBinding>(
            LayoutInflater.from(parent.context),
            R.layout.list_item_sound,
            parent,
            false
        )
        return SoundHolder(binding, beatBox)
    }

    override fun onBindViewHolder(holder: SoundHolder, position: Int) {
        val sound = beatBox.sounds[position]
        holder.bind(sound)
    }

    override fun getItemCount() = beatBox.sounds.size

    fun onDestroy() {
        beatBox.release()
    }
}