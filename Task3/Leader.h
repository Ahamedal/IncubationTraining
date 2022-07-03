#ifndef LEADER_H_INCLUDED
#define LEADER_H_INCLUDED
#include <bits/stdc++.h>
using namespace std;
static int l=0;
static int sum=0;

class Leader
{
public:
    void countBuildings(int** mat,int* ans,bool** visited,int row,int col)
    {



        for(int i=0; i<row; i++)
        {
            for(int j=0; j<col; j++)
            {

                if(mat[i][j]!=0&&!visited[i][j])
                {

                    DFS(mat,i,j,visited,row,col);
                    ans[l++]=sum;

                    //lis.add(sum);
                    sum=0;
                }

            }
        }


    }

    void DFS(int** mat,int row,int col,bool** visited,int rows,int columns)
    {


        int rowNbr[] = {-1, 0, 0,1};                                           //Move 4 direction
        int colNbr[] = {0, -1, 1,0};
        visited[row][col] = true;

        sum=sum+mat[row][col];                                                                //Depth First Search

        for (int k = 0; k < 4; k++)
        {
            if (isSafe(mat, row + rowNbr[k], col + colNbr[k], visited,rows,columns))
            {
                DFS(mat, row + rowNbr[k], col + colNbr[k], visited,rows,columns);
            }
        }

    }

    bool isSafe(int** mat,int row,int col,bool** visited,int rows,int columns)
    {

        if(row>=0&&row<rows&&col>=0&&col<columns&&(mat[row][col]!=0&&!visited[row][col]))
        {
            return true;
        }
        return false;
    }

    int leaderOfGroup(int* ans,int rows,int columns)
    {

        int a=ans[0];
        int size=rows*columns;
        for(int i=0; i<size; i++)
        {

            if(a<ans[i])
            {
                a=ans[i];
            }

        }

        return a;

    }



};

#endif // LEADER_H_INCLUDED
