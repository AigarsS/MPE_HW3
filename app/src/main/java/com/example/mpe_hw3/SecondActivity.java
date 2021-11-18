package com.example.mpe_hw3;

import static android.text.TextUtils.isEmpty;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import com.google.android.material.textfield.TextInputLayout;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        findViewById(R.id.button_read).setOnClickListener(view -> {
            SharedPreferences sharedPreferences =
                    PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

            TextInputLayout inputLayout = findViewById(R.id.textField_second);

            String userInput = sharedPreferences.getString("userInput", "");
            if (isEmpty(userInput)) {
                Toast.makeText(getApplicationContext(), "Nothing found", Toast.LENGTH_SHORT).show();
            } else {
                inputLayout.getEditText().setText(userInput);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}