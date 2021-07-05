package com.example.android_onlinehw;

import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsynctask extends AsyncTask<Void, Void, String> {
    private WeakReference<TextView> tv1; //멤버 변수 정의 (약한 참조라 get()로 TextView 가져와서 호출하려면 메서드 사용해야 함)
    SimpleAsynctask(TextView tv) {
        tv1 = new WeakReference<>(tv); //생성자 구현
    }

    @Override
    protected String doInBackground(Void... voids) {
        // Generate a random number between 0 and 10
        Random r = new Random();
        int n = r.nextInt(11);

        // Make the task take long enough that we have
        // time to rotate the phone while it is running
        int s = n * 200;

        // Sleep for the random amount of time
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Return a String result
        return "Awake at last after sleeping for " + s + " milliseconds!";
    }
    protected void onPostExecute(String result) {
        tv1.get().setText(result);
    }
}

