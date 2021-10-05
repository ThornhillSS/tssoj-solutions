#include <bits/stdc++.h>
using namespace std;

#define ll long long
#define MAXN 420
#define loop(i,a,b) for(int i = (int) a; i< (int) b; i++)
#define loopr(i,a,b) for(int i = (int) a-1; i>= (int) b; i--)

//Xi, Xj
int arr[MAXN][MAXN];

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);

    loop(i,0,420){
        loop(j,0,420){
            arr[i][j] = INT_MAX;
        }
    }

    arr[0][0] = 0;

    int N,M1,M2; cin>>N>>M1>>M2;

    loop(i, 0, N){
        int a,b,c; cin>>a>>b>>c;

        loopr(xarr, 400, 0){
            loopr(yarr , 400, 0){
                if( arr[xarr][yarr] != INT_MAX){
                    arr[xarr+a][yarr+b] = min(arr[xarr+a][yarr+b], arr[xarr][yarr] + c);
                }
            }
        }
    }

    int MAXCOST = INT_MAX;

    loop(i,1,MAXN){
        if(i * max(M1, M2) > 400) break;
        if(arr[i*M1][i*M2] < MAXCOST){
            MAXCOST = arr[i*M1][i*M2];
        }
    }

    

    if(MAXCOST == INT_MAX) cout<<-1;
    else cout<<MAXCOST;



    return 0;
}
