package com.company;

public class Flat
{
    private double a;
    private double b;
    private double c;
    private double d;

    public Flat()
    {
        a = b = c = d = 0;
    }
    //пустой конструктор

    public void seta(double a)
    {
        this.a = a;
    }
    public void setb(double b)
    {
        this.b = b;
    }
    public void setc(double c)
    {
        this.c = c;
    }
    public void setd(double d)
    {
        this.d = d;
    }
    //сеттеры

    public double geta()
    {
        return a;
    }
    public double getb()
    {
        return b;
    }
    public double getc()
    {
        return c;
    }
    public double getd()
    {
        return d;
    }
    //геттеры

    public Flat(double a, double b, double c, double d)
    {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    //конструктор с параметрами

    public Flat(Point a, Point b, Point c)
    {
        double ax = a.getx();
        double ay = a.gety();
        double az = a.getz();
        double bx = b.getx();
        double by = b.gety();
        double bz = b.getz();
        double cx = c.getx();
        double cy = c.gety();
        double cz = c.getz();
        this.a = ((by - ay) * (cz - az) - (bz - az) * (cy - ay));
        this.b = - ((bx - ax) * (cz - az) - (bz - az) * (cx - ax));
        this.c = ((bx - ax) * (cy - ay) - (by - ay) * (cx - ax));
        this.d = - this.a * ax - this.b * ay - this.c * az;
    }
    //создание плоскости по трем точкам

    public double PointtoFlat(Point e)
    {
        double x = e.getx();
        double y = e.gety();
        double z = e.getz();
        double ans1 = a * x + b * y + c * z + d;
        if (ans1 < 0)
        {
            ans1 = - ans1;
        }
        double ans2 = a * a + b * b + c * c;
        ans2 = Math.sqrt(ans2);
        return (ans1 / ans2);
    }
    //расстояние от точки до плоскости

    public double FlattoFlat(Flat e)
    {
        double ans1 = this.a * e.a + this.b * e.b + this.c * e.c;
        if (ans1 < 0)
        {
            ans1 = - ans1;
        }
        double ans2 = Math.sqrt((e.a * e.a + e.b * e.b + e.c * e.c) * (this.a * this.a + this.b * this.b + this.c * this.c));
        return Math.toDegrees(Math.acos(ans1 / ans2));
    }
    //угол между плоскостями

    public boolean parallFlat(Flat e)
    {
        if (FlattoFlat(e) == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    //параллельность плоскостей

    public boolean perpendFlat(Flat e)
    {
        if (FlattoFlat(e) == 90)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    //перпендикулярность плоскостей

    public Flat createFlat(Point e)
    {
        double x = e.getx();
        double y = e.gety();
        double z = e.getz();
        double D = - this.a * x - this.b * y - this.c * z;
        Flat parall = new Flat(a, b, c, D);
        return parall;
}
    //строить плоскость, параллельную данной через заданную точку

    public void printFlat()
    {
        System.out.print(a + "x ");
        if (b < 0)
        {
            System.out.print(b + "y ");
        }
        else
        {
            System.out.print("+ " + b + "y ");
        }
        if (c < 0)
        {
            System.out.print(c + "z ");
        }
        else
        {
            System.out.print("+ " + c + "z ");
        }
        if (d < 0)
        {
            System.out.print(d + " = 0");
        }
        else
        {
            System.out.print("+ " + d + " = 0");
        }
    }
    //вывод уравнения плоскости
}