package com.company;

public class SchoolStudent extends Human
{
    private int[] olympiads;
    private int[] rating;
    //создание полей субкласса

    public SchoolStudent()
    {
        name = "";
        sex = "";
        age = 0;
        olympiads = new int[3];
    }
    //конструктор по умолчанию
    //в массив rating[]  записываются оценки ученика след. образом: по порядку - математика, русский, история, английский и остальные 6 предметов
    //в массив olympiads[] записываются данные касательно лучшего результата участия ученика в олимпиадах - элемент с индексом [0] - школьный этап, [1] - городской, [2] - областная
    //(в случае, если ученик не принимал участие на каком-то этапе - в элемент с соотв. индексом нужно записать 0)


    public SchoolStudent(String name, String sex, int age, int[] rating, int[] olympiads)
    {
        super(name, sex, age);
        this.olympiads = olympiads;
        this.rating = rating;
    }

    public void setRating(int[] rating)
    {
        for (int i = 0; i < rating.length; ++i)
        {
            this.rating[i] = rating[i];
        }
    }
    //метод изменения значения поля оценок

    public int[] getRating()
    {
        return rating;
    }
    //метод получения значения поля оценок

    public void setPlaces(int[] olympiads)
    {
        for (int i = 0; i < 3; ++i)
        {
            this.olympiads[i] = olympiads[i];
        }
    }
    //метод изменения значения поля олимпиад

    public int[] getPlaces()
    {
        return olympiads;
    }
    //метод получения значения поля олимпиад

    @Override

    public boolean getsPaid()
    {
        int checker = 0;
        for (int i = 0; i < rating.length; ++i)
        {
            if (i < 4)
            {
                if (rating[i] != 5)
                {
                    checker++;
                }
            }
            else
            {
                if (rating[i] < 4)
                {
                    checker++;
                }
            }
        }
        //проверка оценок ученика
        if (olympiads[0] != 1)
        {
            if (olympiads[1] > 3)
            {
                if (olympiads[2] == 0)
                {
                    checker++;
                }
            }
        }
        //проверка участия и мест в олимпиадах
        if (checker == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    //переопределяемый метод для решения задачи лабораторной работы

    public void print()
    {
        System.out.print("Name: " + name + "\n");
        System.out.print("Sex: " + sex + "\n");
        System.out.print("Age: " + age + "\n");
        System.out.print("Student's marks:\n");
        for (int i = 0; i < rating.length; ++i)
        {
            System.out.print(rating[i] + " ");
        }
        System.out.print("\nStudent's olympiads:\n");
        System.out.print("School's place: " + olympiads[0] + "\n");
        System.out.print("City's place: " + olympiads[1] + "\n");
        System.out.print("Region's place: " + olympiads[2] + "\n");
    }
    //метод для вывода данных о школьнике
}