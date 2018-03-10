package com.example.bittu.miwok;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bittu on 08-03-2018.
 */

public class WordAdapter extends ArrayAdapter<word>
{
    private int mcolor;

    public WordAdapter(Activity context , ArrayList<word> al , int color)
    {
        super(context,0,al);
        mcolor = color;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the word object located at this position in the list
        word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the version name from the current word object and
        // set this text on the name TextView
        miwokTextView.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the version number from the current word object and
        // set this text on the number TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());


        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.kgp);
        // Get the image resource ID from the current word object and
        // set the image to iconView
        if(currentWord.hasImage()) {
            iconView.setImageResource(currentWord.getImageResourceId());
            iconView.setVisibility(View.VISIBLE);
        }
        else
            iconView.setVisibility(View.GONE);


        //set theme color for list item
        View tc = listItemView.findViewById(R.id.text_container);
        //find the color that resourcesid maps to
        int c = ContextCompat.getColor(getContext(), mcolor);
        //set background color of container view
        tc.setBackgroundColor(c);
        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView

        //set the audio file to specific view

        return listItemView;

    }



}
