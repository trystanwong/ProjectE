package com.example.gamestatetest;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Random;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OnClickListener oc = new OnClickListener();
        Button runTest = findViewById(R.id.runTestButton);
        runTest.setOnClickListener(oc);

        ArrayList<Card> deck = new ArrayList<>();
        GameState firstInstance = new GameState(deck);
        GameState firstCopy = new GameState(firstInstance);


    }
}