package spherogame.spheroandroidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.math.*;
import android.widget.*;
import android.view.*;
import android.content.*;

public class MakeMoveActivity extends AppCompatActivity {
    int players,rounds,player,round;
    int[] angles,distances,scores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_move);
        int card = (int) (Math.random()*6);
        TextView cardText = (TextView) findViewById(R.id.textView5);
        String s = getString(R.string.card) + card;
        cardText.setText(s);
        Intent intent = getIntent();
        players = intent.getIntExtra("players", 4);
        rounds = intent.getIntExtra("rounds", 5);
        player = intent.getIntExtra("player", 0)+1;
        round = intent.getIntExtra("round", 0);
        angles = intent.getIntArrayExtra("angles");
        scores = intent.getIntArrayExtra("scores");
        distances = intent.getIntArrayExtra("distances");

        TextView playerNum = (TextView) findViewById(R.id.textView3);
        playerNum.setText(getString(R.string.player) + player);

        TextView roundNum = (TextView) findViewById(R.id.MMrounds);
        roundNum.setText(getString(R.string.round) + round);

        TextView scoreView = (TextView) findViewById(R.id.textView4);
        scoreView.setText("");
        for(int i=0;i<players;i++)
            scoreView.append("Player " + i + ": " + scores[i] + "\n");
        int r = round+1;
        roundNum.setText(getString(R.string.round) + r);
    }

    public void finishTurn(View view) {
        int angle = Integer.parseInt(((EditText) findViewById(R.id.editText)).getText().toString());
        angles[player]=angle;
        int distance = Integer.parseInt(((EditText) findViewById(R.id.editText2)).getText().toString());
        distances[player]=distance;
        if(player==players-1)
        {
            Intent intent = new Intent(this, MakeTurnActivity.class);
            intent.putExtra("players", players);
            intent.putExtra("player", player);
            intent.putExtra("rounds", rounds);
            intent.putExtra("round", round);
            intent.putExtra("angles", angles);
            intent.putExtra("distances", distances);
            intent.putExtra("scores", scores);
            startActivity(intent);
        }
        else
        {
            Intent intent = new Intent(this, PassPhoneActivity.class);
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
}
