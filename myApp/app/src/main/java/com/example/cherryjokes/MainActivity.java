package com.example.cherryjokes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // onClick setRandomJoke
        Button jokeButton = (Button) findViewById(R.id.jokeButton);
        TextView starter = (TextView)findViewById(R.id.jokeQuestion);
        starter.setText("Press for a random joke!");
        jokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAnswers();
            }
        });
    }

    private void openAnswers(){
        Intent intent = new Intent(this, answer.class);
        startActivity(intent);
    }

}
