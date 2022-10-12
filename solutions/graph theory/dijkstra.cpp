#include <bits/stdc++.h>

using namespace std;
using ll = long long;

int main(){
    cin.tie(0)->sync_with_stdio(0);
    int N, M; cin >> N >> M;
    struct Edge{ int to; ll w; };
    vector<vector<Edge>> adj(N);
    for (int i = 0; i < M; ++i){
        int a, b; ll c; cin >> a >> b >> c;
        adj[a].push_back({b, c});
        adj[b].push_back({a, c});
    }
    
    struct Item{
        ll d; int v;
        bool operator<(const Item &other) const{
            return d > other.d;
        }
    };
    vector<ll> dist(N, 1e18);
    dist[0] = 0;
    priority_queue<Item> pq;
    pq.push({0, 0});
    while (!pq.empty()){
        auto [d, v] = pq.top(); pq.pop();
        if (d != dist[v]) continue;
        for (auto [to, w] : adj[v]){
            if (d + w < dist[to]){
                dist[to] = d + w;
                pq.push({dist[to], to});
            }
        }
    }

    int Q; cin >> Q;
    while (Q--){
        int a; cin >> a;
        if (dist[a] == 1e18) cout << -1 << '\n';
        else cout << dist[a] << '\n';
    }
}
