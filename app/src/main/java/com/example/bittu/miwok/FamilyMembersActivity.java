package com.example.bittu.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembersActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_family_members);
       final ArrayList<word> numbers = new ArrayList<word>();

        numbers.add(new word("father","әpә", R.drawable.family_father, R.raw.family_father));
        numbers.add(new word("mother","әṭa", R.drawable.family_mother, R.raw.family_mother));
        numbers.add(new word("son","angsi", R.drawable.family_son, R.raw.family_son));
        numbers.add(new word("daugher","tune", R.drawable.family_daughter, R.raw.family_daughter));
        numbers.add(new word("older brother","taachi", R.drawable.family_older_brother, R.raw.family_older_brother));
        numbers.add(new word("younger brother","chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        numbers.add(new word("older sister","teṭe", R.drawable.family_older_sister, R.raw.family_older_sister));
        numbers.add(new word("younger sister","kolliti", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        numbers.add(new word("grandmother","ama", R.drawable.family_grandmother, R.raw.family_grandmother));
        numbers.add(new word("grandfather","paapa", R.drawable.family_grandfather, R.raw.family_grandfather));


        WordAdapter itemsAdapter = new WordAdapter(this, numbers, R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.family);

        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast t1= Toast.makeText(NumbersActivity.this, "color", Toast.LENGTH_SHORT).show();
                word w = numbers.get(i);
                releaseMediaPlayer();
                 mp = MediaPlayer.create(FamilyMembersActivity.this, w.getAudioID());
                mp.start();
                mp.setOnCompletionListener(ml);
            }
        });

    }
    /**
     * Clean up the media player by releasing its resources.
     */
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
