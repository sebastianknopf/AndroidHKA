package eu.iums.androidhka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(this, "Hello World!", Toast.LENGTH_SHORT).show();

        Log.i("TAG", "onResume!");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i("TAG", "onPause!");
    }
}