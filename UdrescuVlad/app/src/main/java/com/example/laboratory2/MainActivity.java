package com.example.laboratory2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bClick = (Button) findViewById(R.id.bClick);

        bClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText eName = (EditText) findViewById(R.id.eName);
                final String value_to_be_transferred = eName.getText().toString();

                Intent intent = new Intent(MainActivity.this, PopUP.class);
                intent.putExtra("value_to_be_transferred", value_to_be_transferred);
                startActivity(intent);
            }
        });
    }
}