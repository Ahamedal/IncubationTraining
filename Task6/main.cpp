#include <iostream>

using namespace std;

#include "ExceptionHandling.h"
#include "AgeNotWithinRangeException.h"
#include "InvalidCourseException.h"
#include "Check.h";
#include "Student.h"
#include <vector>

int main()
{
    vector<string> v{"c","c++","Java"};
    vector<int> v1;
    ExceptionHandle ex;
    Check chObj;
    bool condition=true;
    while(condition)
    {
        cout<<"Enter number:1.division operation 2.Dynamic heap memory check allocation 3.string index check 4.array index check 5.Student ";
        int choose;
        cin>>choose;
        switch(choose)
        {

        case 1:
            try
            {
                cout<<"Enter first number";
                int firstNumber;

                cin>>firstNumber;

                if(cin.fail())
                {
                    throw("Format mismatch");
                }
                cout<<"Enter second number";
                int secondNumber;
                cin>>secondNumber;

                if(cin.fail())
                {
                    throw("Format mismatch");
                }
                //cout<<firstNumber<<secondNumber;

                int k=ex.operation(firstNumber,secondNumber);

                cout<<k;

            }

            catch(MyException e)
            {
                cout<<e.what()<<endl;
            }

            break;

        case 2:
            try
            {
                ex.creationDynamic();
            }

            catch(const char *ch)
            {
                cout<<ch<<endl;
            }
            break;

        case 3:
            try
            {
                ex.invalidIndex("hello",6);
            }

            catch(const char *ch)
            {
                cout<<ch<<endl;
            }
            break;

        case 4:
            try
            {
                cout<<"How many values do want for arrays";
                int n;
                cin>>n;

                int arr[n];

                for(int i=0; i<n; i++)
                {
                    cin>>arr[i];
                    if(cin.fail())
                    {
                        throw("Format mismatch");
                    }
                }

                ex.invalidArrayIndex(arr,n,6);
            }

            catch(const char *ch)
            {
                cout<<ch<<endl;
            }
            break;

        case 5:
            int rollNo;
            cout<<"Enter the rollno";
            cin>>rollNo;
            try
            {

                chObj.checkValidOfUser(v1,rollNo);

                string name;
                cout<<"Enter the name";
                cin>>name;
                chObj.checkName(name);


                int age;
                cout<<"Enter the age";
                cin>>age;
                chObj.checkAge(age);



                string course;
                cout<<"Enter the course name";
                cin>>course;


                chObj.checkCourse(v,course);

                Student s(rollNo,name,age,course);
                v1.push_back(rollNo);

            }
            catch(AgeNotWithinRangeException e)
            {

                cout<<e.what();

            }
            catch(NameNotValidException e)
            {

                cout<<e.what();
            }
            catch(InvalidCourseException e)
            {

                cout<<e.what();
            }
            catch(const char *c)
            {

                cout<<c;
            }
            break;

        case 6:
            condition=false;

        }



    }
    cout<<"End";
    return 0;
}
