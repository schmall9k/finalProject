package com.example.finalproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    String playerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        Intent intent = getIntent();

        playerName = intent.getStringExtra("name");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.addProfilePic:
                Intent intent = new Intent(this, AddProfilePicture.class);
                this.startActivity(intent);
                return true;

            case R.id.restart:
                Intent intent1 = new Intent(this, Restart.class);
                this.startActivity(intent1);
                return true;

            case R.id.changePieceColor:
                Intent intent2 = new Intent(this, changePlayerColor.class);
                this.startActivity(intent2);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.button_40:
                // winning move
                playerWon();

            case R.id.button_44:
                // winning move
                playerWon();
        }
    }

    public void playerWon()
    {
        String alert1 = "Congratulations, " + this.playerName +"! You won!";

        //Toast.makeText(this, "Player wins!", Toast.LENGTH_SHORT).show();
        AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
        builder1.setTitle("TicTacToe Play is over");
        builder1.setMessage(alert1);
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Play Again",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        Intent intent = new Intent(MainActivity.this, MainActivity.class);
                    }
                });

        builder1.setNegativeButton(
                "End Game",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        //Intent intent = new Intent(MainActivity.this, DisplayTopPlayers.class); // need the new class name

                        //intent.putExtra("playerName", playerName);
                        //startActivity(intent);

                    }
                });
        AlertDialog alert11 = builder1.create();
        alert11.show();
    }
}
