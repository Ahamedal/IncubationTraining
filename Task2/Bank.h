#ifndef BANK_H_INCLUDED
#define BANK_H_INCLUDED


class Bank{
public:

 string bankName;
 string establishedDate;
 string bankType;
 string branchName;
virtual string getName(){}
virtual string getEstablishedDate(){}
virtual string getBankType(){}
 void getInfo(){
cout<<bankName<<"   "<<establishedDate<<"  "<<bankType<<"    "<<branchName<<endl;
}
virtual string getBranchName(){}




};


#endif // BANK_H_INCLUDED
