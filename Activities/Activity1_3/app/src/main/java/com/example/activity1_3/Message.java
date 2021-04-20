package com.example.activity1_3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Message extends AppCompatActivity{

    private EditText msg;
    private Button regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message);

        msg = findViewById(R.id.msgET);
        regresar = findViewById(R.id.sendmsg);
    }

    public void sendMessage(View v){
        Intent intent = new Intent();
        intent.putExtra("message", msg.getText().toString());
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
