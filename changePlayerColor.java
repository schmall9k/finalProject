package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;

public class changePlayerColor extends AppCompatActivity {

    String color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_player_color);

        getIntent();

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void onRadioButtonClickedColorChange(View view)
    {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId())
        {
            case R.id.radioRed:
                if (checked)
                {
                    color = "red";
                }
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("red", color);
                this.startActivity(intent);
                break;

            case R.id.radioBlue:
                if (checked)
                {
                    color = "blue";
                }
                Intent intent1 = new Intent(this, MainActivity.class);
                intent1.putExtra("blue", color);
                this.startActivity(intent1);
                break;

            case R.id.radioGreen:
                if (checked)
                {
                    color = "green";
                }
                Intent intent2 = new Intent(this, MainActivity.class);
                intent2.putExtra("green", color);
                this.startActivity(intent2);
                break;

        }
    }

}
