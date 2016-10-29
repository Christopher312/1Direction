package spherogame.spheroandroidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.content.*;

public class MakeTurnActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_turn);
    }

    public void makeTurn(View view) {
        //TODO: SEND COMMANDS TO THE F*ING ROBOT
        //TODO: test for victory conditions
        //TODO: send data to the MakeMove
        Intent intent = new Intent(this, MakeMoveActivity.class);
        startActivity(intent);
    }
}
