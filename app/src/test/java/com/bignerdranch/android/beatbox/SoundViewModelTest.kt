package com.bignerdranch.android.beatbox

import org.junit.Assert.assertSame
import org.junit.Before
import org.junit.Test

class SoundViewModelTest {

    private lateinit var sound: Sound
    private lateinit var subject: SoundViewModel

    @Before
    fun setUp() {
        sound = Sound("assetPath")
        subject = SoundViewModel()
        subject.sound = sound
    }

    @Test
    fun exposesSoundNameAsTitle() {
        assertSame(subject.title, (sound.name))
    }

}