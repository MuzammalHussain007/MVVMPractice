package com.blinkedgewillsun.mvvmpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.blinkedgewillsun.mvvmpractice.adapter.MovieAdapter;
import com.blinkedgewillsun.mvvmpractice.modal.MovieModal;
import com.blinkedgewillsun.mvvmpractice.viewmodal.MovieViewModal;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView ;
    private MovieViewModal movieViewModal ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        innit();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        movieViewModal.initazieLiveData().observe(this, new Observer<List<MovieModal>>() {
            @Override
            public void onChanged(List<MovieModal> movieModals) {
                if (movieModals!=null)
                {

                    recyclerView.setAdapter(new MovieAdapter(getApplicationContext(),movieModals));
                }

            }
        });
        movieViewModal.hitApi();
    }

    private void innit() {
        recyclerView = findViewById(R.id.recyclarView);
        movieViewModal = ViewModelProviders.of(this).get(MovieViewModal.class);
    }
}