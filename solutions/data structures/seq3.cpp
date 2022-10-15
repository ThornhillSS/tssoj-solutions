#pragma GCC optimize("Ofast")
#include <bits/stdc++.h>
using namespace std;
#define endl '\n'
mt19937 mt_rand(2058);

/* Treap implementation (from original problem) */
struct Node {
    Node *l, *r;
    int x, y, c, s, mx, ml, mr, eq;
    bool i, e;
    
    Node(int x) : l(NULL), r(NULL), x(x), y(mt_rand()), c(1), s(x), mx(x), ml(max(0, x)), mr(max(0, x)), i(false), e(false) {}
};

int count(Node* cur) {
    return cur ? cur->c : 0;
}

int sum(Node* cur) {
    return cur ? cur->s : 0;
}

int ml(Node* cur) {
    return cur ? cur->ml : 0;
}

int mr(Node* cur) {
    return cur ? cur->mr : 0;
}

void push(Node* cur) {
    if(!cur) return;

    if(cur->i) {
        cur->i = false;
        swap(cur->l, cur->r);
        swap(cur->ml, cur->mr);
        if(cur->l)
            cur->l->i ^= true;
        if(cur->r)
            cur->r->i ^= true;
    }

    if(cur->e) {
        cur->e = false;
        cur->x = cur->eq;
        cur->s = cur->x * cur->c;
        cur->mx = max(cur->s, cur->x);
        cur->ml = max(0, cur->s);
        cur->mr = max(0, cur->s);

        if(cur->l) {
            cur->l->e = true;
            cur->l->eq = cur->eq;
        }
        if(cur->r) {
            cur->r->e = true;
            cur->r->eq = cur->eq;
        }
    }
}

void update(Node* cur) {
    if(!cur) return;
    push(cur->l); push(cur->r);

    cur->c = 1 + count(cur->l) + count(cur->r);
    cur->s = cur->x + sum(cur->l) + sum(cur->r);

    cur->ml = max(ml(cur->r), sum(cur->r) + cur->x + max(0, ml(cur->l)));
    cur->mr = max(mr(cur->l), sum(cur->l) + cur->x + max(0, mr(cur->r)));
    
    cur->mx = cur->x + ml(cur->l) + mr(cur->r);
    if(cur->l) cur->mx = max(cur->mx, cur->l->mx);
    if(cur->r) cur->mx = max(cur->mx, cur->r->mx);
}

void merge(Node* &cur, Node* l, Node* r) {
    push(l); push(r);

    if(!l || !r) {
        cur = l ? l : r;
    } else if(l->y > r->y) {
        merge(l->r, l->r, r);
        cur = l;
    } else {
        merge(r->l, l, r->l);
        cur = r;
    }

    update(cur);
}

void split(Node* cur, Node* &l, Node* &r, int k, int t=0) {
    if(!cur) {
        l = r = NULL;
        return;
    }

    push(cur);
    int i = t + count(cur->l);
    if(i >= k) {
        split(cur->l, l, cur->l, k, t);
        r = cur;
    } else {
        split(cur->r, cur->r, r, k, i+1);
        l = cur;
    }
    update(cur);
}

void reverse(Node* &cur, int l, int r) {
    Node *L, *M, *R;
    split(cur, L, M, l-1);
    split(M, M, R, r-l);
    M->i ^= true;
    merge(cur, L, M);
    merge(cur, cur, R);
}

void equalize(Node* &cur, int l, int r, int x) {
    Node *L, *M, *R;
    split(cur, L, M, l-1);
    split(M, M, R, r-l);
    M->e = true;
    M->eq = x;
    merge(cur, L, M);
    merge(cur, cur, R);
}

int getsum(Node* &cur, int l, int r) {
    Node *L, *M, *R;
    split(cur, L, M, l-1);
    split(M, M, R, r-l);
    int ans = sum(M);
    merge(cur, L, M);
    merge(cur, cur, R);
    return ans;
}

void delete_all(Node* cur) {
    if(!cur) return;
    delete_all(cur->l);
    delete_all(cur->r);
    delete cur;
}

void remove(Node* &cur, int l, int r) {
    Node *L, *M, *R;
    split(cur, L, M, l-1);
    split(M, M, R, r-l);
    delete_all(M);
    merge(cur, L, R);
}

void insert(Node* &cur, int i, Node* M) {
    if(!cur) {
        cur = M;
        return;
    }

    Node *L, *R;
    split(cur, L, R, i);
    merge(L, L, M);
    merge(cur, L, R);
}

void heapify(Node* cur) {
    if(!cur) return;
    Node* max = cur;
    if(cur->l && cur->l->y > max->y)
        max = cur->l;
    if(cur->r && cur->r->y > max->y)
        max = cur->r;
    if(cur != max) {
        swap(cur->y, max->y);
        heapify(max);
    }
}

Node* build(int* a, int n) {
    if(!n) return NULL;
    int m = n/2;
    Node* cur = new Node(a[m]);
    cur->l = build(a, m);
    cur->r = build(a+m+1, n-m-1);
    heapify(cur);
    update(cur);
    return cur;
}

Node* root = NULL;
int n, m, a[500000];
int main() {
    cin.tie(0)->sync_with_stdio(0);

    cin >> n >> m;
    for(int i = 0; i < n; i++)
        cin >> a[i];
    root = build(a, n);

    while(m--) {
        string op;
        int p, t;
        cin >> op;
        if(op == "INSERT") {
            cin >> p >> t;
            for(int i = 0; i < t; i++)
                cin >> a[i];
            insert(root, p, build(a, t));
        } else if(op == "DELETE") {
            cin >> p >> t;
            remove(root, p, p+t);
        } else if(op == "MAKE-SAME") {
            int x;
            cin >> p >> t >> x;
            equalize(root, p, p+t, x);
        } else if(op == "REVERSE") {
            cin >> p >> t;
            reverse(root, p, p+t);
        } else if(op == "GET-SUM") {
            cin >> p >> t;
            cout << getsum(root, p, p+t) << endl;
        } else {
            push(root);
            cout << root->mx << endl;
        }
    }
}
