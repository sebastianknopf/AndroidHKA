package eu.iums.androidhka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intentHoweverYouWantToCall = this.getIntent();

        TextView textView = this.findViewById(R.id.textView);

        textView.setText(intentHoweverYouWantToCall.getStringExtra("TEXT"));
    }
}