#include<bits/stdc++.h>
#define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
#define boost() cin.tie(0); cin.sync_with_stdio(0);
#define ms(a,b) memset(a,b,sizeof(a));
#define mp make_pair
#define pb push_back
char _;
typedef  unsigned long long ull;
typedef long long ll;
typedef long double ld;
const ll MM = 1e5+10; 
using namespace std; 
ll bit[MM], res = 0, N; 
void upd(int cur){
  for(; cur <= N; cur+=cur&-cur) ++bit[cur];
}
int que(int cur){
  int res = 0; 
  for(; cur > 0; cur-=cur&-cur) res+=bit[cur]; 
  return res; 
}
int main() {
  scan(N); 
  for(int i = 1; i <= N; ++i){
    int cur; scan(cur);
    res+=que(N) - que(cur);
    upd(cur);  
  }
  cout<<res<<endl; 
  return 0; 
}
// By using a fenwick tree (binary indexed tree) we can keep query and update for inversions in o(logn) time which is sufficient to pass the problem 
// sub link : https://tssoj.ca/submission/24947
