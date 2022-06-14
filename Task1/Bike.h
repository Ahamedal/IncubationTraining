#ifndef BIKE_H_INCLUDED
#define BIKE_H_INCLUDED
#include "Vehicle.h"
#include <iostream>
using namespace std;
class Bike:public Vehicle
{
    //ctor
    private:
    int weight;
    string bikeType;
    public:
    int getNoOfWheels(){
    return 2;
    }
    Bike(string vType,string br,string modl,string colr,int mil,double pri,int bWeight,string bType):Vehicle(vType,br,modl,colr,mil,pri){
    weight=bWeight;
    bikeType=bType;
    }


};


#endif // BIKE_H_INCLUDED
