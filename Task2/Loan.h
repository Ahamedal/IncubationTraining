#ifndef LOAN_H_INCLUDED
#define LOAN_H_INCLUDED

class Loan{
public:

 double interestRate;

virtual string getName(){}
virtual void getAvalilableLoans(){}
virtual double getInterestRate(){}
virtual void documentRecuiredForGoldLoan(){}
virtual void documentRecuiredForPersonnelLoan(){}
virtual void documentRecuiredForLandLoan(){}



};

#endif // LOAN_H_INCLUDED
