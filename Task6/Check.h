#ifndef CHECK_H_INCLUDED
#define CHECK_H_INCLUDED
#include <vector>
#include <algorithm>
#include <cctype>
#include "AgeNotWithinRangeException.h"
#include "NameNotValidException.h"
#include "InvalidCourseException.h"
class Check
{

public:

    void checkValidOfUser(vector<int> v,int roll)
    {
        if(std::count(v.begin(),v.end(),roll))
        {
            throw("one Student only create one object,not allow to another object");
        }

    }
    void checkAge(int ageOfStudent)
    {
        if(ageOfStudent<15 || ageOfStudent>21)
        {
            AgeNotWithinRangeException obj1;
            throw obj1;
        }
    }


    void checkName(string name)
    {

        for(int i=0; i<name.length(); i++)
        {

            if(!isalpha(name.at(i)))
            {
                NameNotValidException obj2;
                throw obj2;

            }

        }

    }

    void checkCourse(vector<string> v,string course)
    {

        if(!std::count(v.begin(),v.end(),course))
        {
            InvalidCourseException obj3;
            throw obj3;
        }

    }




};

#endif // CHECK_H_INCLUDED
