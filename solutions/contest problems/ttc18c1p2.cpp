#include <iostream>

using namespace std;
int main() {
  int n;
  cin >> n;
  string stuff [n];
  int other [n];
  for(int i = 0; i < n; i++) {
    cin >> stuff [i];
    cin >> other [i];
  }
  for(int i = 0; i < n; i++){
    if(other[0] <= other[i]) {
      other[0] = other[i];
      stuff[0] = stuff[i];
    }
  }
  cout << stuff [0];
}
