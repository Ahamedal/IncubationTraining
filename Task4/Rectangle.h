#ifndef RECTANGLE_H_INCLUDED
#define RECTANGLE_H_INCLUDED
#include <cmath>
class Rectangle{

int* left=NULL;
int* top=NULL;
int* width=NULL;
int* height=NULL;
int* area=NULL;
int a;
int b;
int c;
int d;
int t;


public:
Rectangle(){
left=0;
top=0;
width=0;
height=0;
}

Rectangle(int wid,int hgt){

width=new int(wid);
height=new int(hgt);
left=new int(0);
top=new int(0);


}



Rectangle(int lft,int tp,int wi,int hgtt){

left=new int(lft);
top=new int(tp);
width=new int(wi);
height=new int(hgtt);


}


Rectangle(float leftVal,float topVal,float widtVal,float heightVal){
a=round(leftVal);
left=new int(a);

b=round(topVal);
top=new int(b);

c=round(widtVal);
width=new int(c);

d=round(heightVal);
height=new int(d);


}

Rectangle(const Rectangle &r){

left=&*r.left;
top=&*r.top;
width=&*r.width;
height=&*r.height;
t=*height * *width;
area=&t;
cout<<t;
}



void printValues(){

cout<<"The left of rectangle: "<<*left<<endl<<"The top of rectangle: "<<*top<<endl<<"width of rectangle: "<<*width<<endl<<"height of rectangle:"<<*height<<endl;


}

~Rectangle(){

/*if(left!=NULL){

delete(left);
left=NULL;

}
if(top!=NULL){

delete(top);
top=NULL;

}
if(width!=NULL){

delete(width);
width=NULL;

}
if(height!=NULL){

delete(height);
height=NULL;

}*/

delete left;
delete top;
delete width;
delete height;



}





};


#endif // RECTANGLE_H_INCLUDED
