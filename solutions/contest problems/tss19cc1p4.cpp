/*
 * The idea of this problem is to compute the LCA of all nodes such that 
 * LCA[k][node] be the answer to the summation of depth(i)^k rooted at node 1.
 *
 * Therefore, the solution to each query is to take the sum of the answers
 * from node u and node v. The problem with this is that the answer to node
 * u or v is the path from node 1 to u or v, respectively. This means that 
 * we have overlapping answers, specifically from node 1 to the LCA of u and v.
 * In order to correct our solution, we must subtract the answer from 1 to the 
 * LCA of u and v, and then subtract the answer from 1 to the parent of the LCA.
 */


#include <bits/stdc++.h>

using namespace std;

#define make_unique(a) (a.erase(unique(a.begin(),a.end()),a.end()))
#define allof(x) (x).begin(), (x).end()
#define sz(x) ((int)(x).size())
#define pb push_back
#define exists(s, e) (s.find(e)!=s.end())
#define INF 0x3f3f3f3f
#define endl '\n'
#define mp make_pair
#define readln(x) (getline(cin, x))
#define watch(x) cerr << (#x) << " is " << (x) << endl;
#define debug(...) fprintf(stderr, __VA_ARGS__), fflush(stderr)
#define time__(d) for(long blockTime = 0; (blockTime == 0 ? (blockTime=clock()) != 0 : false); debug("%s time : %.4fs\n", d, (double)(clock() - blockTime) / CLOCKS_PER_SEC))

using pii = pair<int, int>;
using ll = long long;

mt19937 g1(time_t(0));

// seed: g1.seed(chrono::steady_clock::now().time_since_epoch().count());

int randint(int a, int b){return uniform_int_distribution<int>(a, b)(g1);}
ll randlong(ll a,ll b){return uniform_int_distribution<long long>(a, b)(g1);}

ll gcd(ll a, ll b) { return b == 0 ? a : gcd(b, a % b); }
ll lcm(ll a, ll b) { return a*b / gcd(a, b); }
ll fpow(ll  b, ll exp, ll mod){ if(exp == 0) return 1;ll t = fpow(b,exp/2,mod);if(exp&1) return t*t%mod*b%mod;return t*t%mod; }
ll divmod(ll i, ll j, ll mod){ i%=mod;j%=mod;return i*fpow(j,mod-2,mod)%mod; }

const int MAXN = 3e5 + 5;
const int LOGN = 22;
const int MOD = 998244353;
const int MAXK = 51;

#define int long long

int dep[MAXN], par[LOGN][MAXN], ans[MAXK][MAXN];
vector<int> adj[MAXN];

void dfs(int cur, int prev, int d) {
    dep[cur] = d;
    par[0][cur] = prev;
    ans[0][cur] = 1;
    for(int i=1; i<=50; i++) {
        ans[i][cur] = ans[i-1][cur] * dep[cur] % MOD;
    }
    for(int i=1; i<=50; i++) {
        ans[i][cur] = ((ans[i][prev] % MOD) + (ans[i][cur] % MOD)) % MOD;
    }
    for(int v : adj[cur]) {
        if(v^prev) {
            dfs(v, cur, d+1);
        }
    }
}

void run(int v, int root=1) {
    dfs(root, 0, 0);
    for(int i=1; i<LOGN; i++) {
        for(int j=1; j<=v; j++) {
            if(par[i-1][j]) {
                par[i][j] = par[i-1][par[i-1][j]];
            }
        }
    }
}

int lca(int v, int w) {
    if(dep[v] < dep[w]) swap(v, w);
    for(int i=LOGN-1; i>=0; i--) {
        if(par[i][v] != -1 && dep[par[i][v]] >= dep[w]) v = par[i][v];
    }
    if(v==w) return v;
    for(int i=LOGN-1; i>=0; i--) {
        if(par[i][v] != par[i][w]) {
            v = par[i][v];
            w = par[i][w];
        }
    }
    return par[0][v];
}

void solve() {
    int n; cin >> n;
    for(int i=0; i<n-1; i++) {
        int a, b;
        cin >> a >> b;
        adj[a].pb(b);
        adj[b].pb(a);
    }
    run(n);

    int q; cin >> q;
    while(q--) {
        int u, v, k;
        cin >> u >> v >> k;
        int _lca = lca(u, v);
//        watch(_lca);
//        watch(ans[k][u]);
//        watch(ans[k][v]);
//        watch(ans[k][_lca]);
        ll res = (((ans[k][u] + ans[k][v])%MOD - ans[k][_lca])%MOD - ans[k][par[0][_lca]]%MOD) % MOD;
        while(res<0) res += MOD;
        cout << res << endl;
    }
}

int32_t main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    solve();
    return 0;
}
