package com.example.cherryjokes;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Map<String, String> jokes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        for (int i = 0; i < jokeQuestions.length; i++) {
            jokes.put(jokeQuestions[i], jokeAnswers[i]);
        }

        // onClick setRandomJoke
        Button jokeButton = (Button) findViewById(R.id.jokeButton);
        TextView starter = (TextView)findViewById(R.id.jokeQuestion);
        starter.setText("Press for a random joke!");
        jokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView jokeQuestion = (TextView)findViewById(R.id.jokeQuestion);
                jokeQuestion.setText(setRandomJoke(jokeQuestions));
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
