package com.example.android_onlinehw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * The SimpleAsyncTask app contains a button that launches an AsyncTask
 * which sleeps in the asynchronous thread for a random amount of time.
 */
public class AsynctaskMain extends AppCompatActivity {
    //Key for saving the state of the TextView
    private static final String TEXT_STATE = "currentText";
    // The TextView where we will show results
    private TextView tv1 = null;
    private ProgressBar pgb;

    /**
     * Initializes the activity.
     * @param savedInstanceState The current state data
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asynctask_main);

        tv1 = findViewById(R.id.tv1);
        pgb = findViewById(R.id.pgbar);

        // Restore TextView if there is a savedInstanceState
        if(savedInstanceState!=null) {
            tv1.setText(savedInstanceState.getString(TEXT_STATE));
        }
    }

    /**`
     * Handles the onCLick for the "Start Task" button. Launches the AsyncTask
     * which performs work off of the UI thread.
     *
     * @param view The view (Button) that was clicked.
     */
    public void startTask(View view) {
        // Put a message in the text view
        tv1.setText(R.string.napping);
        pgb.setVisibility(View.VISIBLE);
        // Start the AsyncTask.
        // The AsyncTask has a callback that will update the text view.
        new SimpleAsynctask(tv1).execute();
        // 1. main에서 시간 정해두고 각각의 asynctask에 시간을 알려주고 실행하도록
        // 2. sleep or while 을 다른 사람이 깨워줄 때까지 하도록! progressbar가 끝나면 실행하도
        // mutex, Semaphore 공용 공간을 두고 접근할 수 있도록 정해진 사람만!!
        new MyAsynctask(pgb).execute();
    }

    /**
     * Saves the contents of the TextView to restore on configuration change.
     * @param outState The bundle in which the state of the activity is saved
     * when it is spontaneously destroyed.
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save the state of the TextView
        outState.putString(TEXT_STATE, tv1.getText().toString());
    }
}