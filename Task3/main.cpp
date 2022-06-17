#include <iostream>

using namespace std;

#include "Leader.h"

int main()
{
    // cout << "Hello world!" << endl;
    int** ptr=NULL;
    ptr=(int**)malloc(5*sizeof(int*));
    if(!ptr)
    {
        cout<<"Malloc failed";
        return 0;
    }
    for(int i=0; i<5; i++)
    {
        ptr[i]=(int*)calloc(5,sizeof(int));
        if(!ptr[i])
        {
            cout<<"Calloc failed";
            return 0;
        }
    }
    for(int i=0; i<5; i++)
    {
        for(int j=0; j<5; j++)
        {
            cin>>ptr[i][j];
        }

    }
    for(int i=0; i<5; i++)
    {
        for(int j=0; j<5; j++)
        {
            cout<<ptr[i][j]<<" ";
        }
        cout<<endl;
    }

    int* ar=(int*)calloc(5,sizeof(int));
    Leader leader;
    leader.countBuildings(ptr,ar);
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
        for(int i=0; i<5; i++)
        {

            free(ptr[i]);

        }
        free(ptr);
    }
    return 0;
}
