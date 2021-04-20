package com.example.activity14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private DBHelper db;
    private TextView name, hobbie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DBHelper(this);
        name = findViewById(R.id.nametv);
        hobbie = findViewById(R.id.hobbietv);

        //String queryName = "SELECT"+ db.COL_NAME +" FROM "+ db.TABLE_NAME +" LIMIT 1 ";
        //String queryHobbie = "SELECT"+ db.COL_HOBIE +" FROM "+ db.TABLE_NAME +" LIMIT 1 ";

       
    }

    public void toHobbies(View v){
        //Intent to Friends
        Intent intent = new Intent(this, Hobbies.class);
        startActivityForResult(intent, 1);
    }

    public void toFriends(View v){
        //Intent to Friends
        Intent intent = new Intent(this, Friends.class);
        startActivityForResult(intent, 1);
    }

}