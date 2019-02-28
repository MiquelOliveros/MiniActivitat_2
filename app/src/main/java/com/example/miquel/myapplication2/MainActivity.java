package com.example.miquel.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controler();
    }

    private void controler() {
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new Catcher());
    }

    private class Catcher implements View.OnClickListener {
        EditText editText1;
        EditText editText2;

        public Catcher() {
            editText1 = findViewById(R.id.byeMess);
            editText2 = findViewById(R.id.nRep);
        }

        @Override
        public void onClick(View v) {
            String message = editText1.getText().toString();
            String reps = editText2.getText().toString();
            int nReps = Integer.parseInt(reps);

            Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
            intent.putExtra("ByeMess", message);
            intent.putExtra("NumReps", nReps);
            startActivity(intent);
        }
    }
}
