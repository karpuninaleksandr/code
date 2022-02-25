package com.company;

public class Main
{

    public static void main(String[] args)
    {
        SchoolStudent[] SchoolStudents = new SchoolStudent[4];
        int[] rating = {5, 5, 5, 5, 5, 4, 5, 4, 5, 5};
        int[] olympiads = {1, 4, 0};
        SchoolStudents[0] = new SchoolStudent("Kassandra", "female", 14, rating, olympiads);
        int[] rating1 = {4, 5, 3, 4, 5, 3, 4, 5, 5, 4};
        int[] olympiads1 = {3, 2, 50};
        SchoolStudent Ann = new SchoolStudent("Ann", "female", 18, rating1, olympiads1);
        SchoolStudents[1] = Ann;
        int[] rating2 = {5, 5, 5, 5, 4, 5, 4, 4, 4, 4};
        int[] olympiads2 = {3, 2, 1};
        SchoolStudents[2] = new SchoolStudent("John", "male", 16, rating2, olympiads2);
        SchoolStudents[3] = new SchoolStudent("Vika", "female", 19, rating2, olympiads2);
        //массив школьников для первой задачи лабораторной работы

        System.out.println("Девочки, занявшие первое место на одном и более из этапов олимпиады:\n");
        int[] tempolympiads = new int[3];
        for (int i = 0; i < 4; ++i)
        {
            tempolympiads = SchoolStudents[i].getPlaces();
            int flag = 0;
            for (int j = 0; j < 3; j++)
            {
                if (tempolympiads[j] == 1)
                {
                    flag = 1;
                }
            }
            if ((flag == 1) && (SchoolStudents[i].getSex() == "female"))
            {
                SchoolStudents[i].print();
                System.out.println(" ");
            }
            flag = 0;
        }
        //первая задача решена

        UniversityStudent[] UniversityStudents = new UniversityStudent[3];
        int[] kursovye = {5, 0};
        int[] kursovye1 = {0, 0};
        int[] kursovye2 = {3, 4};
        UniversityStudent Greg = new UniversityStudent("Greg", "male", 23, rating, kursovye);
        UniversityStudents[0] = Greg;
        UniversityStudents[1] = new UniversityStudent("Michael", "male", 20, rating1, kursovye1);
        UniversityStudents[2] = new UniversityStudent("Maria", "female", 21, rating2, kursovye2);
        //массив студентов для второй задачи лабораторной работы

        System.out.println("Студенты с оценками за курсовые(ую) работы(у):\n");
        int[] tempkursovye = new int[2];
        for (int i = 0; i < 3; ++i)
        {
            tempkursovye = UniversityStudents[i].getKursovye();
            if ((tempkursovye[0] != 0) || (tempkursovye[1] != 0))
            {
                UniversityStudents[i].print();
                System.out.println(" ");
            }
        }
        //вторая задача решена

        System.out.println("Школьники и студенты из двух предыдущих задач, которые будут получать спец. стипендию\n");
        int schet = 0;
        int id= 0;
        for (int i = 0; i < 4; ++i)
        {
            if (SchoolStudents[i].getsPaid())
            {
                schet++;
            }
        }
        for (int i = 0; i < 3; ++i)
        {
            if (UniversityStudents[i].getsPaid())
            {
                schet++;
            }
        }
        Human[] List = new Human[schet];
        for (int i = 0; i < 4; ++i)
        {
            if (SchoolStudents[i].getsPaid())
            {
                List[id] = SchoolStudents[i];
                id++;
            }
        }
        for (int i = 0; i < 3; ++i)
        {
            if (UniversityStudents[i].getsPaid())
            {
                List[id] = UniversityStudents[i];
                id++;
            }
        }
        for (int i = 0; i < schet; ++i)
        {
            List[i].print();
            System.out.println(" ");
        }
        //третья задача решена
    }
}