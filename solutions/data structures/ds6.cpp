#include <bits/stdc++.h>

using namespace std;
using ll = long long;

template<typename S, typename D, typename F>
struct LinkCutTree{
    struct Node{
        int ch[2] = {-1, -1}, p = -1;
        S val{};
        D path = D::e();
        F lazy = F::id();
        bool rev = 0;
    };
    vector<Node> T;

    LinkCutTree(int N) : T(N) {}

    void apply_lazy(int v, F f){
        T[v].val = f.apply(T[v].val);
        T[v].path = f.apply(T[v].path);
        T[v].lazy = F::composition(f, T[v].lazy);
    }

    void apply_rev(int v){
        swap(T[v].ch[0], T[v].ch[1]);
        T[v].path.reverse();
        T[v].rev ^= 1;
    }

    void push(int v){
        if (v == -1) return;

        int lc = T[v].ch[0], rc = T[v].ch[1];
        if (!(T[v].lazy == F::id())){
            if (lc != -1) apply_lazy(lc, T[v].lazy);
            if (rc != -1) apply_lazy(rc, T[v].lazy);
            T[v].lazy = F::id();
        }
        if (T[v].rev){
            if (lc != -1) apply_rev(lc);
            if (rc != -1) apply_rev(rc);
            T[v].rev = 0;
        }

    }

    void pull(int v){
        push(v);
        int lc = T[v].ch[0], rc = T[v].ch[1];

        T[v].path = D::e();
        if (lc != -1) T[v].path = D::op(T[v].path, T[lc].path);
        T[v].path = D::op(T[v].path, D::make(T[v].val));
        if (rc != -1) T[v].path = D::op(T[v].path, T[rc].path);
    }

    void splay(int v){
        auto dir = [&](int v){
            int p = T[v].p;
            if (p == -1) return -1;
            if (T[p].ch[0] == v) return 0;
            if (T[p].ch[1] == v) return 1;
            return -1;
        };
        auto stick = [&](int v, int p, int dir){
            T[p].ch[dir] = v;
            if (v != -1) T[v].p = p;
            pull(p);
        };
        auto rot = [&](int v){
            int p = T[v].p, g = T[p].p;
            int dv = dir(v), dp = dir(p);
            stick(T[v].ch[dv^1], p, dv);
            stick(p, v, dv^1);
            if (dp != -1) stick(v, g, dp);
            T[v].p = g;
        };
        while (dir(v) != -1){
            int p = T[v].p, g = T[p].p;
            if (g != -1) push(T[g].p);
            push(g), push(p), push(v);
            int dv = dir(v), dp = dir(p);
            if (dp != -1) rot(dv == dp ? p : v);
            rot(v);
        }
        push(v);
    }

    int access(int v){
        int t = v, last = -1;
        while (v != -1){
            splay(v);
            T[v].ch[1] = last;
            pull(v);
            last = v;
            v = T[v].p;
        }
        splay(t);
        return last;
    }

    void link(int v, int p){ reroot(v); T[v].p = p; }
    void cut(int v){
        access(v);
        int lc = T[v].ch[0];
        if (lc != -1){
            T[lc].p = T[v].ch[0] = -1;
            pull(v);
        }
    }
    void cut(int v, int p){
        reroot(p);
        cut(v);
    }
    void set(int v, S val){ access(v); T[v].val = val; pull(v); }
    void reroot(int v){
        access(v);
        apply_rev(v);
    }
    void apply(int u, int v, F f){
        reroot(u), access(v);
        apply_lazy(v, f);
    }
    D path(int u, int v){ return reroot(u), access(v), T[v].path; }
    int lca(int u, int v){
        if (u == v) return u;
        access(u);
        int x = access(v);
        return T[u].p == -1 ? -1 : x;
    }
    bool connected(int u, int v){
        return lca(u, v) != -1;
    }
};

using S = struct{
    int val, sz;
};
struct P{
    int mn, mx, sum, sz;

    static P op(P a, P b){
        return {min(a.mn, b.mn), max(a.mx, b.mx), a.sum + b.sum, a.sz + b.sz};
    }

    static P e(){
        return {INT_MAX, INT_MIN, 0, 0};
    }

    static P make(S s){
        return {s.val, s.val, s.val, s.sz};
    }

    // only necessary for non-commutative operations
    void reverse(){

    }
};
struct F{
    bool setflag;
    int set, inc;

    P apply(P p){
        P ret = p;
        if (setflag){
            ret.mn = ret.mx = set;
            ret.sum = ret.sz * set;
        }
        ret.mn += inc, ret.mx += inc;
        ret.sum += inc * ret.sz;
        return ret;
    }

    S apply(S x){
        P p = apply(P::make(x));
        return {p.sum, p.sz};
    }

    bool operator==(F other){
        return setflag == other.setflag && set == other.set && inc == other.inc;
    }

    static F composition(F f, F g){
        if (f.setflag) return f;
        g.inc += f.inc;
        return g;
    }

    static F id(){
        return {0, 0, 0};
    }
};

int main(){
    cin.tie(0)->sync_with_stdio(0);
    int N, Q; cin >> N >> Q;
    LinkCutTree<S, P, F> lct(N + 1);
    for (int i = 1; i <= N; ++i){
        int val; cin >> val;
        lct.set(i, {val, 1});
    }
    for (int i = 1; i <= N - 1; ++i){
        int a, b; cin >> a >> b;
        lct.link(a, b);
    }
    int rt; cin >> rt;
    while (Q--){
        int op; cin >> op;
        if (op == 0){
            cin >> rt;
        }
        if (op == 1){
            int x, y, z; cin >> x >> y >> z;
            lct.apply(x, y, {1, z, 0});
        }
        if (op == 2){
            int x, y, z; cin >> x >> y >> z;
            lct.apply(x, y, {0, 0, z});
        }
        if (op == 3){
            int x, y; cin >> x >> y;
            cout << lct.path(x, y).mn << '\n';
        }
        if (op == 4){
            int x, y; cin >> x >> y;
            cout << lct.path(x, y).mx << '\n';
        }
        if (op == 5){
            int x, y; cin >> x >> y;
            cout << lct.path(x, y).sum << '\n';
        }
        if (op == 6){
            int x, y; cin >> x >> y;
            lct.reroot(rt);
            if (lct.lca(x, y) != x){
                lct.cut(x);
                lct.link(x, y);
            }
        }
        if (op == 7){
            int x, y; cin >> x >> y;
            lct.reroot(rt);
            cout << lct.lca(x, y) << '\n';
        }
    }
}
