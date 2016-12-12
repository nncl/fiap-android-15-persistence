package com.example.rm30917.persistence;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private CheckBox keepSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.edtName);
        password = (EditText) findViewById(R.id.edtPassword);
        keepSession = (CheckBox) findViewById(R.id.chkSession);
    }

    public void doSignIn(View v) {

    }
}
