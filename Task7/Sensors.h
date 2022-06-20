#ifndef SENSORS_H_INCLUDED
#define SENSORS_H_INCLUDED

class Sensors{

private:
string deviceName;
bool currentStatus=false;
bool connectionStatus=true;

public:

Sensors(){}

Sensors(string devName){

deviceName=devName;


}

string getDeviceName(){

return deviceName;

}


bool getStatus(){


return currentStatus;


}


bool getConnectionStatus(){

return connectionStatus;

}

void turnOn(){

connectionCheck();
currentStatusCheck1();
currentStatus=true;

}
void turnOff(){

connectionCheck();
currentStatusCheck2();
currentStatus=false;


}
void connectionCheck(){

if(!connectionStatus){

throw("Your device is disconnected");

}
}


void currentStatusCheck1(){

if(currentStatus){

throw("Your device is already turn on");

}

}
void currentStatusCheck2(){

if(!currentStatus){

throw("Your device is already turn off");

}

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


#endif // SENSORS_H_INCLUDED
