#ifndef BANK_H_INCLUDED
#define BANK_H_INCLUDED


class Bank
{
public:

    string bankName;
    string establishedDate;
    string bankType;
    string branchName;
    virtual string getName()
    {
        return bankName;
    }

    virtual string getEstablishedDate() {}
    virtual string getBankType() {}

    void getInfo()
    {
        cout<<"Bank Name: "<<bankName<<endl<<"Bank established date:  "<<establishedDate<<endl<<"Bank type: "<<bankType<<endl<<"branch Name:  "<<branchName<<endl;
    }
    virtual string getBranchName() {}




};


#endif // BANK_H_INCLUDED
