package com.company;

import java.util.Scanner;
import java.util.ArrayList;

public class Main
{
    public static double getnum()
    {
        int flag = 0;
        double x = 0;
        while (flag == 0)
        {
            Scanner in = new Scanner(System.in);
            if (in.hasNextDouble())
            {
                x = in.nextDouble();
                flag++;
            }
            else
            {
                System.out.println("Нужно ввести число.");
                String tmp = in.nextLine();
            }
        }
        return x;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        ArrayList<Flat> flats = new ArrayList<>();
        Flat F1;
        Flat F2;
        Point ex;

        System.out.println("Введите 1, если плоскость задана параметрически, или 2, если набором из трех точек:");
        double pl1 = -1;
        while ((pl1 != 1) && (pl1 != 2))
        {
            pl1 = getnum();
            if ((pl1 != 1) && (pl1 != 2))
            {
                System.out.println("Нужно ввести либо цифру 1, либо цифру 2.\n");
            }
        }

        String tmp = in.nextLine();
        String[] a = tmp.trim().split(" +");
        if (pl1 == 1)
        {
            if (a.length < 4)
            {
                System.out.println("Недостаточно параметров для задания плоскости.\n");
                return;
            }
            try
            {
                if ((Double.parseDouble(a[0]) ==  0) && (Double.parseDouble(a[1]) == 0) && (Double.parseDouble(a[2]) == 0))
                {
                    System.out.println("Такой плоскости не существует.");
                    return;
                }
                Flat A = new Flat(Double.parseDouble(a[0]), Double.parseDouble(a[1]), Double.parseDouble(a[2]), Double.parseDouble(a[3]));
                flats.add(A);
            }
            catch (Exception e)
            {
                System.out.println("Параметры плоскости должны иметь числовой формат.\n");
                return;
            }
        }
        else
        {
            if (a.length < 9)
            {
                System.out.println("Недостаточно параметров для задания трех точек.\n");
                return;
            }
            Point p1 = new Point();
            Point p2 = new Point();
            Point p3 = new Point();
            try
            {
                p1.setx(Double.parseDouble(a[0]));
                p1.sety(Double.parseDouble(a[1]));
                p1.setz(Double.parseDouble(a[2]));
                p2.setx(Double.parseDouble(a[3]));
                p2.sety(Double.parseDouble(a[4]));
                p2.setz(Double.parseDouble(a[5]));
                p3.setx(Double.parseDouble(a[6]));
                p3.sety(Double.parseDouble(a[7]));
                p3.setz(Double.parseDouble(a[8]));
                if (p1.areonLine(p2, p3))
                {
                    System.out.println("Точки лежат на одной прямой.\n");
                    return;
                }
                Flat A = new Flat(p1, p2, p3);
                flats.add(A);
            }
            catch (Exception e)
            {
                System.out.println("Координаты точек должны иметь числовой формат.\n");
                return;
            }
        }

        System.out.println("\nУравнение 1 плоскости:");
        F1 = flats.get(0);
        F1.printFlat();

        System.out.println("\nВведите 1, если плоскость задана параметрически, или 2, если набором из трех точек:");
        double pl2 = -1;
        while ((pl2 != 1) && (pl2 != 2))
        {
            pl2 = getnum();
            if ((pl2 != 1) && (pl2 != 2))
            {
                System.out.println("Нужно ввести либо цифру 1, либо цифру 2.\n");
            }
        }

        tmp = in.nextLine();
        a = tmp.trim().split(" +");
        if (pl2 == 1)
        {
            if (a.length < 4)
            {
                System.out.println("Недостаточно параметров для задания плоскости.\n");
                return;
            }
            try
            {
                if ((Double.parseDouble(a[0]) ==  0) && (Double.parseDouble(a[1]) == 0) && (Double.parseDouble(a[2]) == 0))
                {
                    System.out.println("Такой плоскости не существует.");
                    return;
                }
                Flat B = new Flat(Double.parseDouble(a[0]), Double.parseDouble(a[1]), Double.parseDouble(a[2]), Double.parseDouble(a[3]));
                flats.add(B);
            }
            catch (Exception e)
            {
                System.out.println("Параметры плоскости должны иметь числовой формат.\n");
                return;
            }
        }
        else
        {
            if (a.length < 9)
            {
                System.out.println("Недостаточно параметров для задания трех точек.\n");
                return;
            }
            Point p1 = new Point();
            Point p2 = new Point();
            Point p3 = new Point();
            try
            {
                p1.setx(Double.parseDouble(a[0]));
                p1.sety(Double.parseDouble(a[1]));
                p1.setz(Double.parseDouble(a[2]));
                p2.setx(Double.parseDouble(a[3]));
                p2.sety(Double.parseDouble(a[4]));
                p2.setz(Double.parseDouble(a[5]));
                p3.setx(Double.parseDouble(a[6]));
                p3.sety(Double.parseDouble(a[7]));
                p3.setz(Double.parseDouble(a[8]));
                if (p1.areonLine(p2, p3))
                {
                    System.out.println("Точки лежат на одной прямой.\n");
                    return;
                }
                Flat B = new Flat(p1, p2, p3);
                flats.add(B);
            }
            catch (Exception e)
            {
                System.out.println("Координаты точек должны иметь числовой формат.\n");
                return;
            }
        }

        System.out.println("\nУравнение 2 плоскости:");
        F2 = flats.get(1);
        F2.printFlat();

        if (F1.parallFlat(F2))
        {
            System.out.println("Заданные плоскости параллельны или совпадают.\n");
        }
        else
        {
            if (F1.perpendFlat(F2))
            {
                System.out.println("Заданные плоскости перпендикулярны.\n");
            }
            else
            {
                System.out.println("\nУгол между плоскостями равен " + F1.FlattoFlat(F2) + " градусам.\n");
            }
        }

        System.out.println("Введите координаты точки.");
        tmp = in.nextLine();
        a = tmp.trim().split(" +");
        if (a.length < 3)
        {
            System.out.println("Недостаточно параметров для задания точки.\n");
            return;
        }
        try
        {
            Point o = new Point(Double.parseDouble(a[0]), Double.parseDouble(a[1]), Double.parseDouble(a[2]));
            ex = o;
        }
        catch (Exception e)
        {
            System.out.println("Координаты точек должны иметь числовой формат.\n");
            return;
        }

        if (F1.PointtoFlat(ex) == 0)
        {
            System.out.println("\nТочка лежит в плоскости 1.");
        }
        if (F2.PointtoFlat(ex) == 0)
        {
            System.out.println("\nТочка лежит в плоскости 2.");
        }
        if ((F1.PointtoFlat(ex) != 0) && (F2.PointtoFlat(ex) != 0))
        {
            System.out.println("\nРасстояние от точки до плоскости 1 равно " + F1.PointtoFlat(ex) + ".");
            System.out.println("Расстояние от точки до плоскости 2 равно " + F2.PointtoFlat(ex) + ".");
            System.out.println("Плоскость, параллельная плоскости 1 и содержащая точку:");
            Flat par1 = new Flat();
            par1 = F1.createFlat(ex);
            par1.printFlat();
            System.out.println("\nПлоскость, параллельная плоскости 2 и содержащая точку:");
            Flat par2 = new Flat();
            par2 = F2.createFlat(ex);
            par2.printFlat();
        }
    }
}