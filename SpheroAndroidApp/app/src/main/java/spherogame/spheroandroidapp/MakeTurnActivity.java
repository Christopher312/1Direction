package spherogame.spheroandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

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
        player = 0;
        round = intent.getIntExtra("round", 0);
        angles = intent.getIntArrayExtra("angles");
        scores = intent.getIntArrayExtra("scores");
        distances = intent.getIntArrayExtra("distances");
    }

    public void makeTurn(View view) {
        //TODO: SEND COMMANDS TO THE F*ING ROBOT
        //TODO: check victory conditions
        if(round==rounds-1)
        {
            String victory = "Final Scores";
            for (int i = 1; i < scores.length; i++)
            {
                victory+="\nPlayer "+i+": "+scores[i];
            }
            TextView msg = new TextView(this);
            Button button = new Button(this);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), MenuActivity.class);
/*
                    intent.putExtra("players", players);
                    intent.putExtra("player", player);
                    intent.putExtra("rounds", rounds);
                    intent.putExtra("round", round);
                    intent.putExtra("angles", angles);
                    intent.putExtra("distances", distances);
                    intent.putExtra("scores", scores);
*/
                    startActivity(intent);
                }
            });
            msg.setText(victory);
            PopupWindow popup = new PopupWindow(this);
            LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
            LayoutParams.WRAP_CONTENT);
            LinearLayout containerLayout = new LinearLayout(this);
            containerLayout.setOrientation(LinearLayout.VERTICAL);
            containerLayout.addView(msg, layoutParams);
            containerLayout.addView(button, layoutParams);
            popup.setContentView(containerLayout);
            popup.showAtLocation(containerLayout, Gravity.BOTTOM, 10, 10);
            popup.update(50, 50, 320, 90);
        }
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
