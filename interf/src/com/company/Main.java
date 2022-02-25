package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        int[] rating = {5, 5, 5, 5, 5, 4, 5, 4, 5, 5};
        int[] olympiads = {1, 4, 0};
        int[] coursework = {5, 5};
        int[] rating1 = {4, 5, 3, 4, 5, 3, 4, 5, 5, 4};
        int[] olympiads1 = {3, 2, 50};
        int[] coursework1 = {5, 4};
        int[] rating2 = {5, 5, 5, 5, 4, 5, 5, 5, 5, 5};
        int[] olympiads2 = {3, 2, 1};
        int[] coursework2 = {4, 0};
        int[] rating3 = {5, 5, 5, 5, 5, 5, 5, 4, 5, 5};
        //массивы для создания студентов и школьников
        int[] schools;

        ArrayList<Human> UandSlist = new ArrayList<>();
        ArrayList<SchoolStudent> SS = new ArrayList<>();
        ArrayList<UniversityStudent> US = new ArrayList<>();

        SchoolStudent KornevaMaria = new SchoolStudent("Korneva", "Maria", "female", 13, 86, rating, olympiads);
        SS.add(KornevaMaria);
        UandSlist.add(KornevaMaria);
        SchoolStudent MorozovNikita = new SchoolStudent("Morozov", "Nikita", "male", 14, 33, rating2, olympiads2);
        SS.add(MorozovNikita);
        UandSlist.add(MorozovNikita);
        SchoolStudent ScvorcovAnton = new SchoolStudent("Scvorcov", "Anton", "male", 16, 4, rating1, olympiads1);
        SS.add(ScvorcovAnton);
        UandSlist.add(ScvorcovAnton);
        SchoolStudent KeshenevIgor = new SchoolStudent("Keshenev", "Igor", "male", 14, 86, rating3, olympiads);
        SS.add(KeshenevIgor);
        UandSlist.add(KeshenevIgor);

        UniversityStudent VeselovaViktoria = new UniversityStudent("Veselova", "Viktoria", "female", 21, rating, coursework);
        US.add(VeselovaViktoria);
        UandSlist.add(VeselovaViktoria);
        UniversityStudent IsmailovDenis = new UniversityStudent("Ismailov", "Denis", "male", 22, rating2, coursework1);
        US.add(IsmailovDenis);
        UandSlist.add(IsmailovDenis);
        UniversityStudent KrasnovaIrina = new UniversityStudent("Krasnova", "Irina", "female", 20, rating1, coursework2);
        US.add(KrasnovaIrina);
        UandSlist.add(KrasnovaIrina);
        UniversityStudent DoktorovaPolina = new UniversityStudent("Doktorova", "Polina", "female", 23, rating3, coursework);
        US.add(DoktorovaPolina);
        UandSlist.add(DoktorovaPolina);
        //создание списков людей, школьников и студентов

        Collections.sort(UandSlist);
        //сортировка общего списка по фамилиям

        System.out.println("Ответ на задачу 1:");
        System.out.println("(Отсортированный пофамильно список получающих спец. стипендию школьников и студентов)\n");
        for (int i = 0; i < UandSlist.size(); ++i)
        {
            if ((UandSlist.get(i)).getsPaid())
            {
                (UandSlist.get(i)).print();
                System.out.println(" ");
            }
        }
        //вывод отсортированного по фамилиям общего списка

        System.out.println("Ответ на задачу 2:");
        System.out.println("(Школьник и студент с наивысшей успеваемостью)\n");
        (Collections.max(SS, new SchoolStudentRatingandSchoolComparator())).print();
        System.out.println(" ");
        (Collections.max(US, new UniversityStudentRatingComparator())).print();
        //вывод данных о студенте и школьнике с наивысшей успеваемостью

        Collections.sort(SS, new SchoolStudentRatingandSchoolComparator());
        //сортировка списка школьников по успеваемости, а затем по номеру школы

        System.out.println("\nОтвет на задачу 3:");
        System.out.println("(Отсортированный по рейтингу и номеру школы список школьников)\n");
        for (int i = SS.size() - 1; i >= 0; i--)
        {
            (SS.get(i)).print();
            System.out.println(" ");
        }
        //вывод отсортированного по успеваемости, а затем по номеру школы списка школьников

        Collections.sort(US, new UniversityStudentRatingComparator());
        //сортировка списка студентов по успеваемости

        System.out.println("Ответ на задачу 4:");
        System.out.println("(Отсортированный по рейтингу список студентов)\n");
        for (int i = US.size() - 1; i >= 0; i--)
        {
            (US.get(i)).print();
            System.out.println(" ");
        }
        //вывод отсортированного по успеваемости списка студентов

        ArrayList<SchoolStudent> tmp = new ArrayList<>();
        int k = 0;
        for (int i = 0; i < SS.size(); ++i)
        {
            if ((SS.get(i)).getAge() < 15)
            {
                k = i;
                break;
            }
        }
        tmp.add(SS.get(k));
        for (int i = 0; i < SS.size(); ++i)
        {
            if ((SS.get(i)).getAge() < 15)
            {
                int flag = 0;
                if (flag == 0)
                {
                    for (int g = 0; g < tmp.size(); ++g)
                    {

                        if ((SS.get(i)).getSchool() == (tmp.get(g)).getSchool())
                        {
                            flag++;
                        }
                    }
                    if (flag == 0)
                    {
                        tmp.add(SS.get(i));
                    }
                    else
                    {
                        int y = 0;
                        for (int l = 0; l < tmp.size(); ++l)
                        {
                            if ((SS.get(i)).getSchool() == (tmp.get(l)).getSchool())
                            {
                                y = l;
                                break;
                            }
                        }
                        if ((SS.get(i)).averagerating() > (tmp.get(y)).averagerating())
                        {
                            (tmp.get(y)).copy(SS.get(i));
                        }
                    }
                }
            }
        }
        //отбор лучшего по успеваемости ученика младше 15 для каждой школы

        Collections.sort(tmp, new SchoolStudentRatingandSchoolComparator());
        //сортировка списка лучших учеников младше 15 по успеваемости и номеру школы

        System.out.println("Ответ на задачу 5:");
        System.out.println("(Лучшие ученики моложе 15 лет для каждой школы)\n");
        for (int i = tmp.size() - 1; i >= 0; i--)
        {
            (tmp.get(i)).print();
            System.out.println(" ");
        }
        //вывод списка лучших учеников младше 15, сортированного по номеру школы
    }
}