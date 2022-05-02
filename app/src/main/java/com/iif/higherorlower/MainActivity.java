package com.iif.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int random;

    public void generateRandomNumber(){
        Random rand = new Random();
        random = rand.nextInt(20) + 1;
    }


    public void guessFunction(View view){


        EditText userNumberEditText =  findViewById(R.id.userNumberEditText);
        int finalUserNumber = Integer.parseInt(userNumberEditText.getText().toString());

        String message;


        if(finalUserNumber > random){
            message = "Lower";
        }else if (finalUserNumber < random){
            message = "Higher";
        } else {
            message = "You got it right, Try again";
            generateRandomNumber();
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        Log.i("random Number", Integer.toString(random));

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateRandomNumber();
    }
}