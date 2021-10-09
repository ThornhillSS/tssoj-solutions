#include <bits/stdc++.h>
using namespace std;

#define ll long long

int arr[(int)1e5+1];

void update(int idx){
    for(; idx<=(int)1e5+1; idx+= idx&(-idx)){
        arr[idx]++;
    }
}

int sum(int idx){
    int s = 0;
    for(; idx>0; idx-=idx&(-idx)){
        s += arr[idx];
    }
    return s;
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);

    ll Q = 0;

    int N; cin>>N;
    for(int i = 1; i<=N; i++){
        int q; cin>>q; q = 1e5+1-q;
        Q+=sum(q);
        update(q);
    }

    cout<<Q;

    return 0;
}
