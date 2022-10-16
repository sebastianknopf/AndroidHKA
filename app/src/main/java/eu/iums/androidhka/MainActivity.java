package eu.iums.androidhka;

import androidx.appcompat.app.AppCompatActivity;

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
}