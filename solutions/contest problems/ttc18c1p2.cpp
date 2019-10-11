#include <iostream>

using namespace std;
int main() {
  int n; //number of elements
  cin >> n; 
  string stuff [n]; //string array with number of elements equal to number of elements which is equal to the string input
  int other [n];    //int array with the same number of elements which is equal to the int inputs
  for(int i = 0; i < n; i++) {
    cin >> stuff [i]; //assigns the inputs to the array
    cin >> other [i]; //same thing
  }
  for(int i = 0; i < n; i++){ //does it "number of elements" times
    if(other[0] <= other[i]) { //if the number is less than or equal to the other number, swap the next 2 elements
      other[0] = other[i];
      stuff[0] = stuff[i];
    }
  }
  cout << stuff [0]; //output
}
