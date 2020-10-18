#include <bits/stdc++.h>
using namespace std;
int main()
{
    cin.tie(0);
    int n; cin >> n;
    long long sum = 0;
    for (int i = 1; i <= n; i++)
    {
        int num; cin >> num;
        sum += num;
    }
    cout << sum << "\n";
}
