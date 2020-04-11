package com.example.chucknorrissays;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button refresh = findViewById(R.id.refresh);



        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callAPI();

            }
        });

    }

    public void callAPI(){
        //create Retrofit & parse retreived JSON using GSON deserialiser
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.chucknorris.io/").addConverterFactory(GsonConverterFactory.create()).build();

        //get service & call object for the request
        QuoteService service = retrofit.create(QuoteService.class);
        Call<Quote> coinsCall = service.getValue();

        //execute the network request

        coinsCall.enqueue(new Callback<Quote>() {
            @Override
            public void onResponse(Call<Quote> call, Response<Quote> response) {
                Log.d(TAG, "onResponse: SUCCESS");
                TextView quote = findViewById(R.id.quoteTextView);
                quote.setText(response.body().getValue());
            }

            @Override
            public void onFailure(Call<Quote> call, Throwable t) {
                Log.d(TAG, "onFailure: FAILURE" + t.getLocalizedMessage());
            }
        });
    }
}
