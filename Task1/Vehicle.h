#ifndef VEHICLE_H_INCLUDED
#define VEHICLE_H_INCLUDED
#include "Car.h"
#include <iostream>
using namespace std;


class Vehicle
{
    //ctor
private:
    string vehicleType;
    string brand;
    string model;
    string color;
    int mileage;
    double price;

    public:

    Vehicle(string vType,string br,string modl,string colr,int mil,double pri)
    {
        vehicleType=vType;
        brand=br;
        model=modl;
        color=colr;
        mileage=mil;
        price=pri;
    }
    void display()
    {
        cout<<vehicleType<<"  "<<brand<<"  "<<model <<"   "<<color<<"  "<<mileage<<"   "<<price<<endl;
    }
    friend ostream &operator<<(ostream &out,const Vehicle &v)
    {
        out<<v.vehicleType<<" "<<v.brand<<" "<<v.model<<" "<<v.color<<" "<<v.mileage<<" "<<v.price<<endl;
        return out;
    }
    int getPrice()
    {
        return price;
    }


    bool operator >(Vehicle &v)
    {
        if(price<v.getPrice())
        {
            return true;
        }
        return false;
    }



    virtual int getNoOfWheels()=0;
};

#endif // VEHICLE_H_INCLUDED
