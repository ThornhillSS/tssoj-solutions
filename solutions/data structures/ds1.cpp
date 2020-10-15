/*
 * MIT License
 *
 * Copyright (c) 2020 Adam Chen
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
#include <bits/stdc++.h>
#ifdef NDEBUG
#pragma GCC optimize("Ofast")
#pragma GCC optimize("unroll-loops")
#endif
#pragma GCC target("avx,avx2,fma")
#define unsync cin.sync_with_stdio(false);cin.tie(nullptr);
using namespace std;
#define ll long long
#define lp pair<ll,ll>
#define ld long double
ll fw[100001];
ll freq_fw[10000000];
int n, m;
void update(int idx, ll val, ll *arr){
    for(int i = idx; i <= 100001; i += i & -i) {
        arr[i] += val;
    }
}
ll query(int ub, const ll *arr){
    ll sum = 0;
    for(int i = ub; i > 0; i -= i & -i){
        sum += arr[i];
    }
    return sum;
}
int main()
{
    // Solve using Binary Indexed Tree/Fenwick Tree see https://cp-algorithms.com/data_structures/fenwick.html
    unsync
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        int x;
        cin >> x;
        update(i+1, x, fw);
        update(x, 1, freq_fw);
    }
    for(int i = 0; i < m; i++){
        string k;
        cin >> k;
        if(k == "C"){
            int x, v;
            cin >> x >> v;
            ll val = query(x, fw) - query(x-1, fw);
            update(val, -1, freq_fw);
            update(v, 1, freq_fw);
            update(x, v - val, fw);
        }else if(k == "S"){
            int l, r;
            cin >> l >> r;
            cout << (query(r, fw) - query(l-1, fw)) << '\n';
        }else{
            int v;
            cin >> v;
            cout << query(v, freq_fw) << '\n';
        }
    }
    return 0;
}
