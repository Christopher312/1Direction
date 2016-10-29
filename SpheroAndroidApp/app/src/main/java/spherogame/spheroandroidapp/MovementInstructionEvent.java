package spherogame.spheroandroidapp;

import com.bezirk.middleware.messages.Event;

public class MovementInstructionEvent extends Event {
    public int[] angles;
    public int[] distances;
    public void setAngles(int[] ang)
    {
        this.angles = ang;
    }
    public void setDists(int[] dist)
    {
        this.distances = dist;
    }
}
