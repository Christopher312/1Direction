package spherogame.spheroandroidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.content.*;

public class MakeTurnActivity extends AppCompatActivity {
    int players,rounds,player,round;
    int[] angles,distances,scores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_turn);
        Intent intent = getIntent();
        players = intent.getIntExtra("players", 4);
        rounds = intent.getIntExtra("rounds", 5);
        player = intent.getIntExtra("player", 0)+1;
        round = intent.getIntExtra("round", 0)+1;
        angles = intent.getIntArrayExtra("angles");
        scores = intent.getIntArrayExtra("scores");
        distances = intent.getIntArrayExtra("distances");
    }

    public void makeTurn(View view) {
        //TODO: SEND COMMANDS TO THE F*ING ROBOT
        //TODO: test for victory conditions
        //TODO: send data to the MakeMove
        Intent intent = new Intent(this, MakeMoveActivity.class);
        startActivity(intent);
    }
}
