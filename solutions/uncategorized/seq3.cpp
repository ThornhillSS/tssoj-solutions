#include <bits/stdc++.h>
using namespace std;

#define ll long long
#define MAXN (int) 1e5+10

struct node{
    ll sum, pre, suf, maxsum;
    bool lazy;
};

node A[4*MAXN];
int num[MAXN];

void nodesum(node& v, node a, node b){
    v.sum = a.sum+b.sum;
    v.pre = max(a.pre, a.sum+b.pre);
    v.suf = max(b.suf, b.sum + a.suf);
    v.maxsum = max(max(a.maxsum, b.maxsum), a.suf + b.pre);
}

void push(int v, int l, int r){
    if(l==r){
        A[v].lazy = false;
    }
    if(A[v].lazy){
        ll m = (l+r)/2;
        A[v*2].sum = A[v].sum *(m-l+1)/(r-l+1);
        A[v*2+1].sum = A[v].sum *(r-m)/(r-l+1);
        A[v*2].pre = A[v*2].suf = A[v*2].maxsum = max(A[v*2].sum, A[v*2].sum /(m-l+1));
        A[v*2+1].pre = A[v*2+1].suf = A[v*2+1].maxsum = max(A[v*2+1].sum, A[v*2+1].sum /(r-m));
        A[v].lazy = false;
        A[v*2].lazy = A[v*2+1].lazy = true;
    }

}

void build(int v, int l, int r, int *num){
    if(l==r) {
        A[v].sum = A[v].pre = A[v].suf = A[v].maxsum = num[l];
    }
    else{
        int m = (l+r)/2;
        build(v*2, l, m, num);
        build(v*2+1, m+1, r, num);
        nodesum(A[v], A[v*2], A[v*2+1]);
    }
}

ll sumquery(int v, int l, int r, int tl, int tr){
    //if(A[v].sum > 0) cout<<v<<"!";
    if(tl>tr) return 0;
    if(tl == l && tr == r){
        push(v,l,r);
        return A[v].sum;
    }
    push(v,l,r);
    int m = (l+r)/2;
    return sumquery(v*2, l, m, tl, min(tr, m)) + 
    sumquery(v*2+1, m+1, r, max(tl, m+1), tr);
}

ll maxquery(int v, int l, int r){
    return A[v].maxsum;
}

void update(int v, int l, int r, int tl, int tr, ll val){
    if(tl>tr) return;
    if(tl==l && tr==r) {
        push(v,l,r);
        A[v].sum = val*(r-l+1);
        A[v].pre = A[v].suf = A[v].maxsum = max(A[v].sum, val);
        A[v].lazy = true;
        
        return;
    }
    push(v,l,r);
    int m = (l+r)/2;

    update(v*2, l, m, tl, min(tr, m), val);
    update(v*2+1, m+1, r, max(tl, m+1), tr, val);

    nodesum(A[v], A[v*2], A[v*2+1]);

    //if(A[v].maxsum==1) cout<<"!"<<v<<"!";
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);

    int N,M; cin>>N>>M;

    for(int i = 1; i<=N; i++){
        cin>>num[i];
    }

    build(1,1, N, num);
    for(int i = 0; i<M; i++){

        //cout<<"!"<<A[1].maxsum<<"!"<<A[2].maxsum<<"!"<<A[4].maxsum<<"!"<<A[8].maxsum<<"!"<<A[9].maxsum<<"!"<<A[5].maxsum<<"!";
        //cout<<sumquery(1,1,N,4,5)<<" ";
        //for(int i=1; i<=N; i++){
        //    cout<<sumquery(1,1,N,i,i)<<" ";
        //}
        //cout<<"\n";
        string id; cin>>id;
        if(id=="GET-SUM"){
            int l, r; cin>>l>>r;
            cout<<sumquery(1, 1, N, l, l+r-1)<<"\n";
        }
        if(id=="MAX-SUM"){
            cout<<maxquery(1, 1, N)<<"\n";
        }
        if(id=="MAKE-SAME"){
            int l, r, v; cin>>l>>r>>v;
            update(1, 1, N, l, l+r-1, v);
        }
    }

    for(int i=1; i<=N; i++){
        //cout<<sumquery(1,1,N,i,i)<<" ";
    }
    //cout<<"\n";

    //cout<<"\n";

    return 0;
}
