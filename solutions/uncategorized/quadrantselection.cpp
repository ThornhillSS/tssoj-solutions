// includes the input/output library, that allows you to input/output using std::cout and std::cin
#include <iostream>

// allows you to use std:: namespace functions without typing "std::" before each one
using namespace std;

// main function, executed when code is run
int main() {
  
  // create two X and Y variables to store the user's input
  int x, y;
  
  // take input for X and Y
  cin >> x >> y;
  
  // select and output correct Quadrant
  if (x > 0) {
    if (y > 0) {
      cout << 1;
    }
    else {
      cout << 4;
    }
  }
  else {
    if (y > 0) {
      cout << 2;
    }
    else {
      cout << 3;
    }
  }
  
  // since the main function is an int, a value can be returned (actually not required in C99 or C++, and can be omitted)
  return 0;
}
