package com.example.eventhandlingfun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

// 2.A.
public class MainActivity extends AppCompatActivity /*implements View.OnClickListener(2.A.)*/ {
    static final String TAG = "MainActivityTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // task: change the constraint layout to a linear layout
        // get a java reference to the textview

        TextView textView = (TextView) findViewById(R.id.myTextView);

        // two ways to listen for a button click event
        // 1. set the android:onClick XML attribute to the name of
        // a method in MainActivity
        // we did this last class
        // 2. define a class that implements View.OnClickListener interface
        // register an object of that class with setOnClickListener(objref)
        //  3 ways to do option (2.)
        //      A. MainActivity implement View.OnClickListener
        //      B. some other class implement View.OnClickListener (outer or nested)
        //      C. have an anonymous class implement View.OnClickListener

        Button button = (Button) findViewById(R.id.button);
        //2.A.  button.setOnClickListener(this);

        //2.C.
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                EditText usernameEditText = (EditText) findViewById(R.id.usernameEditText);
                EditText passwordEditText = (EditText) findViewById(R.id.passwordEditText);

                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                Log.d(TAG, "onClick: " + username + " " + password);

                //clear out edittexts
                usernameEditText.setText("");
                passwordEditText.setText("");
            }
        });

        //task: when the login button is clicked
        //  grab the username and password the user entered
        //  and print them to logcat
    }

    /** 2.A.

    @Override
    public void onClick(View view) {
        Log.d(TAG, "onClick: ");
    } */


//    public void onButtonClick(View view) {
//        Log.d(TAG, "onButtonClick: ");
//    }
}