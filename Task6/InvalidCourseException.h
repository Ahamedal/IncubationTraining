#ifndef INVALIDCOURSEEXCEPTION_H_INCLUDED
#define INVALIDCOURSEEXCEPTION_H_INCLUDED
#include <exception>

class InvalidCourseException:public exception{


public:

const char* what() {

return "Course is not present";

}





};

#endif // INVALIDCOURSEEXCEPTION_H_INCLUDED
