package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class StartScreen extends AppCompatActivity {

    EditText edtName;
    RadioButton red;
    RadioButton black;
    RadioButton yes;
    RadioButton no;
    String playerColor;
    String computerColor;
    boolean playerTurn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        if (savedInstanceState != null) {

            String text = savedInstanceState.getString("text");
            if (edtName != null) {
                edtName.setText(text);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //TextView txvNumber = findViewById(R.id.txvNumber);
       // outState.putString("text", String.valueOf(edtName.getText()));
        //super.onSaveInstanceState(outState);
    }

    public void onRadioButtonClickedSymbol(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radioRed:
                if (checked)
                    red = findViewById(R.id.radioRed);
                playerColor = "Red";
                computerColor = "Black";
                break;
            case R.id.radioBlack:
                if (checked)
                    black = findViewById(R.id.radioBlack);
                playerColor = "Black";
                computerColor = "Red";
                break;
        }
    }

    public void onRadioButtonClickedMoveFirst (View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radioYes:
                if (checked)
                    yes = findViewById(R.id.radioYes);
                playerTurn = true;

                break;
            case R.id.radioNo:
                if (checked)
                    no = findViewById(R.id.radioNo);
                playerTurn = false;
                break;
        }
    }

    public void playClicked(View view) {
        EditText edtName = findViewById(R.id.edtName);

        Intent intent = new Intent(this, MainActivity.class);

        intent.putExtra("name", edtName.getText().toString());
        intent.putExtra("playerColor", playerColor);
        intent.putExtra("computerColor", computerColor);
        intent.putExtra("playerTurn", playerTurn);
        startActivity(intent);
    }

}
