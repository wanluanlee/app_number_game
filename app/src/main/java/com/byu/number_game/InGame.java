package com.byu.number_game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.*;

import android.content.Intent;
import android.widget.Toast;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InGame extends AppCompatActivity {
    private int answer = 0000;
    private List<Integer> ans = getNumber();
    private boolean ifCorrect = false;
    private EditText guess;
    private Button button;
    private Button finishGame;
    private List<GuessResult> userResult = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_game);
        this.guess = findViewById(R.id.guess);
        //String temp = guess.getText().toString();
        //final int myGuess = Integer.parseInt(temp);
        button = (Button) findViewById(R.id.enterGuess);
        finishGame = (Button) findViewById(R.id.quit);
        finishGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(v.getContext(),EndGame.class);
                intent.putExtra("Result",Integer.toString(answer));
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ifAnsMatch(Integer.parseInt(guess.getText().toString())) == true)
                {
                    Intent intent  = new Intent(v.getContext(),EndGame.class);
                    intent.putExtra("Result",guess.getText().toString());
                    startActivity(intent);
                }

                else
                {
                    String result = getResult(Integer.parseInt(guess.getText().toString()));
                    GuessResult myResult = new GuessResult(guess.getText().toString(),result);
                    userResult.add(myResult);
                    initRecycleView();
                }

            }
        });

    }

    private void initRecycleView()
    {
        RecyclerView recyclerView = findViewById(R.id.RecyclerView);
        //Collections.reverse(userResult);
        RecycleviewAdaptor adaptor = new RecycleviewAdaptor(userResult);
        recyclerView.setAdapter(adaptor);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public List<Integer> getNumber()
    {
        List<Integer> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);

        Collections.shuffle(list);
        int d1 = list.get(0);
        ans.add(d1);
        int d2 = list.get(1);
        ans.add(d2);
        int d3 = list.get(2);
        ans.add(d3);
        int d4 = list.get(3);
        ans.add(d4);
        this.answer = d1*1000 + d2*100 + d3*10 + d4;

        return ans;

    }

    public String getResult(int guess)
    {
        List<Integer> guessDig;
        List<Integer> answer = ans;
        int numberCorrectNum = 0;
        int numberCorrecPosition = 0;

        //check the number of Num correct
        guessDig = toList(guess);

        for(int i = 0; i < answer.size(); ++ i)
        {
            if(answer.get(i) == guessDig.get(i))
            {
                numberCorrecPosition++;
                break;
            }

            for(int j = 0; j < guessDig.size(); ++j)
            {

                if(answer.get(i) == guessDig.get(j))
                {
                    numberCorrectNum++;
                }


            }


        }

        String result = numberCorrecPosition + "A" + numberCorrectNum + "B";

        return result;

    }

    public List<Integer> toList(int guess)
    {
        List<Integer> guessDig = new ArrayList<Integer>();

        while(guess > 0)
        {
            int digitGuess = guess % 10;
            guessDig.add(digitGuess);
            guess = guess / 10;

        }

        Collections.reverse(guessDig);

        return guessDig;
    }

    public boolean ifAnsMatch(int guess)
    {
        List<Integer> guessDig = toList(guess);
        if(ans.equals(guessDig))
        {
            return true;
        }

        else
        {
            return false;
        }

    }
}
