package com.example.cherryjokes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class answer extends AppCompatActivity {

    private Map<String, String> jokes;
    private int jokeIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        final String[] jokeQuestions = {
                "What's the best thing about Switzerland?",
                "Why do we tell actors to \"break a leg?\"",
                "How many times can you subtract 10 from 100?"
        };
        final String[] jokeAnswers = {
                "I don't know, but the flag is a big plus.",
                "Because every play has a cast.",
                "Once. The next time you would be subtracting 10 from 90."
        };

        jokes = new HashMap<>();

        for (int i = 0; i < jokeQuestions.length; i++) {
            jokes.put(jokeQuestions[i], jokeAnswers[i]);
        }

        Button answerButton = (Button)findViewById(R.id.answer);
        TextView joke = (TextView)findViewById(R.id.joke);
        joke.setText(setRandomJoke(jokeQuestions));
        answerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView jokeAnswer = (TextView)findViewById(R.id.joke);
                jokeAnswer.setText(jokeAnswers[jokeIndex]);
            }
        });

        Button printButton = (Button)findViewById(R.id.print);
        printButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printJoke(jokeQuestions[jokeIndex],jokeAnswers[jokeIndex]);
            }
        });
    }

    /**
     * TODO: Set the string values to the button in UI.
     * */
    private String setRandomJoke(String[] jokeQuestions) {
        Random rand = new Random();
        int upperBound = jokes.size();
        int randIndex = rand.nextInt(upperBound);
        jokeIndex = randIndex;
        String randQuestion = jokeQuestions[randIndex];
        return randQuestion;
    }

    private void printJoke(String jokeQuestion, String jokeAnswer) {
        List<String> jokeToPrint = new ArrayList<>();
        jokeToPrint.add(jokeQuestion);
        jokeToPrint.add(jokeAnswer);

        BrotherPrint printManager = new BrotherPrint();
        Bitmap imageToPrint = printManager.textAsBitmap(jokeToPrint, 48, Color.BLACK);
        printManager.print(imageToPrint);
    }
}
