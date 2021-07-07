package com.example.android_onlinehw;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.ref.WeakReference;

public class MyAsynctask extends AsyncTask<Void, Integer, Integer> {
    private WeakReference<TextView> tv1;
    private TextView tv2;
    private WeakReference<ProgressBar> pgb;
    int value;

    MyAsynctask(ProgressBar progress) {
        pgb = new WeakReference<>(progress); //생성자 구현

    }

    protected void onPreExecute() {
        value = 0;
        pgb.get().setProgress(value);
        //tv2 = findViewById(R.id.tv2);
    }

    @Override
    protected Integer doInBackground(Void... voids) {
        while(true){
            if(value>=100)break;
            value+=5;
            publishProgress(value);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return value;
    }

    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
    }
    protected void onProgressUpdate(Integer ... values) {
        pgb.get().setProgress(values[0].intValue());
        //tv2.setText("Current Value : " + values[0].intValue());
    }
}