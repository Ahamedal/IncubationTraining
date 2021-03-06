#ifndef SBI_H_INCLUDED
#define SBI_H_INCLUDED
#include "Bank.h"
#include "Loan.h"
class SBI:public Bank,public Loan
{


public:

    SBI(string bank,string date,string type,string branch,double rate):Loan(bank,rate)
    {
        bankName=bank;
        establishedDate=date;
        bankType=type;
        interestRate=rate;

        branchName=branch;
    }
    string getName()
    {
        return bankName;
    }
    string getEstablishedDate()
    {
        return establishedDate;
    }

    string getBankType()
    {
        return bankType;
    }

    string getBranchName()
    {
        return branchName;
    }


    void getAvailableLoans()
    {
        cout<<"Goldloan , Personel Loan ,Land loan";

    }
    double getInterestRate()
    {
        return interestRate;
    }

    void documentRequiredForGoldLoan()
    {
        cout<<"AadhaarCard , Pancard , Gold Document";

    }
    void documentRequiredForPersonnelLoan()
    {
        cout<<"AadhaarCard , Pancard , Personnel Document";

    }
    void documnetRequiredForLandLoan()
    {
        cout<<"AadhaarCard , Pancard , Land Documnet";
    }
};

#endif // SBI_H_INCLUDED
