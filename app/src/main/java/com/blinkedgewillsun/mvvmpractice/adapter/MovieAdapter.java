package com.blinkedgewillsun.mvvmpractice.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blinkedgewillsun.mvvmpractice.R;
import com.blinkedgewillsun.mvvmpractice.modal.MovieModal;
import com.bumptech.glide.Glide;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder>  {
    private Context context ;
    private List<MovieModal> movieModals ;

    public MovieAdapter(Context context, List<MovieModal> movieModals) {
        this.context = context;
        this.movieModals = movieModals;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_view,parent,false);
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {
        holder.textView.setText(movieModals.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return movieModals.size();
    }

    public class MovieHolder extends RecyclerView.ViewHolder
    {
        private ImageView imageView;
        private TextView textView ;

        public MovieHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.action_image);
            textView = itemView.findViewById(R.id.custom_title);
        }
    }
}
