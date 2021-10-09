#include <bits/stdc++.h>
using namespace std;
int main()
{
    cin.tie(0);
    int n, sum = 0; cin >> n;
    for (int i = 1; i <= n; i++)
    {
        int val; cin >> val;
        sum += val;
        cout << sum << ((i == n) ? "\n" : " ");
    }
}