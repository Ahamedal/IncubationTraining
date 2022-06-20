#ifndef LIGHT_H_INCLUDED
#define LIGHT_H_INCLUDED

class Light:public Sensor{

private:
string deviceName="Light";
string status="off";
bool connectionStatus=true;

public:

string getDeviceName(){

return deviceName;

}

void setStatus(bool st){

if(st){

status="on";

}
else{

status="off";

}


}

string getStatus(){


return status;


}

void setConnectionStatus(bool st){


connectionStatus=st;

}

bool getConnectionStatus(){

return connectionStatus;

}






}

#endif // LIGHT_H_INCLUDED
