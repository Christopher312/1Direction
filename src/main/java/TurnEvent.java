/**
 * Created by graceyyu on 10/29/16.
 */
import com.bezirk.middleware.messages.Event;

public class TurnEvent {
    private double angle; 
    private double distance;

    public TurnEvent(double[][] moves) {
        double x = 0; 
        double y = 0; 
        for (int i = 0; i < moves.length; i++) {
            x += moves[i][1] * Math.cos(Math.toRadians(moves[i][0])); 
            y += moves[i][1] * Math.sin(Math.toRadians(moves[i][0]));
        }
        angle = Math.atan(y / x); 
        distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)); 
    }

    public double getAngle() {
        return angle;
    }

    public double getDistance() {
        return distance;
    }

    public String toString() {
        return "Angle: " + angle + ", Distance: " + distance;
    }
}
