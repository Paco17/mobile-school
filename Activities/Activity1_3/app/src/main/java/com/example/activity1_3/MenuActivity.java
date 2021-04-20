package com.example.activity1_3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity{

    private TextView tv;
    private TextView emptyTV;
    private static final int hobbieInt = 0;
    private static final int messageInt = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        tv = findViewById(R.id.welcome);
        emptyTV = findViewById(R.id.emptyTextView);

        //Intent of Name
        tv.setText("Hi " +
                getIntent().getStringExtra("Nombre"));

    }

    //Intent to Hobbie
    public void hobbieMethod(View v){
        Intent intent = new Intent(this, Hobbies.class);
        startActivityForResult(intent, hobbieInt);
    }

    //Intent to Friends
    public void friendsMethod(View v){
        Intent intent = new Intent(this, Friends.class);
        startActivity(intent);
    }

    //Intent to Message
    public void messageMethod(View v){
        Intent intent = new Intent(this, Message.class);
        startActivityForResult(intent, messageInt);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == hobbieInt && resultCode == Activity.RESULT_OK){
           emptyTV.setText(data.getStringExtra("hobbie"));
        }

        if(requestCode == messageInt && resultCode == Activity.RESULT_OK){
            Toast.makeText(this, data.getStringExtra("message"), Toast.LENGTH_SHORT).show();
        }
    }
}
