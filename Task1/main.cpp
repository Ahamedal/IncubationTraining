#include <iostream>
#include "Car.h"
#include "Bike.h"
using namespace std;

int main()
{
    Car carObj("Petrol","BMW","M3","Bloc",6,100000000000,6,"XUV");
     Car carObj1("Diesel","AUdi","M3","Bloc",6,10000000,6,"XUV");
    //carObj.display();
    //carObj1.display();
    cout<<carObj;
    if(carObj>carObj1){
    cout<<"BMW price is greater than Audi Price";
    }
    else{
    cout<<"Audi price is greater than BMW price";
    }
    Bike bikeObj("Petrol","R15","M5","white",50,50000,50,"MotorBike");
    //bikeObj.display();
   cout<< "no of wheels of car:"<<carObj.getNoOfWheels()<< endl<<"no of wheels of bike:"<<bikeObj.getNoOfWheels();
   // cout << "Hello world!" << endl;

    return 0;
}
