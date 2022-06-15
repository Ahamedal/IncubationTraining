#ifndef MYEXCEPTION_H_INCLUDED
#define MYEXCEPTION_H_INCLUDED
#include <exception>
class MyException:public exception{

public:

const char* what() {

return " not valid ";

}



};


#endif // MYEXCEPTION_H_INCLUDED
