package com.example.android_onlinehw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AsynctaskMain extends AppCompatActivity {
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asynctask_main);
        tv1 = findViewById(R.id.tv1);
    }

    public void startTask(View view) {
        tv1.setText(R.string.napping);
        new SimpleAsynctask(tv1).execute();
    }
}