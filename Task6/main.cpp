#include <iostream>

using namespace std;

#include "ExceptionHandling.h"
#include "InvalidCourseException.h"

int main()
{
  try{
    cout<<"Enter first number";
    int firstNumber;

    cin>>firstNumber;

    if(cin.fail()){
    throw("Format mismatch");
    }
    cout<<"Enter second number";
    int secondNumber;
    cin>>secondNumber;

    if(cin.fail()){
    throw("Format mismatch");
    }
    cout<<firstNumber<<secondNumber;


    ExceptionHandle ex;

    int k=ex.operation(firstNumber,secondNumber);
    // ex.creationDynamic();
   cout<<k;
   // ex.invalidIndex("hello",6);
    cout<<"How many values do want for arrays";
    int n;
    cin>>n;

    int arr[n];

    for(int i=0;i<n;i++){
    cin>>arr[i];
    if(cin.fail()){
    throw("Format mismatch");
    }
    }

    ex.invalidArrayIndex(arr,n,6);
    }
    catch(const char *ch){
    cout<<ch<<endl;
    }
    cout<<"End";
    return 0;
}
