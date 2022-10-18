#include <bits/stdc++.h>
#ifdef NDEBUG
#   pragma GCC optimize("Ofast")
#   pragma GCC optimize("unroll-loops")
#endif
#pragma GCC target("avx,avx2,fma")
#define unsync cin.sync_with_stdio(false); cin.tie(nullptr);
using namespace std;

int main() {
    string name;
    cin >> name;

    char c = name[0];
    // compare the first char of input to ascii values: <73 for capital A-I, 74-83 for capital J-S, >84 for everything else
    if(c <= 'I') {
        cout << "Group 1.";
    } else if(c >= 'J' && c <= 'S') {
        cout << "Group 2.";
    } else {
        cout << "Group 3.";
    }
}