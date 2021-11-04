package com.blinkedgewillsun.mvvmpractice.network;





import com.blinkedgewillsun.mvvmpractice.modal.MovieModal;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APISERVICES {


    @GET("/photos")
    Call<List<MovieModal>> getMovieList(

    );














}
