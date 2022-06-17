#include <iostream>

using namespace std;

#include "Leader.h"

int main()
{
    // cout << "Hello world!" << endl;
    int row;
    cout<<"How many rows do you want";
    cin>>row;

    int col;
    cout<<"How many columns do you want";
    cin>>col;

    int** ptr=NULL;
    ptr=(int**)malloc(row*sizeof(int*));
    if(!ptr)
    {
        cout<<"Malloc failed";
        return 0;
    }
    for(int i=0; i<row; i++)
    {
        ptr[i]=(int*)calloc(col,sizeof(int));
        if(!ptr[i])
        {
            cout<<"Calloc failed";
            return 0;
        }
    }
    bool** visited=NULL;
    visited=(bool**)malloc(row*sizeof(bool*));
    if(!ptr)
    {
        cout<<"Malloc failed";
        return 0;
    }
    for(int i=0; i<row; i++)
    {
        visited[i]=(bool*)calloc(col,sizeof(bool));
        if(!visited[i])
        {
            cout<<"Calloc failed";
            return 0;
        }
    }
    for(int i=0; i<row; i++)
    {
        for(int j=0; j<col; j++)
        {
            cin>>ptr[i][j];
        }

    }
    for(int i=0; i<row; i++)
    {
        for(int j=0; j<col; j++)
        {
            cout<<ptr[i][j]<<" ";
        }
        cout<<endl;
    }

    int* ar=(int*)calloc(5,sizeof(int));
    Leader leader;
    leader.countBuildings(ptr,ar,visited,row,col);
    for(int i=0; i<5; i++)
    {
        cout<<ar[i]<<endl;
    }

    cout<<endl;

    cout<<"Leadre of group is "<<leader.leaderOfGroup(ar);




    //for prevent memory leak
    if(ar)
    {

        free(ar);

    }
    if(ptr)
    {
        for(int i=0; i<row; i++)
        {

            free(ptr[i]);

        }
        free(ptr);
    }
    if(visited)
    {
        for(int i=0; i<row; i++)
        {

            free(visited[i]);

        }
        free(visited);
    }
    return 0;
}
