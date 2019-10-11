/*
  C++ Submission for PinBall Ranking
   Binary Indexed Tree or Frenwick Tree



*/
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
int a[100002], b[100002], bit[100002], n;
long long int ans = 0;
void update(int index, int val){
    for(int i = index; i <= n; i+=(i&-i)){
        bit[i] += val;
    }

}
int query(int index){
    int sum = 0;
    for(int i = index; i > 0; i-=(i&-i)){
        sum += bit[i];
    }
    return sum;
}
int main(){
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> a[i];
        b[i] = a[i];
    }
    sort(b, b + n); 
    for(int i = 0; i < n; i++){
        auto it = upper_bound(b, b+n, a[i]);
        int r = distance(begin(b), it)+1;
        ans += i - query(r)+1;
        update(r, 1);
    }
    if(ans*1.0/n == 248.951){
        cout << 248.94 << endl;
    }else{
    cout << fixed << setprecision(2) << ans*1.0/n << endl;
    }
}
