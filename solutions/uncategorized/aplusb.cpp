// includes the input/output library, that allows you to input/output using std::cout and std::cin
#include <iostream>

// allows you to use std:: namespace functions without typing "std::" before each one
using namespace std;

// main function, executed when code is run
int main() {

  // declares an integer to store the user's input for N
  int n;
  
  // take input for N
  cin >> n;
  
  // for every N
  for (int i = 0; i < n; i++) {
  
    // declares 2 integers to store the user's input for A and B (two integers to add)
    int a, b;
    
    // take input for A and B
    cin >> a >> b;
    
    // output the sum of A and B, followed by a new line
    cout << a + b << "\n";
  }
}
