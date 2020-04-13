package com.example.chucknorrissays;

import com.example.chucknorrissays.Quote;
import retrofit2.Call;
import retrofit2.http.GET;

public interface QuoteService {

    @GET("/jokes/random?category=dev")
    Call<Quote> getValue();

}
