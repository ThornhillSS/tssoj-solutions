//============================================================================
// Name        : lexisorted1.cpp
// Author      : Robloxian
// Version     :
// Description : Code that sorts strings
//============================================================================

#include <bits/stdc++.h>
using namespace std;
inline int GCD (int a, int b) { return b == 0 ? a : GCD(b, a % b); }
inline int LCM (int a, int b) { return a * b / GCD(a, b); }
#define endl '\n';
#define WHILE(n) while(n--)
#define pb push_back    
#define PI acos(-1)
#define FOR(i,l,r) for (int i=l;i<=r;i++)
#define FORD(i,r,l) for (int i=r;i>=l;i--)
#define EL printf("\n")
typedef pair<int, int> pii;
typedef long long ll;
typedef long double ld;
typedef long long int lli;
typedef unsigned long long ull;
vector <string> letters;//stores all the strings
int main(){
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n; cin >> n;
    cin.ignore(numeric_limits<std::streamsize>::max(), '\n' );//used after cin so you can use getline properly
    while(n--){
        string a;
        getline(cin, a);
        letters.pb(a);//stores the strings
    }
    sort(letters.begin(), letters.end());//sort
    for(string c: letters){//print out strings
        cout << c << endl;
    }
 
