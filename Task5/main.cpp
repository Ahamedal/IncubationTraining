#include <iostream>

using namespace std;

#include "Equate.h"

using namespace Equate;


namespace veryLargeNamespaceName{

int x;

namespace nestedNamespace{

int getX(){

return x;
}


}


}

namespace smallName=veryLargeNamespaceName;
namespace nested=smallName::nestedNamespace;

int main()
{
  //  cout << "Hello world!" << endl;
  inside i;
    cout<<i.square(2);
    cout<<Eq::cube(3);
    smallName::x=10;
   // cout<<smallName::nestedNamespace::getX();
    cout<<nested::getX();
    return 0;
}
