#ifndef LOAN_H_INCLUDED
#define LOAN_H_INCLUDED

class Loan
{
public:
    string bankNameLoan;
    double interestRate;

    Loan(string bankNames,double rate)
    {
        bankNameLoan=bankNames;
        interestRate=rate;
    }

    string getBankName()
    {
        return bankNameLoan;
    }

    virtual double getInterestRate()
    {
        return interestRate;
    }

    virtual string getAvalilableLoans() {}
    virtual string documentRecuiredForGoldLoan() {}
    virtual string documentRecuiredForPersonnelLoan() {}
    virtual string documentRecuiredForLandLoan() {}



};

#endif // LOAN_H_INCLUDED
