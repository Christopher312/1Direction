package spherogame.spheroandroidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.math.*;
import android.widget.*;
import android.view.*;
import android.content.*;

public class MakeMoveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_move);
        int card = (int) (Math.random()*6);
        TextView cardText = (TextView) findViewById(R.id.textView5);
        String s = getString(R.string.card) + card;
        cardText.setText(s);
        Intent intent = getIntent();
        int players = intent.getIntExtra("players", 4);
        int rounds = intent.getIntExtra("rounds", 5)-1;
        TextView TV1 = (TextView) findViewById(R.id.MMround);
        TV1.setText("Round "+rounds);
        TextView TV2 = (TextView) findViewById(R.id.MMplayers);
        TV2.setText("Players"+players);
    }

    public void FinishTurn(View view) {
        int angle = Integer.parseInt(((EditText) findViewById(R.id.editText)).getText().toString());
        int distance = Integer.parseInt(((EditText) findViewById(R.id.editText2)).getText().toString());
        Intent intent = new Intent(this, PassPhoneActivity.class);
        startActivity(intent);
        TextView TV1 = (TextView) findViewById(R.id.MMround);
        int rounds = Integer.parseInt(TV1.getText().toString());
        //TODO: Send data
    }
}
