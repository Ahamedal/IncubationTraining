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
    HDFC h("HDFC","1-2-2000","Priv","Ramnad",11);

    SBI s("SBI","1-2-1999","Public","Karaikudi",20);

    ICICI i("ICICI","1-2-2001","public","Chennai",5);


    Broker b;

 Loan mulBank[3]={h,s,i};
cout<<b.compareBanks(h,s).getName()<<" has lowest Bank interestRate"<<endl;
cout<<b.compareBanks(h,s,i).getName()<<" has lowest Bank interestRate";

int n=sizeof(mulBank)/sizeof(mulBank[0]);

   cout<< b.compareBanks(mulBank,n).getName()<<" has lowest interest rate";
   b.display(h);
   b.multipleDisplay(mulBank,n);
    return 0;
}
