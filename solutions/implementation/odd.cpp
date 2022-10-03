#include <bits/stdc++.h>
using namespace std;
#define ll long long
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    // a ^ a = 0, thus all except one will be cancelled out
    ll xo_val = 0;
    int n;
    cin >> n;
    while(n--){
        ll p;
        cin >> p;
        // shift by 1 billion to prevent negative sign
        xo_val ^= p + 1000000000;
    }
    cout << (xo_val - 1000000000) << '\n';
    return 0;
}