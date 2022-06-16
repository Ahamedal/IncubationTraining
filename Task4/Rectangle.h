#ifndef RECTANGLE_H_INCLUDED
#define RECTANGLE_H_INCLUDED
#include <cmath>
class Rectangle
{

    int* left=NULL;
    int* top=NULL;
    int* width=NULL;
    int* height=NULL;
    int* area=NULL;




public:
    Rectangle()
    {
        left=new int(0);
        top=new int(0);
        width=new int(0);
        height=new int(0);

    }

    Rectangle(int wid,int hgt)
    {

        width=new int(wid);
        height=new int(hgt);
        left=new int(0);
        top=new int(0);


    }



    Rectangle(int lft,int tp,int wi,int hgtt)
    {

        left=new int(lft);
        top=new int(tp);
        width=new int(wi);
        height=new int(hgtt);


    }


    Rectangle(float leftVal,float topVal,float widtVal,float heightVal)
    {

        left=new int(round(leftVal));


        top=new int(round(topVal));


        width=new int(round(widtVal));


        height=new int(round(heightVal));


    }

    Rectangle(const Rectangle &r)
    {

        left=new int(*r.left);
        top=new int(*r.top);
        width=new int(*r.width);
        height=new int(*r.height);

        area=new int(*height * *width);
        cout<<*area;
    }



    void printValues()
    {

        cout<<"The left of rectangle: "<<*left<<endl<<"The top of rectangle: "<<*top<<endl<<"width of rectangle: "<<*width<<endl<<"height of rectangle:"<<*height<<endl;


    }

    ~Rectangle()
    {

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
        delete area;


    }





};


#endif // RECTANGLE_H_INCLUDED
