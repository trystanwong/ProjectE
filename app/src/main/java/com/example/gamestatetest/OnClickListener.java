package com.example.gamestatetest;
import java.util.ArrayList;

import android.view.View;
import android.widget.TextView;

public class OnClickListener implements View.OnClickListener{

    public OnClickListener(){

    }
    @Override
    public void onClick(View view) {
        GameState firstInstance = new GameState();
        GameState firstCopy = new GameState(firstInstance);
        int currentPlayer = firstInstance.getCurrentPlayer();

        //playing the first card in the current players hand.
        boolean endTurn = firstInstance.endTurn(currentPlayer);
        //boolean playCard = firstInstance.playCard(currentPlayer,
                //firstInstance.getCard(currentPlayer,0));
        //boolean chooseAnte = firstInstance.chooseAnte();
    }
}
