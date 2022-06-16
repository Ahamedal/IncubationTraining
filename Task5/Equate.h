#ifndef EQUATE_H_INCLUDED
#define EQUATE_H_INCLUDED

#include "MathEquation.h"



namespace Equate
{

class inside
{

public:
    int square(int x)
    {

        return Equation::Maths::square(x);


    }


};


namespace Eq
{

int cube(int x)
{

    return x*x*x;

}

}
inline namespace Equal
{

int cube(int x)
{

return x*x;

}
}





}

#endif // EQUATE_H_INCLUDED
