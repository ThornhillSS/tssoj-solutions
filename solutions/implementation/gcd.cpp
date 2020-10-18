#include <bits/stdc++.h>
using namespace std;
int gcd(int a, int b)
{
    return (!a) ? b : gcd(b % a, a);
}
int main()
{
    cin.tie(0);
    //First, we take in the two numbers we're going to find the GCD of:
    int a, b; cin >> a >> b;
    //Finally, we use the typical implementation of GCD to get the GCD of these numbers:
    cout << gcd(a, b) << "\n";
}