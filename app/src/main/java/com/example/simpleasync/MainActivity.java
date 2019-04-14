package com.example.simpleasync;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private TextView mTextView;
    private static final String TEXT_STATE = "currentText";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize mTextView to the TextView
        mTextView = findViewById(R.id.textView1);

        if (savedInstanceState != null) {
            mTextView.setText(savedInstanceState.getString(TEXT_STATE));

        }
    }

    public void startTask(View view) {
        mTextView.setText(R.string.napping);

        new SimpleAsyncTask((Text) mTextView).execute();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(TEXT_STATE, mTextView.getText().toString());
    }
}
