package eu.iums.androidhka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSendMessage = this.findViewById(R.id.btnSendMessage);

        EditText edtMessage = this.findViewById(R.id.edtMessage);
        TextView txtMessage = this.findViewById(R.id.txtMessage);

        btnSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = edtMessage.getText().toString();
                txtMessage.setText(message);

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(Constants.MESSAGE, message);

                startActivity(intent);
            }
        });
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

    public void openUrl(View view)
    {
        EditText editText = this.findViewById(R.id.edtUrl);
        String url = editText.getText().toString();

        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        Intent browserChooser = Intent.createChooser(browserIntent, "Wähle einen Browser");

        startActivity(browserChooser);
    }

    public void openDepartures(View view)
    {
        Intent intent = new Intent(this, DepartureActivity.class);
        this.startActivity(intent);
    }
}