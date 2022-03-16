package com.example.gamestatetest;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Random;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 *
 * MainActivity class used to run our app on our tablet
 *
 * @author Trystan Wong
 * @author Kawika Suzuki
 * @author Mohammad Surur
 * @author Marcus Rison
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting the onclickListener for the button
        Button runTest = findViewById(R.id.runTestButton);
        runTest.setOnClickListener(this);

    }

    /**
     *
     * OnClick method to run the test of each function
     *
     *  External Citation
     *  Date: 15 March 2022
     *  Problem: Did not know how to append a string to an EditText TextView
     *  Resource: https://www.tutlane.com/tutorial/android/android-edittext-with-examples
     *  Solution: We were able to find the correct function to set the text of an EditText
     *
     * @param view - clickable view
     */
    @Override
    public void onClick(View view) {

        //first instance of the game state and a deep copy of the first instance
        GameState firstInstance = new GameState();
        GameState firstCopy = new GameState(firstInstance);

        int currentPlayer = firstInstance.getCurrentPlayer(); //current player used for the tests

        StringBuilder sb = new StringBuilder();

        //multiline EditText view to be appended
        EditText test = findViewById(R.id.test);
        test.clearComposingText();

        //calling the selectCard function
        boolean selectCard = firstInstance.selectCard();
        if(selectCard) {
            sb.append("Player " + currentPlayer + " selected " +
                    firstInstance.getCard(0,0)+"\n");
        }

        //calling the playCard function with the first card in player 0's hand
        boolean playCard = firstInstance.playCard(currentPlayer,
                firstInstance.getCard(currentPlayer,0));
        if(playCard) {
            sb.append("Player " + currentPlayer + " played " +
                    firstInstance.getCard(0,0)+"\n");
        }

        //calling the chooseAnte function
        boolean chooseAnte = firstInstance.chooseAnte(currentPlayer);
        if(chooseAnte){
            sb.append("Player " + currentPlayer + " chose Ante 1\n");
        }

        //calling the chooseOption
        boolean chooseOption = firstInstance.chooseOption(1,currentPlayer);
        if(chooseOption){
            sb.append("Player 1"+" is making a choice\n");
        }

        //calling the endTurn function if it's a valid move
        boolean endTurn = firstInstance.endTurn(currentPlayer);
        if(endTurn){
            sb.append("Player " + currentPlayer + " has ended their turn. \n");
        }

        //calling the forfeit function
        boolean forfeit = firstInstance.forfeit();
        if(forfeit){
            sb.append("Player " + currentPlayer + " forfeits\n");
        }

        //second Instance of the game state and a deep copy of the second instance
        GameState secondInstance = new GameState();
        GameState secondCopy = new GameState(secondInstance);


        //calling the toString method of each copy of the gameState to compare
        if(firstCopy.toString().equals(secondCopy.toString())){
            sb.append("Both Copies of the GameState are equal!\n");
            sb.append("FIRST COPY: \n"+firstCopy.toString()+"\n");
            sb.append("SECOND COPY: \n"+secondCopy.toString()+"\n");
        }


        //changing the text of the multiline editText
        test.setText(sb);


    }
}