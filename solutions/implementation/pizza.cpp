//
// Created by ryan javid on 2021-09-20.
//

#include <bits/stdc++.h>
using namespace std;
int n;
void hanoi(int n, char a, char c, char b) {
    if(n == 1) {
        cout << n << " " << a << " - " << c << endl;
        return;
    }
    hanoi(n-1, a, b, c);
    cout << n << " " << a << " - " << c << endl;
    hanoi(n-1, b, c, a);
}

int main() {
    cin >> n;
    cout << pow(2,n)-1 << endl;
    hanoi(n, 'A', 'C', 'B');
}
