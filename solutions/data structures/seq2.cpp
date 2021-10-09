#include <bits/stdc++.h>
using namespace std;
#define ll long long
mt19937_64 rns(0xDEADBEEF);
uniform_int_distribution<int> rng(0, INT_MAX);
// Implicit Treap
struct treap{
    treap *l, *r;
    int size = 1, sum;
    ll priority;
    int value;
    bool reverse = false;
    int set_val = INT_MAX;
    int prefix = 0, suffix = 0;
    int max = 0;
    treap(int value){
        l = nullptr;
        r = nullptr;
        this->value = value;
        max = value;
        sum = value;
        prefix = suffix = value;
        size = 1;
        priority = rng(rns);
    }
};
#define tg(x, p) ((x) == nullptr ? 0 : (x)->p)
void prop(treap* node){
    if(node == nullptr) return;
    if(node->set_val != INT_MAX){
        node->reverse = false;
        node->value = node->set_val;
        if(node->set_val > 0){
            node->prefix = node->suffix = node->max = node->set_val * node->size;
        }
        else{
            node->prefix = node->suffix = node->max = node->set_val;
        }
        node->sum = node->set_val * node->size;
        if(node->l != nullptr) node->l->set_val = node->set_val;
        if(node->r != nullptr) node->r->set_val = node->set_val;
        node->set_val = INT_MAX;
    }
    if(node->reverse){
        node->reverse = false;
        swap(node->l, node->r);
        swap(node->prefix, node->suffix);
        if(node->l != nullptr) node->l->reverse ^= true;
        if(node->r != nullptr) node->r->reverse ^= true;
    }
}
void calc(treap* tree){
    if(tree == nullptr) return;
    if(tree->l != nullptr) prop(tree->l);
    if(tree->r != nullptr) prop(tree->r);
    tree->size = tg(tree->l, size) + tg(tree->r, size) + 1;
    tree->sum = tg(tree->l, sum) + tg(tree->r, sum) + tree->value;

    int lpre = -10000, lsuf = -10000, lsum = 0, lmax = -10000, lcsum = -10000;
    int rpre = -10000, rsuf = -10000, rsum = 0, rmax = -10000, rcsum = -10000;
    if(tree->l != nullptr){
        lpre = tree->l->prefix;
        lsuf = tree->l->suffix;
        lsum = tree->l->sum;
        lcsum = tree->l->sum;
        lmax = tree->l->max;
    }
    if(tree->r != nullptr){
        rpre = tree->r->prefix;
        rsuf = tree->r->suffix;
        rsum = tree->r->sum;
        rcsum = tree->r->sum;
        rmax = tree->r->max;
    }
    auto pre = tree->prefix = lpre, suf = tree->suffix = rsuf, sum = tree->sum, mx = tree->max = max(lmax, rmax);

    pre = max(pre, max(lcsum, lsum + tree->value + rpre));
    pre = max(pre, lsum + tree->value);
    if(tree->l == nullptr) pre = max(pre, tree->value);

    suf = max(suf, max(rcsum, rsum + tree->value + lsuf));
    suf = max(suf, rsum + tree->value);
    if(tree->r == nullptr) suf = max(suf, tree->value);

    mx = max(mx, max(pre, suf));
    mx = max(mx, lsuf + tree->value);
    mx = max(mx, rpre + tree->value);
    mx = max(mx, lsuf + tree->value + rpre);
    mx = max(mx, tree->value);
    tree->prefix = pre;
    tree->suffix = suf;
    tree->max = mx;
}
pair<treap*, treap*> split(treap* tree, int vkey, int lcnt = 0){
    if(tree == nullptr) return {nullptr, nullptr};
    prop(tree);
    int vIdx = lcnt + tg(tree->l, size);
    if(vIdx >= vkey){
        auto spl = split(tree->l, vkey, lcnt);
        tree->l = spl.second;
        calc(tree);
        assert(tree->l != tree && tree->r != tree);
        return {spl.first, tree};
    }else{
        auto spl = split(tree->r, vkey, vIdx + 1);
        tree->r = spl.first;
        calc(tree);
        assert(tree->l != tree && tree->r != tree);
        return {tree, spl.second};
    }
}
treap* merge(treap* l, treap* r){
    if(l == nullptr) return r;
    if(r == nullptr) return l;
    prop(l);
    prop(r);
    if(tg(l, priority) < tg(r, priority)){
        l->r = merge(l->r, r);
        calc(l);
        return l;
    }else{
        r->l = merge(l, r->l);
        calc(r);
        return r;
    }
}
void delete_tree(treap* tree){
    if(tree == nullptr) return;
    delete_tree(tree->l);
    delete_tree(tree->r);
    delete tree;
}
void insert(treap*& tree, int idx, int value){
    if(tree == nullptr){
        tree = new treap(value);
        return;
    }
    auto spl = split(tree, idx);
    tree = merge(merge(spl.first, new treap(value)), spl.second);
}
treap* root;
void delete_range(int i, int l){
    if(l == 0) return;
    auto p1 = split(root, i);
    auto p2 = split(p1.second, l);
    delete_tree(p2.first);
    root = merge(p1.first, p2.second);
}
void update_reverse(int i, int l){
    if(l == 0) return;
    auto p1 = split(root, i);
    auto p2 = split(p1.second, l);
    p2.first->reverse ^= true;
    prop(p2.first);
    root = merge(merge(p1.first, p2.first), p2.second);
}
void update_change(int i, int l, int c){
    if(l == 0) return;
    auto p1 = split(root, i);
    auto p2 = split(p1.second, l);
    p2.first->set_val = c;
    prop(p2.first);
    root = merge(merge(p1.first, p2.first), p2.second);
}
int query_sum(int i, int l){
    if(l == 0) return 0;
    auto p1 = split(root, i);
    auto p2 = split(p1.second, l);
    prop(p2.first);
    int val = p2.first->sum;
    root = merge(merge(p1.first, p2.first), p2.second);
    return val;
}
void in_order_traversal(treap* tree){
    if(tree != nullptr){
        in_order_traversal(tree->l);
        cout << tree->value << " ";
        in_order_traversal(tree->r);
    }
}
void heapify(treap* node){
    if(!node) return;
    auto ctop = node;
    if(node->l && node->l->priority < node->priority){
        ctop = node->l;
    }
    if(node->r && node->r->priority < node->priority){
        ctop = node->r;
    }
    if(ctop != node){
        swap(ctop->priority, node->priority);
        heapify(ctop);
    }
}
treap* build(vector<int>& s, int l, int r){
    if(l == r) return nullptr;
    int mid = (l + r) / 2;
    auto t = new treap(s[mid]);
    t->l = build(s, l, mid);
    t->r = build(s, mid+1, r);
    heapify(t);
    calc(t);
    return t;
}
int main()
{
    // Maintain and update data with implicit treap
    // Reverse by reversing children & all stored data
    // Lazily propagate reverse & make same, make same takes priority as it makes reverse useless
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    vector<int> tvec;
    int n, m;
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        int x;
        cin >> x;
        tvec.push_back(x);
    }
    root = build(tvec, 0, n);
    string s;
    while(m--){
        cin >> s;
        if(s == "INSERT"){
            int pos, cnt;
            cin >> pos >> cnt;
            vector<int> vec;
            while(cnt--){
                int q;
                cin >> q;
                vec.push_back(q);
            }
            auto node = build(vec, 0, vec.size());
            auto spl = split(root, pos);
            root = merge(merge(spl.first, node), spl.second);

        }else if(s == "DELETE"){
            int pos, cnt;
            cin >> pos >> cnt;
            delete_range(pos-1, cnt);
        }else if(s == "MAKE-SAME"){
            int pos, cnt, c;
            cin >> pos >> cnt >> c;
            update_change(pos-1, cnt, c);
        }else if(s == "REVERSE"){
            int pos, cnt;
            cin >> pos >> cnt;
            update_reverse(pos-1, cnt);
        }else if(s == "GET-SUM"){
            int pos, cnt;
            cin >> pos >> cnt;
            cout << query_sum(pos-1, cnt) << '\n';
        }else{
            cout << root->max << '\n';
        }
    }
    return 0;
}