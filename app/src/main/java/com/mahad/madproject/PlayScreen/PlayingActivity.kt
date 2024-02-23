package com.mahad.madproject.PlayScreen

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mahad.madproject.GetFiles.GetFiles
import com.mahad.madproject.databinding.ActivityPlayingBinding

class PlayingActivity : AppCompatActivity() {
    private lateinit var mPlayingBinding: ActivityPlayingBinding
    private lateinit var mMediaPlayer: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPlayingBinding = ActivityPlayingBinding.inflate(layoutInflater)
        setContentView(mPlayingBinding.root)
    }

    override fun onStart() {
        super.onStart()

        var position = intent.getIntExtra("position",0)

        Log.i("position", position.toString())
        val audioFiles = GetFiles().getAudioFiles()
        val audioFile = audioFiles[position]
        val filepath: Uri = Uri.fromFile(audioFile.file)
        mMediaPlayer = MediaPlayer.create(this, filepath)

        mMediaPlayer.start()
        Toast.makeText(this, "started", Toast.LENGTH_SHORT).show()
        val songName = intent.getStringExtra("name")
        mPlayingBinding.songname.text = songName

        mPlayingBinding.stop.setOnClickListener {
            mMediaPlayer.stop()
        }
        mPlayingBinding.back.setOnClickListener {
            if(position-1 < 0){
                Toast.makeText(this, "End", Toast.LENGTH_SHORT).show()
            }
            else {
                mMediaPlayer.stop()

                val audioFileee = audioFiles[--position]
                val filepathhh: Uri = Uri.fromFile(audioFileee.file)
                mMediaPlayer = MediaPlayer.create(this, filepathhh)
                mMediaPlayer.start()
                mPlayingBinding.songname.text = audioFiles[position].name

            }
        }
        mPlayingBinding.forward.setOnClickListener {
            if(position+1 == audioFiles.size){
                Toast.makeText(this, "End", Toast.LENGTH_SHORT).show()
            }
            else {
                mMediaPlayer.stop()

                val audioFilee = audioFiles[++position]
                val filepathh: Uri = Uri.fromFile(audioFilee.file)
                mMediaPlayer = MediaPlayer.create(this, filepathh)
                mMediaPlayer.start()

                mPlayingBinding.songname.text = audioFiles[position].name
            }
        }
        mPlayingBinding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mMediaPlayer.seekTo(progress)
                }
            }
            val handler = Handler()

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
//                if (seekBar != null) {
//                    seekBar.max = mMediaPlayer.currentPosition
//                    handler.postDelayed(this, 1000)
//                }
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

    }
}