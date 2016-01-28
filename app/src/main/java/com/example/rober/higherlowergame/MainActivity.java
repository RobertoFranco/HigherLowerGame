package com.example.rober.higherlowergame;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int attempts;
    private int randomNumber;

    private EditText inputNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //Random Number
        this.randomNumber = (int)(Math.random() * 20);

        //Texto of attempts
        final TextView atemptsTxt = (TextView)findViewById(R.id.attempts);

        //Button
        final Button btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //Input number
                inputNumber = (EditText)findViewById(R.id.InputNumber);

                //
                attempts++;
                atemptsTxt.setText("You have tried " + attempts + " times.");

                //
                btn.setText("Guess it!");

                if (Integer.parseInt(inputNumber.getText().toString()) == randomNumber){
                    Toast.makeText(MainActivity.this, "You won in the " + attempts +" attempt.", Toast.LENGTH_LONG).show();
                    randomNumber = (int)(Math.random() * 20);
                    attempts = 0;

                    btn.setText("Play again?");
                    atemptsTxt.setText("You have tried 0 times.");

                }

                if (Integer.parseInt(inputNumber.getText().toString()) > randomNumber)
                    Toast.makeText(MainActivity.this, "Higher.", Toast.LENGTH_LONG).show();

                if (Integer.parseInt(inputNumber.getText().toString()) < randomNumber)
                    Toast.makeText(MainActivity.this, "Lower.", Toast.LENGTH_LONG).show();



            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
