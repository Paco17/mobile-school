package com.example.activity1_3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText nombre;
    private String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         nombre = findViewById(R.id.name);

    }

    public void sendName(View v){
        Intent intent = new Intent(MainActivity.this, MenuActivity.class);
        str = nombre.getText().toString();
        intent.putExtra("Nombre", str);
        startActivity(intent);
        finish();
    }
}