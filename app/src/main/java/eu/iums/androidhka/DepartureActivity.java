package eu.iums.androidhka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import eu.iums.androidhka.network.KvvService;
import eu.iums.androidhka.network.Result;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DepartureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departure);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://projekte.kvv-efa.de/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        KvvService service = retrofit.create(KvvService.class);
        Call<Result> resultCall = service.listDepartures();

        resultCall.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result result = response.body();

                Log.i("DepartureActivity", String.valueOf(result.getDepartureList().size()));
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.d("DepartureActivity", "Anfragefehler");
            }
        });
    }
}