#ifndef EXCEPTIONHANDLING_H_INCLUDED
#define EXCEPTIONHANDLING_H_INCLUDED
#include "MyException.h"
class ExceptionHandle{
public:
int operation(int a,int b){
   int c;

   if(b==0){
   MyException m;
   throw m;
   }
   c=a/b;
   return c;

}
void creationDynamic(){

try{
int *p=new int[100];
cout<<"hello";
}
catch(exception e){

throw("Memory is compromised");

}


}
void invalidIndex(string s,int ind){

try{
s.at(ind);
}
catch(exception e){
throw("Index is Invalid");
}

}
void invalidArrayIndex(int arr[],int size1,int ind){

if(ind<0||ind>=size1)
throw("Array Index is Invalid");
}
};

#endif // EXCEPTIONHANDLING_H_INCLUDED
