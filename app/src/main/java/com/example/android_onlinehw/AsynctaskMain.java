package com.example.android_onlinehw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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

    /**
     * Initializes the activity.
     * @param savedInstanceState The current state data
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asynctask_main);

        tv1 = findViewById(R.id.tv1);

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
        // Start the AsyncTask.
        // The AsyncTask has a callback that will update the text view.
        new SimpleAsynctask(tv1).execute();
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