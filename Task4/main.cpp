#include <iostream>

using namespace std;

#include "Rectangle.h"
int main()
{
    int l,t,w,h;
    cout<<"Enter left side value of rectangle";
    cin>>l;
    cout<<"Enter top side value of rectangle";
    cin>>t;
    cout<<"Enter width of rectangle";
    cin>>w;
    cout<<"Enter height of rectangle";
    cin>>h;
    Rectangle r6;
    r6.printValues();
    Rectangle r(l,t,w,h);
    r.printValues();
    Rectangle r2(w,h);
    r2.printValues();
    Rectangle r3=r;
    r3.printValues();

    Rectangle r4(1.3f,4.6f,1.1f,2.1f);
    r4.printValues();

    return 0;
}
