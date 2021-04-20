package com.example.activity14;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Hobbies extends AppCompatActivity {

    private EditText Hobbie;
    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hobbies);

        db = DBHelper.getInstance(this);
        Hobbie = findViewById(R.id.hobbyET);
    }



    public void updateHobbie(View v){
        String hobbiestr = Hobbie.getText().toString();
        boolean actualizado = db.updateDataHobbie(hobbiestr);
        if(actualizado){
            Toast.makeText(this, "Funciono", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "No Funciono", Toast.LENGTH_SHORT).show();
        }
    }
}