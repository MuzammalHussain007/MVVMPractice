package com.blinkedgewillsun.mvvmpractice.viewmodal;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.blinkedgewillsun.mvvmpractice.modal.MovieModal;
import com.blinkedgewillsun.mvvmpractice.network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MovieViewModal extends ViewModel {

    private MutableLiveData<List<MovieModal>> mutableLiveData ;

    public MovieViewModal() {

    }

    public MutableLiveData<List<MovieModal>> initazieLiveData()
    {
        if (mutableLiveData==null)
        {
            mutableLiveData = new MutableLiveData<>();
        }
        return mutableLiveData;
    }

    public void hitApi()
    {
        RetrofitClient.getInstance().getapi().getMovieList().enqueue(new Callback<List<MovieModal>>() {
            @Override
            public void onResponse(Call<List<MovieModal>> call, Response<List<MovieModal>> response) {
                if (response.isSuccessful())
                {
                    mutableLiveData.postValue(response.body());
                    Log.d("apiHit", ""+response.body());
                }
            }

            @Override
            public void onFailure(Call<List<MovieModal>> call, Throwable t) {
               mutableLiveData.postValue(null);
            }
        });
    }
}
