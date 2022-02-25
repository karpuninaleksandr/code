package com.company;

public class UniversityStudent extends Human
{
    private int[] kursovye;
    private int[] rating;
    //создание полей субкласса

    public UniversityStudent()
    {
        name = "";
        sex = "";
        age = 0;
        kursovye = new int[2];
    }
    //конструктор по умолчанию
    //в массив rating[]  записываются оценки по 10 предметам студента
    //в массив kursovye[] записываются данные оценок по курсовым работам
    //(в случае, если студент не имеет оценку за курсовую работу - записывается 0)

    public UniversityStudent(String name, String sex, int age, int[] rating, int[] kursovye)
    {
        super(name, sex, age);
        this.kursovye = kursovye;
        this.rating = rating;
    }
    //конструктор с параметрами

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

    public void setKursovye(int[] kursovye)
    {
        this.kursovye[0] = kursovye[0];
        this.kursovye[1] = kursovye[1];
    }
    //метод изменения значения поля оценок за курсовые работы

    public int[] getKursovye()

    {
        return kursovye;
    }
    //метод получения значения поля оценок за курсовые работы

    @Override

    public boolean getsPaid()
    {
        int checker = 0;
        float sredniyball = 0;
        for (int i = 0; i < rating.length; ++i)
        {
            sredniyball += rating[i];
        }
        sredniyball = sredniyball/rating.length;
        if (sredniyball < 4.75)
        {
            checker++;
        }
        //проверка среднего балла
        if ((kursovye[1] != 0))
        {
            if ((kursovye[0] != 5) || (kursovye[1] != 5))
                checker++;
        }
        else
        {
            if (kursovye[0] != 5)
            {
                checker++;
            }
        }
        //проверка наличия и оценок за курсовые работы
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
        System.out.print("\nStudent's work's marks:\n");
        System.out.print("First: " + kursovye[0] + "\n");
        System.out.print("Second: " + kursovye[1] + "\n");
    }
    //метод для вывода данных о студенте
}