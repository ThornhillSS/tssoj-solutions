#include <bits/stdc++.h>
#include <ext/pb_ds/assoc_container.hpp>

using namespace std;
using namespace __gnu_pbds;
using ll = long long;

cc_hash_table<int, ll> dp;

ll solve(int n){
    if (dp[n]) return dp[n];
    for (int k = 2; k * k <= n; ++k){
        dp[n] += solve(n / k);
    }
    for (int k = 1; k < n / k; ++k){
        dp[n] += solve(k) * (n / k - n / (k + 1));
    }
    return dp[n];
}

int main(){
    cin.tie(0)->sync_with_stdio(0);
    int N; cin >> N;
    dp[1] = dp[2] = 1; dp[3] = 2;
    cout << solve(N) << '\n';
}
