package com.example.activity14;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.activity14.MainActivity.*;

public class Friends extends AppCompatActivity {

    private EditText name,
                     hobbie;
    private DBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);
        db = DBHelper.getInstance(this);

        name = findViewById(R.id.friendName);
        hobbie = findViewById(R.id.friendHobbie);

    }

    public void save(View v){
        String namestr = name.getText().toString();
        String hobbiestr = hobbie.getText().toString();
        boolean insertado = db.insertData(namestr, hobbiestr);
        if(insertado){
            Toast.makeText(this, "Funciono", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "No Funciono", Toast.LENGTH_SHORT).show();
        }
    }

    //Se busca el primer con nombre
    public void search(View v){
        String namestr = name.getText().toString();
        String hobbiestr = hobbie.getText().toString();
        boolean actualizado = db.updateData(namestr, hobbiestr);
        if(actualizado){
            Toast.makeText(this, "Funciono", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "No Funciono", Toast.LENGTH_SHORT).show();
        }
    }


    //Se borrran todos los de ese nombre
    public void delete(View v){
        String namestr = name.getText().toString();
        boolean actualizado = db.deleteData(namestr);
        if(actualizado){
            Toast.makeText(this, "Funciono", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "No Funciono", Toast.LENGTH_SHORT).show();
        }
    }


}