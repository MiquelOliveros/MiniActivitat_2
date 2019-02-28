package com.example.miquel.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secundary_activity);
        String message = readParameters();
        controler(message);
    }

    private String readParameters() {
        Bundle data = this.getIntent().getExtras();
        int numRep = data.getInt("NumReps");
        String message = data.getString("ByeMess");

        String concatMess = message;
        for (int i = 1; i < numRep; i++) {
            concatMess = concatMess.concat(message);
        }

        TextView byeText = findViewById(R.id.textViewBye);
        byeText.setText(concatMess);

        return concatMess;
    }

    private void controler(String mess) {
        Button button = findViewById(R.id.button2);
        button.setOnClickListener(new Changer(mess));
    }

    private class Changer implements View.OnClickListener {
        String message;

        public Changer(String message) {
            this.message = message;
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.putExtra("Mess", this.message);
            startActivity(intent);
        }
    }
}
