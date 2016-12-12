package com.example.rm30917.persistence;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        redirect();
    }

    public void doSignIn(View v) {
        String username = ((EditText) findViewById(R.id.edtName))
                .getText()
                .toString();

        String password = ((EditText) findViewById(R.id.edtPassword))
                .getText()
                .toString();

        CheckBox cbKeepSession = (CheckBox) findViewById(R.id.chkSession);

        if (username.equals("admin") && password.equals("123")) {
            // Save into sharedPreferences if checkbox is checked
            if (cbKeepSession.isChecked()) {
                savePreferences(username, true);
            }
            openScreen();
        }
    }

    // Check if app has value saved on shared preferences
    private void redirect() {
        SharedPreferences settings = getSharedPreferences("PREFERENCES", MODE_PRIVATE);

        if (settings.getBoolean("keepSession", false)) {
            openScreen();
        }
    }

    private void openScreen() {
        startActivity(new Intent(this, BooksActivity.class));
        finish(); // Destroy Login Screen
    }

    private void savePreferences(String username, Boolean keepSession) {
        SharedPreferences settings = getSharedPreferences("PREFERENCES",
                MODE_PRIVATE); // Only our app has access so

        SharedPreferences.Editor editor = settings.edit();

        editor.putString("username", username);
        editor.putBoolean("keepSession", keepSession);
        editor.commit();
    }
}
