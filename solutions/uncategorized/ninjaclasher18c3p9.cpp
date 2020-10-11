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
int n,q, arr[1001]; // based on input specifications
int main(){
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> q; 
    for(int i = 0; i < n; i++){
      cin >> arr[i]; // read into array.
    }
    WHILE(q){ // while q > 0
      int d,l,r,v,k;
      cin >> d;
      if(d == 1){ // satisfy input
        cin >> l >> r >> v >> k; // read input
        l--; r--; // index starts at 0 so subtract 1.
        for(int i = l; i <= r; i++){
          if(arr[i] > k){ // if greater then subtract value.
            arr[i] -= v;
          }
        }
      }else{
        int sum = 0;
        cin >> l >> r >> k;
        l--; r--;  // index starts at 0 so subtract 1.
        for(int i = l; i <= r; i++){
          if(arr[i] > k){ // if greater then add value.
            sum += arr[i];
          }
        }
        cout << sum << endl; // print out sum
      }
    }


}
