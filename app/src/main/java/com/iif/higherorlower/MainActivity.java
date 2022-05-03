package com.iif.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;
    private long num;

    public long generateRandomNumber(){
        Random rand = new Random();
        long random = rand.nextInt(20) + 1;
        return random;
    }


    public void guessFunction(long random, long finalUserNumber){

        String message;

        if(finalUserNumber > random){
            message = "Lower";
        }else if (finalUserNumber < random){
            message = "Higher";
        } else {
            message = "You got it right, Try again";
            num = generateRandomNumber();

        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        Log.i("random Number", Integer.toString((int) random));

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num = generateRandomNumber();

        editText = (EditText) findViewById(R.id.userNumberEditText);
        button = (Button) findViewById(R.id.myBtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = editText.getText().toString();


                if(!TextUtils.isEmpty(number)){
                    int x = Integer.parseInt(number);
                    guessFunction(num,x);
                }else {
                    Toast.makeText(MainActivity.this, "enter a guess!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}