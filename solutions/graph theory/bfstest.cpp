#include <bits/stdc++.h>
using namespace std;
#define endl '\n';
#define WHILE(n) while(n--)
#define pb push_back
#define LL long long
#define ULL unsigned long long
#define LD long double
#define LLI long long int
#define PI acos(-1)
const int MM = 1e5+1;
int n, e;bool visited[MM]; vector <int> adj[MM];
void dfs(int start){
    visited[start] = true;
    for(int v: adj[start]){
        if(!visited[v]){
            dfs(v);
        }
    }
}
int main(){
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> e;
    for(int i = 0; i < e; i++){
        int a,b; cin >> a >> b;
        adj[a].pb(b);
        adj[b].pb(a);
    }
    dfs(0);
    if(visited[n-1]){
        cout << "yes" << endl;
        return 0;
    }
    cout << "no" << endl;

}
