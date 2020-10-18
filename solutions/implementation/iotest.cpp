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
using namespace std;
int a, b; 
int main() {
    int a; scan(a); 
    while(a--){
        scan(b); printf("%d\n", b+1); 
    }
    return 0;
}
// by using fast i/o and printf we can pass iotest under the time limit
