package com.company;

abstract public class Human
{
    public String name;
    public String sex;
    public int age;
    //оздание полей класса

    public Human()
    {
        name = "";
        sex = "";
        age = 0;
    }
    //конструктор по умолчанию

    public Human(String name, String sex, int age)
    {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
    //конструктор с параметрами

    public void setName(String name)
    {
        this.name = name;
    }
    public void setSex(String sex)
    {
        this.sex = sex;
    }
    public void setAge(int age)
    {
        this.age = age;
    }

    public String getName()
    {
        return name;
    }
    public String getSex()
    {
        return sex;
    }
    public int getAge()
    {
        return age;
    }
    //методы, возвращающие или изменяющие значения полей

    public void print()
    {
        System.out.println("Name: " + name + "\n");
        System.out.println("Sex: " + sex + "\n");
        System.out.println("Age: " + age + "\n");
    }
    //метод для вывода данных о человеке

    abstract boolean getsPaid();
    //абстрактный метод, переопределяемый в каждом наследнике класса для решения задачи лабораторной работы
}