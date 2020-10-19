package com.rauln.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AlertDialog.Builder alertDialogBuilder;
    private EditText eName;
    private TextView tName;
    private Button bName, bRandome, bSearch, bShare;
    private Spinner spinner;
    private Intent intent;
    private Intent chooser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eName = (EditText) findViewById(R.id.eName);
        tName = (TextView) findViewById(R.id.tName);
        bName = (Button) findViewById(R.id.bName);
        bRandome = (Button) findViewById(R.id.bRandom);
        spinner = (Spinner) findViewById(R.id.color_spinner);
        bShare = (Button) findViewById(R.id.bShare);
        bSearch = (Button) findViewById(R.id.bSearch);

        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.my_colors, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                switch (pos){
                    case 0: {
                        bName.setTextColor(Color.BLUE);
                        break;
                    }
                    case 1: {
                        bName.setTextColor(Color.RED);
                        break;
                    }
                    case 2: {
                        bName.setTextColor(Color.YELLOW);
                        break;
                    }
                    case 3: {
                        bName.setTextColor(Color.GREEN);
                        break;
                    }
                    default: {
                        bName.setTextColor(Color.BLACK);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        bName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tName.setText("Hello there, " + eName.getText().toString() + "!");
                myDialog();
            }
        });

        bSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myExplicitIntend();
            }
        });

        bShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myImplicitIntend();
            }
        });
    }



    public void myDialog(){
        alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setTitle(" Greeting dialog!");
        alertDialogBuilder.setMessage(" Pick one: ");
        alertDialogBuilder.setPositiveButton("Positive", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, " Hello there, " + eName.getText().toString() + "!", Toast.LENGTH_SHORT).show();
            }
        });
        alertDialogBuilder.setNegativeButton("Negative", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, " Sorry " + eName.getText().toString() + ", I can't be negative today!", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void myImplicitIntend(){
        // on bShare click button
        intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, eName.getText().toString());
        intent.setType("text/plain");
        chooser = Intent.createChooser(intent, "Choose an aplication!");

        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(chooser);
        }
    }

    public void myExplicitIntend(){
        // on bSearch click button
    }
}