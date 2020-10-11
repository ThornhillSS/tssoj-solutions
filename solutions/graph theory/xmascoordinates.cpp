#include <bits/stdc++.h>
using namespace std;
#define pb push_back
typedef long long ll;
typedef long double ld;
char grid[1000][1000];
bool visited[1000][1000];
int dist[1000][1000];
int n,m, rp, cp, ro, co, rx, cx;
int main()
{
    // Solve with running breadth first search twice
    cin.sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> n >> m;
    for(int i =0; i < n; i++){
        for(int j = 0; j < m; j++){
            dist[i][j] = static_cast<int>(10e9);
            visited[i][j] = false;
            char c;
            cin >> c;
            grid[i][j] = c;
            if(c == 'X'){
                rx = i;
                cx = j;
            }
            if(c == 'O'){
                ro = i;
                co = j;
            }
            if(c == 'P'){
                rp = i;
                cp = j;
            }
        }
    }
    int mvr[] {0,0, -1, 1};
    int mvc[] {-1,1,0,0};
    queue<pair<int,int>> q;
    q.push(pair<int,int>(rp,cp));
    visited[rp][cp] = true;
    dist[rp][cp] = 0;
    while(!q.empty()){
        auto v = q.front(); q.pop();
        for(int i = 0; i < 4; i++){
            int r = v.first + mvr[i];
            int c = v.second + mvc[i];
            if(r >= 0 && r < n && c >= 0 && c < m && grid[r][c] != '#' && !visited[r][c]){
                dist[r][c] = dist[v.first][v.second] + 1;
                q.push(pair<int,int>(r,c));
                visited[r][c] = true;
            }
        }
    }
    int k = dist[rx][cx] + dist[ro][co];
    cout << ((k<10e9 && k >= 0)? k: -1);
}
