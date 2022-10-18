#include <bits/stdc++.h>
#ifdef NDEBUG
#   pragma GCC optimize("Ofast")
#   pragma GCC optimize("unroll-loops")
#endif
#pragma GCC target("avx,avx2,fma")
#define unsync cin.sync_with_stdio(false); cin.tie(nullptr);
using namespace std;

#include <numeric> // has the new std::gcd for c++17

int main() {
    int n, m;
    cin >> n >> m;

    cout << gcd(n, m);
}