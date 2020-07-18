package com.example.biggernumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int r1,r2;
    private int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        randomGen();
    }
    private void randomGen(){
        if (count<0){
            Toast.makeText(this, "You lost!!!!!!!", Toast.LENGTH_SHORT).show();
            TextView res= findViewById(R.id.result);
            res.setText("Point - 0");
            count =0;
        }
        Random rand = new Random();

        r1 = rand.nextInt(1000);
        r2 = rand.nextInt(1000);
        while (r1== r2){
            r2 = rand.nextInt(1000);
        }
        Button b1 = findViewById(R.id.leftButton);
        Button b2 = findViewById(R.id.rightButton);

        b1.setText(Integer.toString(r1));
        b2.setText(Integer.toString(r2));
    }
    public void onClickLeft(View view){
        if(r1>r2){
            count++;
        }
        else{
            count--;
        }
        TextView res= findViewById(R.id.result);
        res.setText(Integer.toString(count));
        randomGen();
    }
    public void onClickRight(View view){
        if(r1<r2){
            count++;
        }
        else{
            count--;
        }
        TextView res= findViewById(R.id.result);
        res.setText(Integer.toString(count));
        randomGen();
    }
}