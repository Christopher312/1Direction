package spherogame.spheroandroidapp; /**
 * Created by graceyyu on 10/29/16.
 */
import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.android.BezirkMiddleware;
import com.bezirk.middleware.messages.Event;

import java.util.ArrayList;

public class TurnEvent extends Event {
    private Bezirk bezirk;

    private static final double MAP_X = 50;
    private static final double MAP_Y = 50;
    private static final double SPHERO_X0 = 25;
    private static final double SPHERO_Y0 = 25;
    private static final double GOAL_LENGTH = 5;

    // private double angle;
    // private double distance;
    private ArrayList<Double[]> coords = new ArrayList<Double[]>();

    public TurnEvent(double[][] moves) {
        bezirk = BezirkMiddleware.registerZirk("macaronipenguins"); 
        double x = 0.0;
        double y = 0.0;
        for (int i = 0; i < moves.length; i++) {
            x += moves[i][1] * Math.cos(Math.toRadians(moves[i][0])); 
            y += moves[i][1] * Math.sin(Math.toRadians(moves[i][0]));
        }
        double angle = Math.atan(y / x);
        double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        // starting coords of Sphero
        double xCoord = SPHERO_X0;
        double yCoord = SPHERO_Y0;
        double tempDistance = distance;
        double tempAngle = angle;
        while (tempDistance > 0) {
            xCoord += Math.cos(tempAngle);
            yCoord += Math.sin(tempAngle);
            Double[] newCoords = new Double[2];
            newCoords[0] = xCoord;
            newCoords[1] = yCoord;
            coords.add(newCoords);
            tempDistance -= 1;
            // calculate collisions
            // left wall
            if (xCoord < 0) {
                if (tempAngle < 180) {
                    tempAngle = tempAngle - 90;
                }
                else {
                    tempAngle = 540 - tempAngle;
                }
            }
            // top wall
            if (yCoord > MAP_Y) {
                tempAngle = 360 - tempAngle;
            }
            // right wall
            if (xCoord > MAP_X) {
                if (tempAngle < 180) {
                    tempAngle = 360 - tempAngle;
                }
                else {
                    tempAngle = 540 - tempAngle;
                }
            }
            // bottom wall
            if (yCoord < 0) {
                if (tempAngle > 270) {
                    tempAngle = 360 - tempAngle;
                }
                else {
                    tempAngle = tempAngle - 90;
                }
            }
        }
    }

    public void scoredGoal(double x, double y) {
        double goalMinX = (MAP_X - GOAL_LENGTH) / 2;
        double goalMinY = (MAP_Y - GOAL_LENGTH) / 2;
        if (x == 0) {
            if ((goalMinY <= y) && (y <= goalMinY + GOAL_LENGTH)) {
                ScoreUpdateEvent event = new ScoreUpdateEvent(false, true, true, true);
                bezirk.sendEvent(event);
            }
        }
        if (y == 0) {
            if ((goalMinX <= x) && (x <= goalMinX + 5)) {
                ScoreUpdateEvent event = new ScoreUpdateEvent(true, true, true, false);
                bezirk.sendEvent(event);
            }
        }
        if (x == MAP_X) {
            if ((goalMinY <= y) && (y <= goalMinY + GOAL_LENGTH)) {
                ScoreUpdateEvent event = new ScoreUpdateEvent(true, true, false, true);
                bezirk.sendEvent(event);
            }
            if (y == MAP_Y) {
                if ((goalMinX <= x) && (x <= goalMinX + 5)) {
                    ScoreUpdateEvent event = new ScoreUpdateEvent(true, false, true, true);
                    bezirk.sendEvent(event);
                }
            }
        }
    }


    public ArrayList<Double[]> getCoords()
    {
        return coords;
    }
}
