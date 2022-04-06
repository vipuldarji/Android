package com.example.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SongListAdapter extends RecyclerView.Adapter<SongListAdapter.MyViewHolder> {

    private Context context;
    private List<String> name;
    private List<Integer> image;
    private List<Integer> id;
    private List<String> price;
    private List<String> desc;
    private SongListenerInterface songListenerInterface;

    public SongListAdapter(Context context, List<String> name, List<Integer> id, List<Integer> image, List<String> price, List<String> desc){

        this.context = context;
        this.name = name;
        this.image = image;
        this.id = id;
        this.desc = desc;
        this.price = price;
        songListenerInterface = (SongMainActivity) context;

    }

    @NonNull
    @Override
    public SongListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.song_item,parent,false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull SongListAdapter.MyViewHolder holder, int position) {

        holder.mTextView.setText(name.get(position));
        holder.mImageView.setImageResource(image.get(position));

        holder.btnDetails.setOnClickListener(view -> {

            Log.i("Message","Item clicked :");


            songListenerInterface.onSongSelected(name.get(position),desc.get(position),price.get(position),image.get(position));

        });

    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mTextView;
        ImageView mImageView;
       Button btnDetails;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mTextView = itemView.findViewById(R.id.mTextView);
            mImageView = itemView.findViewById(R.id.mImageView);
            btnDetails = itemView.findViewById(R.id.sngDetails);


        }
    }
}

