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

        Intent intent = this.getIntent();
        if (intent != null) {
            String message = intent.getStringExtra(Constants.MESSAGE);

            TextView textView = this.findViewById(R.id.lblMessage);
            textView.setText(message);
        }
    }
}