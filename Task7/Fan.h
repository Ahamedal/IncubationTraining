#ifndef FAN_H_INCLUDED
#define FAN_H_INCLUDED

class Fan:public Sensor{

private:
string deviceName="Fan";
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

};


#endif // FAN_H_INCLUDED
