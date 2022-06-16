#ifndef STUDENT_H_INCLUDED
#define STUDENT_H_INCLUDED
#include "AgeNotWithinRangeException.h"

class Student
{

    int rollNo;
    string name;
    int age;
    string course;

public:

    Student(int roll,string nameOfStudent,int ageOfStudent,string cours)
    {

        rollNo=roll;
        name=nameOfStudent;
        age=ageOfStudent;
        course=cours;




    }
    int getRollNo()
    {

        return rollNo;

    }

    string getName()
    {

        return name;

    }

    int getAge()
    {

        return age;


    }
    string getCourse()
    {

        return course;

    }





};

#endif // STUDENT_H_INCLUDED
