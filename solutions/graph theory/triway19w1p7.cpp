//
// Created by ryan javid on 2021-10-24.
//

#include <bits/stdc++.h>
using namespace std;
vector<vector<int>> adj(2001);
int n, m, a, b, x, y;
int main() {
    cin >> n >> m >> a >> b;
    for(int i = 0; i < m; i++) {
        cin >> x >> y;
        adj[x].push_back(y);
        adj[y].push_back(x);
    }
    queue<int> q;
    vector<int> visited(2001, 0);
    q.push(a);
    visited[a] = 1;
    while(!q.empty()) {
        int cur = q.front();
        q.pop();
        for(auto i : adj[cur]) {
            if(!visited[i]) {
                q.push(i);
                visited[i] = 1;
            }
        }
    }
    if(visited[b] == 1) {
        cout << "GO SHAHIR!";
    } else {
        cout << "NO SHAHIR!";
    }
}
