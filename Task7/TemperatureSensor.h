#ifndef TEMPERATURESENSOR_H_INCLUDED
#define TEMPERATURESENSOR_H_INCLUDED

class TemperatureSensor{

private:

string deviceName;

float value=22.0f;

bool connectionStatus=true;

public:

TemperatureSensor(){}

TemperatureSensor(string devName){

deviceName=devName;

}

string getDeviceName(){

return deviceName;

}

float getValue(){

return value;

}

void increaseValue(){

value+=1.0f;

}

void decreaseValue(){

value-=1.0f;

}


void connectDevice(){

if(connectionStatus){

throw("Your device is already disconnected");

}
connectionStatus=true;

}

void disConnectDevice(){

if(!connectionStatus){

throw("Your device is already disconnected");

}
connectionStatus=false;
}






};


#endif // TEMPERATURESENSOR_H_INCLUDED
