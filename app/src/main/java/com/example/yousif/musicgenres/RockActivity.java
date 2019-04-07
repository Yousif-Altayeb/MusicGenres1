package com.example.yousif.musicgenres;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Yousif on 1/9/2019.
 */

public class RockActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    private AudioManager mAudioManager;


    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {

                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                            focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {

                        mMediaPlayer.pause();
                        mMediaPlayer.seekTo(0);

                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {

                        mMediaPlayer.start();

                    } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        releaseMediaPlayer();
                    }
                }
            };


    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {

        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.songs_list);

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Songs> songs = new ArrayList<>();


        //Long way for adding Songs objects into an array List
//        Songs song1 = new Songs("High Hopes - Panic! At The Disco", "Had to have high, high hopes for a living\n" +
//                "Shooting for the stars when I couldn't make a killing");
//        songs.add(song1);

        //Short way for adding Songs objects into an array List
        songs.add(new Songs("High Hopes - Panic! At The Disco","Had to have high, high hopes for a living\n" +
              "Shooting for the stars when I couldn't make a killing", R.raw.yellowstonetrack));
        songs.add(new Songs("Natural","Will, you hold the line\n" +
                "When every one of them is giving up or giving in, tell me",R.raw.yellowstonetrack));
        songs.add(new Songs("Broken","I like that you're broken\n" +
                "Broken like me\n" +
                "Maybe that makes me a fool", R.raw.yellowstonetrack));
        songs.add(new Songs("My Blood","When everyone you thought you knew\n" +
                "Deserts your fight, I'll go with you", R.raw.yellowstonetrack));
        songs.add(new Songs("Guiding Light","-----------------------------------", R.raw.yellowstonetrack));
        songs.add(new Songs("You're Somebody Else","----------------------------",R.raw.yellowstonetrack));
        songs.add(new Songs("Bad Liar","----------------------------------------",R.raw.yellowstonetrack));
        songs.add(new Songs("Shotgun","-----------------------------------------", R.raw.yellowstonetrack));
        songs.add(new Songs("Zero","--------------------------------------------",R.raw.yellowstonetrack));
        songs.add(new Songs("Love It If We Made It","---------------------------",R.raw.yellowstonetrack));
        songs.add(new Songs("S.O.S. (Sawed Off Shotgun)","----------------------",R.raw.yellowstonetrack));


        wordAdapter Adapter = new wordAdapter(this, songs, R.color.category_rock);


        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(Adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*Toast.makeText(NumbersActivity.this, "List item clicked", Toast.LENGTH_SHORT).show();*/

                Songs word = songs.get(position);

                releaseMediaPlayer();

                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {


                    mMediaPlayer = MediaPlayer.create(RockActivity.this, R.raw.high_hope);
                    mMediaPlayer = MediaPlayer.create(RockActivity.this, word.getmAudioRisourceId());
                    mMediaPlayer.start();

                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;


            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

}