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
int s;
int **bit;
void add(int x, int y, int val){
    for(int a = x; a <= s; a += a & -a){
        for(int b = y; b <= s; b += b & -b){
            bit[a][b] += val;
        }
    }
}
int query(int x, int y){
    int sum = 0;
    for(int a = x; a > 0; a -= a & -a){
        for(int b = y; b > 0; b -= b & -b){
            sum += bit[a][b];
        }
    }
    return sum;
}
int main()
{
    // Solve using a 2 dimensional Binary Indexed Tree/Fenwick Tree
    unsync
    cin >> s >> s;
    bit = new int*[s+1];
    for(int i = 0; i <= s; i++){
        bit[i] = new int[s+1];
        memset(bit[i], 0, sizeof(int) * (s+1));
    }
    while(true){
        int c;
        cin >> c;
        if(c == 3) break;
        if(c == 1){
            int x, y, a;
            cin >> x >> y >> a;
            x++; y++;
            add(x,y,a);
        }
        if(c == 2){
            int l, b, r, t;
            cin >> l >> b >> r >> t;
            l++; b++; r++; t++;
            int val = query(r,t) - query(l-1,t) - query(r,b-1) + query(l-1,b-1);
            cout << val << '\n';
        }
    }
    return 0;
}
