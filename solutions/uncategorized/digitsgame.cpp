// includes the input/output library, that allows you to input/output using std::cout and std::cin
#include <iostream>

// allows you to use std:: namespace functions without typing "std::" before each one
using namespace std;

// main function, executed when code is run
int main() {

  // declare integer to store user's input for N
  int n;
  
  // take input for N
  cin >> n;
  
  // since N is STRICTLY a FOUR-DIGIT number, you only have to take the sum of the 4 numbers
  // this is done through the use of modulos
  // the last digit is found by finding the remainder of dividing the number by 10
  // the third digit is found by first dividing the number by 10 (remainder is trunctated) to only work with the first 3 digits, then modulo 10 to get the new number's last digit
  // the second digit is found by first dividing the number by 100 (remainder is truncated) to only work with the first 2 digits, then modulo 10 to get the new number's last digit
  // the first digit is found by dividing the number by 1000 (remainder is truncated)
  cout << n % 10 + n / 10 % 10 + n / 100 % 10 + n / 1000;
  
  // since the main function is an int, a value can be returned (actually not required in C99 or C++, and can be omitted)
  return 0;
}
