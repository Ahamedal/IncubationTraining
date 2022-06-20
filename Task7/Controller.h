#ifndef CONTROLLER_H_INCLUDED
#define CONTROLLER_H_INCLUDED
#include <unordered_map>
#include <string>
#include "Sensors.h"
#include "TemperatureSensor.h"
#include <iostream>
#include <bits/stdc++.h>
using namespace std;

class Controller{

private:

unordered_map<string,Sensors> sensors;

unordered_map<string,TemperatureSensor> tempSensor;

public:

Controller(){

Sensors s1("Fan");

sensors["Fan"]=s1;

Sensors s2("Light");

sensors["Light"]=s2;

Sensors s3("Door");

sensors["Door"]=s3;

TemperatureSensor s4("Temp");

tempSensor["Temp"]=s4;

}

void iterateSensors(){

cout<<" Sensors       "<<" Status "<<endl;

cout<<"---------      "<<"--------"<<endl;

for(auto val:sensors){

string name=val.first;
Sensors obj=val.second;



if(name.compare("Fan")==0||name.compare("Light")==0){

 if(obj.getStatus()){

 cout<<name<<"          "<<"On"<<endl;

 }
 else{

 cout<<name<<"          "<<"Off"<<endl;

 }

}

if(name.compare("Door")==0){

 if(obj.getStatus()){

 cout<<name<<"           "<<"Open"<<endl;

 }
 else{

 cout<<name<<"           "<<"Close"<<endl;

 }

}

}


}

void iterateTempSensor(){


for(auto val1:tempSensor){

cout<<val1.first<<"           "<<val1.second.getValue()<<endl;
}

}


function<void(string deviceName)> turnOn=[&](string deviceName){Sensors obj=sensors.at(deviceName);obj.turnOn();sensors[deviceName]=obj;};
function<void(string deviceName)> turnOff=[&](string deviceName){Sensors obj=sensors.at(deviceName);obj.turnOff();sensors[deviceName]=obj;};
function<void(string deviceName)> onConnect=[&](string deviceName){Sensors obj=sensors.at(deviceName);obj.connectDevice();sensors[deviceName]=obj;};
function<void()> increaseValue=[&](){TemperatureSensor obj=tempSensor.at("Temp");obj.increaseValue();tempSensor["Temp"]=obj;};
function<void()> decreaseValue=[&](){TemperatureSensor obj=tempSensor.at("Temp");obj.decreaseValue();tempSensor["Temp"]=obj;};
function<void(string deviceName)> onDisConnect=[&](string deviceName){Sensors obj=sensors.at(deviceName);obj.disConnectDevice();sensors[deviceName]=obj;};
function<void()> onConnect1=[&](){TemperatureSensor obj=tempSensor.at("Temp");obj.connectDevice();tempSensor["Temp"]=obj;};
function<void()> onDisConnect1=[&](){TemperatureSensor obj=tempSensor.at("Temp");obj.disConnectDevice();tempSensor["Temp"]=obj;};






};


#endif // CONTROLLER_H_INCLUDED
