package com.bignerdranch.android.beatbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.beatbox.databinding.ActivityMainBinding
import com.bignerdranch.android.beatbox.databinding.ListItemSoundBinding

class MainActivity : AppCompatActivity() {

    private val soundAdapter: SoundAdapter = SoundAdapter(BeatBox(assets))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = soundAdapter
        }
    }

    override fun onDestroy() {
        soundAdapter.beatBoxRelease()
        super.onDestroy()
    }

    private inner class SoundHolder(
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

    private inner class SoundAdapter(
        private val beatBox: BeatBox
        ):
        RecyclerView.Adapter<SoundHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
                SoundHolder {
            val binding = DataBindingUtil.inflate<ListItemSoundBinding>(
                layoutInflater,
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

        fun beatBoxRelease() {
            beatBox.release()
        }
    }
}