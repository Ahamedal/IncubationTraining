#include <iostream>

using namespace std;

#include "Bank.h"
#include "Loan.h"
#include "HDFC.h"
#include "ICICI.h"
#include "SBI.h"
#include "Broker.h"

int main()
{
    //cout << "Hello world!" << endl;
    HDFC h("HDFC","1-2-2000","Priv","Ramnad",0.1);

    SBI s("SBI","1-2-1999","Public","Karaikudi",2.3);

    ICICI i("ICICI","1-2-2001","public","Chennai",1);


    Broker b;


    cout<<b.compareBanks(h,s).getBankName()<<" has lowest Bank interestRate"<<endl;
    cout<<b.compareBanks(h,s,i).getBankName()<<" has lowest Bank interestRate"<<endl;

    Loan mulBank[3]= {h,s,i};
    int n=sizeof(mulBank)/sizeof(mulBank[0]);

    cout<< b.compareBanks(mulBank,n).getBankName()<<" has lowest interest rate";
    b.display(h);
    Bank arr[3]= {h,s,i};
    int n1=sizeof(arr)/sizeof(arr[0]);
    b.multipleDisplay(arr,n1);
    return 0;
}
