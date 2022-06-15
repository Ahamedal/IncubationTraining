#ifndef AGENOTWITHINRANGEEXCEPTION_H_INCLUDED
#define AGENOTWITHINRANGEEXCEPTION_H_INCLUDED
#include <exception>

class AgeNotWithinRangeException:public exception{

public:

const char* what() {

return "Age is not valid (only allow between 15 to 21)";

}







};


#endif // AGENOTWITHINRANGEEXCEPTION_H_INCLUDED
