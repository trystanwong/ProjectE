package com.example.gamestatetest;
import java.util.ArrayList;

import android.view.View;

public class OnClickListener implements View.OnClickListener{

    private GameState tda;

    public OnClickListener(ArrayList deck){

        tda = new GameState(deck);

    }
    @Override
    public void onClick(View view) {

    }
}
