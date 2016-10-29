package spherogame.spheroandroidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import  android.widget.*;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void startGame()
    {
        EditText ET1 = (EditText) findViewById(R.id.players);
        int players = Integer.parseInt(ET1.getText().toString());
        EditText ET2 = (EditText) findViewById(R.id.rounds);
        int rounds = Integer.parseInt(ET2.getText().toString());
    }
}
