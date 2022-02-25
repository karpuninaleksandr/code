package com.company;

import java.util.Comparator;

public class UniversityStudentRatingComparator extends UniversityStudent implements Comparator<UniversityStudent>
{
    @Override

    public int compare(UniversityStudent o1, UniversityStudent o2)
    {
        return Float.compare(o1.averagerating(), o2.averagerating());
    }
}
//сортировка студентов по среднему баллу