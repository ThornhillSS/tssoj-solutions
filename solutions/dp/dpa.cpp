#include<bits/stdc++.h> 
#pragma GCC optimize("Ofast")
#pragma GCC target("avx,avx2,fma")
#define gc(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
#define ms(a,b) memset(a,b,sizeof(a));
char _;

using namespace std;

int dp[100000];
int arr[100000];
int main()
{
    ms(dp,-1);
    int N; gc(N);
    for(int i = 0; i < N; ++i){
        int a; gc(a);
        arr[i]=a;
    }
    dp[0]=0;
    for(int i = 1; i < N; ++i){
        dp[i]=INT_MAX;
        if(i-1>=0){
            dp[i]=min(dp[i],dp[i-1]+abs(arr[i]-arr[i-1]));
        }
        if(i-2>=0){
            dp[i]=min(dp[i],dp[i-2]+abs(arr[i]-arr[i-2]));
        }
    }
    printf("%i",dp[N-1]);
    return 0;
}
// this question is very similar to fibonacci
// for each dp state we only have to consider the minimum possible ways to get to stone cur-1 or cur-2 and choose the stone that costs the minimum to get to
// the cost to get o the first stone is 0 and we can build the dp statest from there
