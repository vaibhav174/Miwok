package com.example.bittu.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_phrases);

       final ArrayList<word> numbers = new ArrayList<word>();

        numbers.add(new word("Where are you going?","minto wuksus", R.raw.phrase_where_are_you_going));
        numbers.add(new word("What is your name?","tinnә oyaase'nә", R.raw.phrase_what_is_your_name));
        numbers.add(new word("My name is...","oyaaset...", R.raw.phrase_my_name_is));
        numbers.add(new word("How are you feeling?","michәksәs?", R.raw.phrase_how_are_you_feeling));
        numbers.add(new word("I’m feeling good.","kuchi achit", R.raw.phrase_im_feeling_good));
        numbers.add(new word("Are you coming?","әәnәs'aa?", R.raw.phrase_are_you_coming));
        numbers.add(new word("Yes, I’m coming.","hәә’ әәnәm", R.raw.phrase_yes_im_coming));
        numbers.add(new word("I’m coming.","әәnәm", R.raw.phrase_im_coming));
        numbers.add(new word("Let’s go.","yoowutis", R.raw.phrase_lets_go));
        numbers.add(new word("Come here.","әnni'nem", R.raw.phrase_come_here));


        WordAdapter itemsAdapter = new WordAdapter(this, numbers, R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.phrases);

        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast t1= Toast.makeText(NumbersActivity.this, "color", Toast.LENGTH_SHORT).show();
                word w = numbers.get(i);
                releaseMediaPlayer();
                 mp = MediaPlayer.create(PhrasesActivity.this, w.getAudioID());
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
