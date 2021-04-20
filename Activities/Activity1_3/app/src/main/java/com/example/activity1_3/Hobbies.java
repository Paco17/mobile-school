package com.example.activity1_3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Hobbies extends AppCompatActivity{

    Button back;
    EditText hobbie;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hobbies);

        hobbie = findViewById(R.id.hobbyET);
        back = findViewById(R.id.backMSG);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Important: DON'T OPEN A NEW ACTIVITY IF YOU INTEND TO RETURN
                Intent intent = new Intent();
                intent.putExtra("hobbie", hobbie.getText().toString());
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}
