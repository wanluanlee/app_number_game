package com.byu.number_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EndGame extends AppCompatActivity {
    private TextView result;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);
        Intent intent = getIntent();
        result = findViewById(R.id.ans);
        String answer = intent.getStringExtra("Result");
        String display = "The answer is: "+answer;
        result.setText(display);
        button = (Button) findViewById(R.id.startGame);
        button.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(v.getContext(),InGame.class);
                startActivity(intent);

            }
        });

    }
}
