package model;

public class Coordinates
{
    private float x;
    private double y;

    public void setX( float x) {
        this.x = x;
    }

    public void setY( double y) {
        this.y = y;
    }

    public Coordinates( float x,  double y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates() {
    }

    public String write(int in) {
        if(in==1)return "x=\"" + x + "\" y=\"" + y+'\"' ;
        return "x=" + x + " y=" + y ;
    }
}
