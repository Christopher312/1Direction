package spherogame.helloevent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.java.proxy.BezirkMiddleware;
import com.bezirk.middleware.messages.Event;
import java.awt.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
     class HelloWorldEvent extends Event {
        public String helloMessage = "Hi World, how are you?";
    }
}
