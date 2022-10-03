// includes the input/output library, that allows you to input/output using std::cout and std::cin
#include <iostream>

// allows you to use std:: namespace functions without typing "std::" before each one
using namespace std;

// main function, executed when code is run
int main() {
    
    // since "Graph Theory!" will always be outputted no matter the input, simply outputting "Graph Theory!" will solve the problem.
    // No input required.
    cout << "Graph Theory!";
    
    // since the main function is an int, a value can be returned (actually not required in C99 or C++, and can be omitted)
    return 0;
}
