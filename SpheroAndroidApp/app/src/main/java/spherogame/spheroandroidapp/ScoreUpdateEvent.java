/**
 * Created by graceyyu on 10/29/16.
 */
import com.bezirk.middleware.messages.Event;

public class ScoreUpdateEvent extends Event {
    private String scores;

    public ScoreUpdateEvent(boolean p1, boolean p2, boolean p3, boolean p4) {
        if (p1)
            scores = "0111";
        if (p2)
            scores = "1011";
        if (p3)
            scores = "1101";
        if (p4)
            scores = "1110";
    }

    public String getScores() {
        return scores;
    }

}
