package com.example.bittu.miwok;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    MediaPlayer mp;
    private MediaPlayer.OnCompletionListener ml = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

       final ArrayList<word> numbers = new ArrayList<word>();

        numbers.add(new word("red","weṭeṭṭi", R.drawable.color_red, R.raw.color_red));
        numbers.add(new word("green","chokokki", R.drawable.color_green, R.raw.color_green));
        numbers.add(new word("brown","ṭakaakki", R.drawable.color_brown, R.raw.color_brown));
        numbers.add(new word("gray","ṭopoppi", R.drawable.color_gray, R.raw.color_gray));
        numbers.add(new word("black","kululli", R.drawable.color_black, R.raw.color_black));
        numbers.add(new word("white","kelelli", R.drawable.color_white, R.raw.color_white));
        numbers.add(new word("dusty yellow","ṭopiisә", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        numbers.add(new word("mustard yellow","chiwiiṭә", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        WordAdapter itemsAdapter = new WordAdapter(this, numbers, R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.colors);

        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast t1= Toast.makeText(NumbersActivity.this, "color", Toast.LENGTH_SHORT).show();
                word w = numbers.get(i);
                releaseMediaPlayer();
                mp = MediaPlayer.create(ColorsActivity.this, w.getAudioID());
                mp.start();
                mp.setOnCompletionListener(ml);

            }
        });
    }
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mp!= null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mp.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mp = null;
        }
    }
}
