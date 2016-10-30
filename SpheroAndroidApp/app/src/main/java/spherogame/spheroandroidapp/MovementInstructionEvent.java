package spherogame.spheroandroidapp;

import com.bezirk.middleware.messages.Event;

public class MovementInstructionEvent extends Event {
    public int[] angles;
    public int[] distances;

    public int[] getAngles()
    {
        return this.angles;
    }
    public int[] getDists()
    {
        return this.distances;
    }
    public void setAngles(int[] ang)
    {
        this.angles = ang;
    }
    public void setDists(int[] dist)
    {
        this.distances = dist;
    }
}
