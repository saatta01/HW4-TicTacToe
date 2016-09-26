package com.example.saraattarzadeh.tictactoe;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    final Context context = this;
    public String currentPlayer = "X";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClicked(View view) {
        final Button selectedButton = (Button) findViewById(view.getId());
        if(selectedButton.getText()== ""){
            selectedButton.setText(currentPlayer);
            String winner = evaluateWinner();
            if (winner == "X" || winner == "O")
            {
                //Toast toast = Toast.makeText(this, winner + " is the winner", Toast.LENGTH_SHORT);
                //toast.show();
                showAlert(winner + " is the winner");
            }
            else if (winner == "I") {
                if (currentPlayer == "X") {
                    Toast toast = Toast.makeText(this, "O's turn!", Toast.LENGTH_SHORT);
                    toast.show();
                    currentPlayer = "O";
                } else {
                    Toast toast = Toast.makeText(this, "X's turn!", Toast.LENGTH_SHORT);
                    toast.show();
                    currentPlayer = "X";
                }
            }
            else if (winner == "T") {
                //Toast toast = Toast.makeText(this, "It's a tie!", Toast.LENGTH_SHORT);
                //toast.show();
                showAlert("It's a tie!");
            }
        }

    }

    public void showAlert(String message)
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);

        // set title
        alertDialogBuilder.setTitle("Game Over");

        // set dialog message
        alertDialogBuilder
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton("Exit",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, close
                        // current activity
                        MainActivity.this.finish();
                    }
                });


        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }

    public String evaluateWinner() {
        if((getBtnText(R.id.rowOneLeft) == getBtnText(R.id.rowOneMiddle) && getBtnText(R.id.rowOneMiddle) == getBtnText(R.id.rowOneRight) && getBtnText(R.id.rowOneLeft) != "")
                || (getBtnText(R.id.rowTwoLeft) == getBtnText(R.id.rowTwoMiddle) && getBtnText(R.id.rowTwoMiddle) == getBtnText(R.id.rowTwoRight) && getBtnText(R.id.rowTwoLeft) != "")
                || (getBtnText(R.id.rowThreeLeft) == getBtnText(R.id.rowThreeMiddle) && getBtnText(R.id.rowThreeMiddle) == getBtnText(R.id.rowThreeRight) && getBtnText(R.id.rowThreeLeft) != "")
                || (getBtnText(R.id.rowOneLeft) == getBtnText(R.id.rowTwoLeft) && getBtnText(R.id.rowTwoLeft) == getBtnText(R.id.rowThreeLeft) && getBtnText(R.id.rowOneLeft) != "")
                || (getBtnText(R.id.rowOneMiddle) == getBtnText(R.id.rowTwoMiddle) && getBtnText(R.id.rowTwoMiddle) == getBtnText(R.id.rowThreeMiddle) && getBtnText(R.id.rowOneMiddle) != "")
                || (getBtnText(R.id.rowOneRight) == getBtnText(R.id.rowTwoRight) && getBtnText(R.id.rowTwoRight) == getBtnText(R.id.rowThreeRight) && getBtnText(R.id.rowOneRight) != "")
                || (getBtnText(R.id.rowOneLeft) == getBtnText(R.id.rowTwoMiddle) && getBtnText(R.id.rowTwoMiddle) == getBtnText(R.id.rowThreeRight) && getBtnText(R.id.rowOneLeft) != "")
                || (getBtnText(R.id.rowOneRight) == getBtnText(R.id.rowTwoMiddle) && getBtnText(R.id.rowTwoMiddle) == getBtnText(R.id.rowThreeLeft) && getBtnText(R.id.rowOneRight) != "")
        ){
            return currentPlayer;
        }
        else if (getBtnText(R.id.rowOneLeft) == "" || getBtnText(R.id.rowOneMiddle) == "" || getBtnText(R.id.rowOneRight) == ""
                || getBtnText(R.id.rowTwoLeft) == "" || getBtnText(R.id.rowTwoMiddle) == "" || getBtnText(R.id.rowTwoRight) == ""
                || getBtnText(R.id.rowThreeLeft) == "" || getBtnText(R.id.rowThreeMiddle) == "" || getBtnText(R.id.rowThreeRight) == "")
        {
            return "I";
        }
        else
        {
            return "T";
        }
    }

    public String getBtnText(Integer i) {
        final Button selectedButton = (Button) findViewById(i);
        return selectedButton.getText().toString();
    }
}
