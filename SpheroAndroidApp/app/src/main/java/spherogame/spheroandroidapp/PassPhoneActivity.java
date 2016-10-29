package spherogame.spheroandroidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.content.*;

public class PassPhoneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_phone);
    }

    public void passPhone(View view) {
        Intent intent = new Intent(this, MakeMoveActivity.class);
        startActivity(intent);
        //TODO: relay the data
    }
}
