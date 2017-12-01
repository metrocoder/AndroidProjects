package com.metrocoder.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * <h1>This is the lovely game of Tic Tac Toe but w/o Xs and Os!</h1>
 * The game is simple. Just get three like colored pieces in a
 * row and your the winner. This game is two or one player and has
 * unlimited plays. Have Fun!
 *
 * @author  Edwin Feliberty Jr.
 * @version 1.0
 * @since   2017-12-01
 */
public class MainActivity extends AppCompatActivity {

    /**
     * This is the default method created when you have an Activity in
     * an Android App.
     * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    /*Count - is used to keep track of the turns in the game*/
    private int count = 0;

    /*Board - is a 1D representation of the boars and what pieces
    * are in a given area of the board
    * */
    private int[] board = {2,2,2,2,2,2,2,2,2};

    /*Winning - is a 2D integer matrix that stores all the winning positions possible
    * for the game.
    * */
    private int[][] winning = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    /**
    * This is the method that is called when a user selects a cell in the grid
     * to place their piece in on the grid. This method keeps track of the number
     * of turns taken, decides if there is a winner or draw and takes the appropriate
     * actions.
     *
     * @param view is the object that called on the method turn
     *
    * */
    public void turn(View view)
    {
        final int blue =0, red = 1;
        ImageView current = (ImageView) view;//This gets the imageview that triggered the method call
        current.setTranslationY(-1000f);//Sets our image to start beyond the top of our screen
        int sq = Integer.parseInt(current.getTag().toString());
        //^-- Gets the tag associated with the imageview to know where on the board we clicked


        if (count<9)//Checks that we haven't exceeded the amount of turns possible
        {
            if (count % 2 == 0)//Drops the appropriate piece based on the turn.
            {
                current.setImageResource(R.drawable.blue);//Sets the selected image view to the correct piece
                board[sq] = blue;//Updates the 1d Matrix with its binary representation
            }
            else
            {
                current.setImageResource(R.drawable.red);//Sets the selected image view to the correct piece
                board[sq] = red;//Updates the 1d Matrix with its binary representation
            }


            String winner;
            current.animate().translationYBy(1000f).rotation(1080).setDuration(600);
            //Sets an animation to drop the piece down while its spinning into place.
            for (int[] i :winning)//Loop through our 2D array
            {
                /*This section checks the 1D board with the potential moves that
                * can result in a win
                * */
                if(board[i[0]] == board[i[1]] && board[i[0]] == board[i[2]]&& board[i[1]] == board[i[2]] && (board[i[0]]!=2 && board[i[1]]!=2 && board[i[2]]!=2))
                {
                    /*
                    * This if/else declares the winner in a String
                    * */
                    if (board[i[0]]==blue)
                        winner="Blue";
                    else
                        winner="Red";

                    /*
                    * A Toast is displayed with the result of the winning move
                    * */
                    Toast.makeText(this,winner + " is the Winner!", Toast.LENGTH_LONG).show();


                    /*
                    * This section displays our button to allow the user to PLAY AGAIN
                    * */
                    LinearLayout layout = findViewById(R.id.newLayout);
                    layout.setVisibility(View.VISIBLE);
                }
            }

            count++;//Increment our turn
        }

        if (count==9)//If there are no winning moves and no more empty spaces allow them to play again.
        {
            Toast.makeText(this, "Draw ... Try again", Toast.LENGTH_LONG).show();
            LinearLayout layout = findViewById(R.id.newLayout);

            layout.setVisibility(View.VISIBLE);
        }
    }


    /**
     * This method can only be called on by a button that will only
     * be displayed if there is a DRAW or a Winner.
     * @param view is the object that called the method.
     * */
    public void restart(View view)
    {

        /*After the PLAY AGAIN button has been pressed reset the counter,
        * the 1D board, the pieces on the board
        * and hide the play again option
        * */
        LinearLayout layout = findViewById(R.id.newLayout);
        layout.setVisibility(View.INVISIBLE);
        count=0;
        for (int i=0; i<board.length;i++)
        {
            board[i]=2;
        }


        /*This section is to loop through the Grid, access its child elements
        * and manipulate it accordingly.
        * */
        GridLayout replace = findViewById(R.id.grid);
        for (int i =0;i<replace.getChildCount();i++)
        {
            ((ImageView)replace.getChildAt(i)).setImageResource(0);
        }
    }
}
