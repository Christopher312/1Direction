package spherogame.spheroandroidapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import  android.widget.*;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void startGame(View view)
    {
        EditText ET1 = (EditText) findViewById(R.id.players);
        EditText ET2 = (EditText) findViewById(R.id.rounds);
        int players = Integer.parseInt(ET1.getText().toString());
        int player = 0;
        int rounds = Integer.parseInt(ET2.getText().toString());
        int round = 0;
        int[] angles = new int[players];
        int[] distances = new int[players];
        int[] scores = new int[players];
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
