package com.company;

abstract public class Human implements Comparable<Human>
{
    public String name, surname;
    public String sex;
    public int age;
    //оздание полей класса

    public Human()
    {
        name = "";
        surname = "";
        sex = "";
        age = 0;
    }
    //конструктор по умолчанию

    public Human(String surname, String name, String sex, int age)
    {
        this.surname = surname;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
    //конструктор с параметрами

    public void setSurname(String surname)
    {
        this.surname = surname;
    }
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

    public String getSurname()
    {
        return surname;
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
        System.out.println("Surname: " + surname + "\n");
        System.out.println("Name: " + name + "\n");
        System.out.println("Sex: " + sex + "\n");
        System.out.println("Age: " + age + "\n");
    }
    //метод для вывода данных о человеке


    abstract boolean getsPaid();
    //абстрактный метод, переопределяемый в каждом наследнике класса для решения задачи лабораторной работы

    @Override

    public int compareTo(Human o)
    {
        return surname.compareTo(o.surname);
    }
    //сортировка по фамилии
}
//суперкласс Человек