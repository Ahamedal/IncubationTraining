#ifndef BROKER_H_INCLUDED
#define BROKER_H_INCLUDED


#include <climits>
#include "Bank.h"
#include "Loan.h"

class Broker{
public:
 Loan &compareBanks(Loan &obj1,Loan &obj2){
if(obj1.getInterestRate()<obj2.getInterestRate()){
return obj1;
}
return obj2;
}
Loan &compareBanks(Loan &obj1,Loan &obj2,Loan &obj3){
if(obj1.getInterestRate()<=obj2.getInterestRate()&&obj1.getInterestRate()<=obj3.getInterestRate()){
return obj1;
}
else if(obj2.getInterestRate()<=obj1.getInterestRate()&&obj2.getInterestRate()<=obj3.getInterestRate()){
return obj2;
}
return obj3;
}



Loan compareBanks(Loan arr1[],int size1){
Loan minLoan("sbi",10);

double min1=INT_MAX;

for(int i=0;i<size1;i++){

double min2=arr1[i].getInterestRate();

if(min2<min1){
minLoan=arr1[i];
min1=arr1[i].getInterestRate();
}

}
return minLoan;

}

void display(Bank obj){
obj.getInfo();
}

int getArrayLength(Bank arr[]){

int n=*(&arr+1)-arr;
return n;
}
void multipleDisplay(Bank arr[],int size){

for(int i=0;i<size;i++){
arr[i].getInfo();

}


}
};

#endif // BROKER_H_INCLUDED
