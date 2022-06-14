#ifndef CAR_H_INCLUDED
#define CAR_H_INCLUDED
#include "Vehicle.h"
#include <iostream>
using namespace std;
class Car:public Vehicle
{
    //ctor
    private:
    int noOfPersons;
    string carType;
    public:
    int getNoOfWheels(){
    return 4;
    }
    Car(string vType,string br,string modl,string colr,int mil,double pri,int noOfPerson,string cType):Vehicle(vType,br,modl,colr,mil,pri){
    noOfPersons=noOfPerson;
    carType=cType;
    }


};

#endif // CAR_H_INCLUDED
