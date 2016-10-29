package spherogame.spheroandroidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.content.*;

public class PassPhoneActivity extends AppCompatActivity {
    int players,rounds,player,round;
    int[] angles,distances,scores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_phone);
        Intent intent = getIntent();
        players = intent.getIntExtra("players", 4);
        rounds = intent.getIntExtra("rounds", 5);
        player = intent.getIntExtra("player", 0);
        round = intent.getIntExtra("round", 5);
        angles = intent.getIntArrayExtra("angles");
        scores = intent.getIntArrayExtra("scores");
        distances = intent.getIntArrayExtra("distances");
    }

    public void passPhone(View view) {
        Intent intent = new Intent(this, MakeMoveActivity.class);
        intent.putExtra("players", players);
        intent.putExtra("player", player);
        intent.putExtra("rounds", rounds);
        intent.putExtra("round", round);
        intent.putExtra("angles", angles);
        intent.putExtra("distances", distances);
        intent.putExtra("scores", scores);
        startActivity(intent);
    }
}
