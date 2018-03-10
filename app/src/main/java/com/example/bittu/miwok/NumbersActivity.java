package com.example.bittu.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_numbers);

       final ArrayList<word> numbers = new ArrayList<word>();

        numbers.add(new word("one","lutti", R.drawable.number_one, R.raw.number_one));
        numbers.add(new word("two","otiiko", R.drawable.number_two, R.raw.number_two));
        numbers.add(new word("three","tolookosu", R.drawable.number_three, R.raw.number_three));
        numbers.add(new word("four","oyyisa", R.drawable.number_four, R.raw.number_four));
        numbers.add(new word("five","massokka", R.drawable.number_five, R.raw.number_five));
        numbers.add(new word("six","temmokka", R.drawable.number_six, R.raw.number_six));
        numbers.add(new word("seven","kenekaku", R.drawable.number_seven, R.raw.number_seven));
        numbers.add(new word("eight","kawinta", R.drawable.number_eight, R.raw.number_eight));
        numbers.add(new word("nine","wo'e", R.drawable.number_nine, R.raw.number_nine));
        numbers.add(new word("ten","na'aacha", R.drawable.number_ten, R.raw.number_ten));

//   using array list and adapter is more memory efficient whenever list is long.for eg if this
//   contain numbers upto 1000 then we need 1000 views to store them which will use more memory.
//   adapter only create view which are visible too screen and those view are recycled to display
//   new contents each time we scroll


        // android has predefined a layout called simple_list_item_1 which we can directly use. this
        // layout has line after each element.
        WordAdapter itemsAdapter = new WordAdapter(this, numbers, R.color.category_numbers);

         ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast t1= Toast.makeText(NumbersActivity.this, "color", Toast.LENGTH_SHORT).show();
                word w = numbers.get(i);
                releaseMediaPlayer();
                mp = MediaPlayer.create(NumbersActivity.this, w.getAudioID());
                mp.start();
                mp.setOnCompletionListener(ml);

            }
        });
//        //dynamically creating a view
//        LinearLayout rv = (LinearLayout) findViewById(R.id.rootView);
//        for(int i=0; i<numbers.size(); i++) {
//            TextView tv = new TextView(this);
//            tv.setText(numbers.get(i));
//            rv.addView(tv);
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

