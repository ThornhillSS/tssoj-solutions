#include <bits/stdc++.h>
#ifdef NDEBUG
#   pragma GCC optimize("Ofast")
#   pragma GCC optimize("unroll-loops")
#endif
#pragma GCC target("avx,avx2,fma")
#define unsync cin.sync_with_stdio(false); cin.tie(nullptr);
using namespace std;

#include <array> // for better c++ arrays

int main() {
    array<int, 4> burgers = {461, 431, 420, 0};
    array<int, 4> sides = {100, 57, 70, 0};
    array<int, 4> drinks = {130, 160, 118, 0};
    array<int, 4> desserts = {167, 266, 75, 0};

    int a, b, c, d, total{};
    cin >> a >> b >> c >> d;

    total += burgers[a - 1]; // substract 1 to ensure that index is not out of bounds
    total += sides[b - 1];
    total += drinks[c - 1];
    total += desserts[d - 1];

    cout << "Your total calorie count is " << total << ".";
}