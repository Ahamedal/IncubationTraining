#ifndef HDFC_H_INCLUDED
#define HDFC_H_INCLUDED
#include "Bank.h"
#include "Loan.h"
class HDFC:public Bank,public Loan{
//private:

public:
HDFC(string bank,string date,string type,string branch,double rate):Loan(bank,rate){
bankName=bank;
establishedDate=date;
bankType=type;
interestRate=rate;
branchName=branch;
}
string getName(){
return bankName;
}
string getEstablishedDate(){
return establishedDate;
}

string getBankType(){
return bankType;
}

string getBranchName(){
return branchName;
}



string getAvailableLoans(){
string str="Goldloan , Personel Loan ,Land loan";
return str;

}
double getInterestRate(){
return interestRate;
}

 string documentRequiredForGoldLoan(){
 string str2="AadhaarCard , Pancard , Gold Document";
 return str2;


 }
 string documentRequiredForPersonnelLoan(){
 string str="AadhaarCard , Pancard , Personnel Document";
 return str;

 }
 string documnetRequiredForLandLoan(){
 string str="AadhaarCard , Pancard , Land Documnet";
 return str;

 }
};

#endif // HDFC_H_INCLUDED
