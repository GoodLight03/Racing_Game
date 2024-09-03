package com.example.game_dua_xe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton play,continuegame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play=(ImageButton) findViewById(R.id.btplay);
        continuegame=(ImageButton)findViewById(R.id.continuegame);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(MainActivity.this,play_game.class);
                Bundle bd=new Bundle();
                bd.putInt("tien",50);
                it.putExtra("sotien",bd);
                startActivity(it);
            }
        });

        continuegame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(MainActivity.this,play_game.class);
                startActivity(it);
            }
        });
    }
}