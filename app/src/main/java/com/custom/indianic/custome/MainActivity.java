package com.custom.indianic.custome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button buttonHorizontal = (Button) findViewById(R.id.btnHorizontal);
        final Button buttonVertical = (Button) findViewById(R.id.btnVertical);
        final CustomClass customClassView = (CustomClass) findViewById(R.id.custom);
        buttonHorizontal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customClassView.setType("H");
                customClassView.invalidate();
            }
        });
        buttonVertical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customClassView.setType("V");
                customClassView.invalidate();
            }
        });
    }
}
