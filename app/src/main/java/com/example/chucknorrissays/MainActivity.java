package com.example.chucknorrissays;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";
    private TextToSpeech textToSpeech;
    private String text = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button refresh = findViewById(R.id.refresh);
        Button tts = findViewById(R.id.tts);
        tts.setVisibility(View.INVISIBLE);


        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callAPI();
                tts.setVisibility(View.VISIBLE);
            }
        });

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR){
                    textToSpeech.setLanguage(Locale.US);
                }
            }
        });

        tts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("IVE BEEN CLICKED");
                System.out.println(text);
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
                textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH,null);
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
                text = quote.getText().toString();

            }

            @Override
            public void onFailure(Call<Quote> call, Throwable t) {
                Log.d(TAG, "onFailure: FAILURE" + t.getLocalizedMessage());
            }
        });
    }
}
