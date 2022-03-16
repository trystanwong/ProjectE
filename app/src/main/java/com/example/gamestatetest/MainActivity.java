package com.example.gamestatetest;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Random;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GameState firstInstance = new GameState();
        GameState firstCopy = new GameState(firstInstance);

        OnClickListener oc = new OnClickListener();
        Button runTest = findViewById(R.id.runTestButton);
        runTest.setOnClickListener(oc);

        System.out.println(firstCopy);

    }


    @Override
    public void onClick(View view) {
        GameState firstInstance = new GameState();
        GameState firstCopy = new GameState(firstInstance);
        int currentPlayer = firstInstance.getCurrentPlayer();

        //playing the first card in the current players hand.
        boolean endTurn = firstInstance.endTurn(currentPlayer);
        boolean playCard = firstInstance.playCard(currentPlayer,
                firstInstance.getCard(currentPlayer,0));
        //boolean chooseAnte = firstInstance.chooseAnte();
    }
}