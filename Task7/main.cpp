#include <iostream>

using namespace std;


#include "Controller.h"

int main()
{
    //cout << "Hello world!" << endl;
    Controller c;
    int choose;


    bool condition=true;

    while(condition){
    try{
    c.iterateSensors();
    c.iterateTempSensor();
    cout<<"1.Change Status\n2.Simulating device\n3.Connect Device\n4.Disconnect Device\n5.Exit"<<endl;
    cin>>choose;
    switch(choose){
    case 1:
      cout<<"1.Fan\n2.Light\n3.Door"<<endl;
      int choose2;
      cin>>choose2;
      switch(choose2){

      case 1:
      cout<<"1.Turn On\n2.Turn Off"<<endl;
      int choose3;
      cin>>choose3;
      switch(choose3){
      case 1:
      c.turnOn("Fan");
      break;

      case 2:
      c.turnOff("Fan");
      break;
      }

      break;

      case 2:
      cout<<"1.Turn On\n2.Turn Off"<<endl;
      int choose9;
      cin>>choose9;
      switch(choose9){
      case 1:
      c.turnOn("Light");
      break;

      case 2:
      c.turnOff("Light");
      break;
      }

      break;
      case 3:
      cout<<"1.Turn On\n2.Turn Off"<<endl;
      int choose7;
      cin>>choose7;
      switch(choose7){
      case 1:
      c.turnOn("Door");
      break;

      case 2:
      c.turnOff("Door");
      break;
      }
      }
     break;

    case 2:
      cout<<"1.Increase value\n2.Decrease value"<<endl;
      int choose4;
      cin>>choose4;

      switch(choose4){

      case 1:
      c.increaseValue();
      break;

      case 2:
      c.decreaseValue();
      break;

      }
      break;

    case 3:
      cout<<"1.Fan\n2.Light\n3.Door\n4.Temp"<<endl;
      int choose5;
      cin>>choose5;

      switch(choose5){
      case 1:
      c.onConnect("Fan");
      break;

      case 2:
      c.onConnect("Light");
      break;

      case 3:
      c.onConnect("Door");
      break;

      case 4:
      c.onConnect1();
      break;

      }
      break;

    case 4:
      cout<<"1.Fan\n2.Light\n3.Door\n4.Temp"<<endl;
      int choose11;
      cin>>choose11;

      switch(choose11){
      case 1:
      c.onDisConnect("Fan");
      break;

      case 2:
      c.onDisConnect("Light");
      break;

      case 3:
      c.onDisConnect("Door");
      break;

      case 4:
      c.onDisConnect1();
      break;

      }
     break;

     case 5:
      condition=false;
      break;


     }
     }
     catch(const char* ch){

     cout<<ch<<endl;

     }



    }

    return 0;
}
