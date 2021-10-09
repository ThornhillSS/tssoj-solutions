#include <bits/stdc++.h>
#include <regex>
using namespace std;
#define endl '\n';
#define WHILE(n) while(n--)
#define pb push_back
#define LL long long
#define ULL unsigned long long
#define LD long double
#define LLI long long int
#define PI acos(-1)
int ans = 0, start = 0;
string s;
int main(){
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin >> s;
    start = (s[0] == 'n' ? 2 : 3);
    ans = (s[0] == 'n' ? -1 * pow(-1, ((s.size()-1) - start)/2): 1 * pow(-1, ((s.size()-1) - start)/2));
    cout << (ans == -1 ? "no" : "yes") << endl;
}
