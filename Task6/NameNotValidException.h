#ifndef NAMENOTVALIDEXCEPTION_H_INCLUDED
#define NAMENOTVALIDEXCEPTION_H_INCLUDED
#include <exception>

class NameNotValidException:public exception
{

public:

    const char* what()
    {

        return "Name is not valid ";

    }










};

#endif // NAMENOTVALIDEXCEPTION_H_INCLUDED
