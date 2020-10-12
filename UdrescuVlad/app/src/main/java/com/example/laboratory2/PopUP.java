package com.example.laboratory2;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class PopUP extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        TextView tName = (TextView)findViewById(R.id.tName);
        String value_tName = getIntent().getExtras().getString("value_to_be_transferred");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popupwindow);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getRealMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.8));

        tName.setText(value_tName);
    }
}
