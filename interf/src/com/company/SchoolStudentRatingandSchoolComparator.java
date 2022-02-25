package com.company;

import java.util.Comparator;

public class SchoolStudentRatingandSchoolComparator extends SchoolStudent implements Comparator<SchoolStudent>
{
    @Override

    public int compare(SchoolStudent o1, SchoolStudent o2)
    {
        float res = o1.averagerating() - o2.averagerating();
        if (res == 0)
        {
            return -Integer.compare(o1.getSchool(), o2.getSchool());
        }
        else
        {
            return Float.compare(o1.averagerating(), o2.averagerating());
        }
    }
}
//сортировка школьников по среднему баллу