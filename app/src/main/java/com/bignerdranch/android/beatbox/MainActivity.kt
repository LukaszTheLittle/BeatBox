package com.bignerdranch.android.beatbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.bignerdranch.android.beatbox.databinding.ActivityMainBinding

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
}