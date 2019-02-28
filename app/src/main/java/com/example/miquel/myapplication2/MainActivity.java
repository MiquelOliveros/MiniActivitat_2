package com.example.miquel.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        readParameters();
        controler();
    }

    private void readParameters() {
        try {
            Bundle data = this.getIntent().getExtras();
            String message = data.getString(getString(R.string.messageKey));
            TextView text = findViewById(R.id.helloMessage);
            text.setText(message);
        } catch (Exception e){}
    }

    private void controler() {
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new Catcher());
    }

    private class Catcher implements View.OnClickListener {
        EditText editText1;
        EditText editText2;

        public Catcher() {
            this.editText1 = findViewById(R.id.byeMess);
            this.editText2 = findViewById(R.id.nRep);
        }

        @Override
        public void onClick(View v) {
            String message = this.editText1.getText().toString();
            if (message.isEmpty()) message = getString(R.string.defaultBye);

            String reps = this.editText2.getText().toString();
            if (reps.isEmpty()) reps = getString(R.string.defaultRep);
            int nReps = Integer.parseInt(reps);
            if (nReps > 50000) nReps = 10000;   //per evitar aturades en l'aplicació

            Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
            intent.putExtra(getString(R.string.mss), message);
            intent.putExtra(getString(R.string.rep), nReps);
            startActivity(intent);
        }
    }
}
