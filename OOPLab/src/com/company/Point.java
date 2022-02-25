package com.company;

public class Point
{
    private double x;
    private double y;
    private double z;

    public Point()
    {
        x = y = z = 0;
    }
    //пустой конструктор

    public void setx(double x)
    {
        this.x = x;
    }
    public void sety(double y)
    {
        this.y = y;
    }
    public void setz(double z)
    {
        this.z = z;
    }
    //сеттеры

    public double getx()
    {
        return x;
    }
    public double gety()
    {
        return y;
    }
    public double getz()
    {
        return z;
    }
    //геттеры

    public Point(double x, double y, double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    //конструктор с параметрами

    public boolean areonLine(Point b, Point c)
    {
        double ab_x = b.x - this.x;
        double ab_y = b.y - this.y;
        double ab_z = b.z - this.z;
        double ac_x = c.x - this.x;
        double ac_y = c.y - this.y;
        double ac_z = c.z - this.z;
        if ((ab_x / ac_x) == (ab_y / ac_y))
        {
            if ((ab_x / ac_x) == (ab_z / ac_z))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
    //лежат ли три точки на одной прямой
}