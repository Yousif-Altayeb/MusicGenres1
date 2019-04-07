package com.example.yousif.musicgenres;

import android.app.Activity;
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

/**
 * Created by Yousif on 3/5/2019.
 */

public class wordAdapter extends ArrayAdapter<Songs> {

    private int mColorResourceId;

    public wordAdapter(Activity context, ArrayList<Songs> songs, int colorResoureID){

        super(context, 0, songs);
        mColorResourceId = colorResoureID;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);

        }

        Songs currentword = getItem(position);

        TextView songTextView = (TextView) listItemView.findViewById(R.id.song_name);

        songTextView.setText(currentword.getmSongName());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.song_discription);

        defaultTextView.setText(currentword.getmSongName());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.Image);

        if (currentword.hasImage()) {

            imageView.setImageResource((currentword.getmImageResourceID()));
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
