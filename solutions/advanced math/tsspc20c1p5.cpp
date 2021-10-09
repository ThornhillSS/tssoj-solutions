#include <bits/stdc++.h>
using namespace std;
#define ll long long
ll solve(ll n, ll m){
    if (m > n){
        ll temp = n;
        n = m;
        m = temp;
    }
    ll a = 1;
    for(ll i = n+1; i <= n+m; i++){
        a = (a * i) % 1000000007;
    }
    ll b = 1;
    for(ll i = 1; i <= m; i++){
        b = (b * i) % 1000000007;
    }
    ll res = 1;
    // mod inverse
    ll x = 1000000005;
    // fast exponentiation by squaring
    while (x>0){
        if ((x & 1) == 1){
            res = (res * b) % 1000000007;
        }
        b = (b*b)% 1000000007;
        x >>= 1;
    }
    // find solution by using choose
    return (a*res) % 1000000007;
}
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    int n, m;
    cin >> n >> m;
    cout << solve(n,m);
    return 0;
}