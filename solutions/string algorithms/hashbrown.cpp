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
#define unsync                  \
    cin.sync_with_stdio(false); \
    cin.tie(nullptr);
using namespace std;
#define ll long long
#define lp pair<ll, ll>
#define ld long double
inline void setbit(ll &mask, int idx, bool bit)
{
    if (bit)
    {
        mask = mask | (1 << idx);
    }
    else
    {
        mask = mask & ~(1 << idx);
    }
}
inline bool getbit(ll mask, int idx) { return (mask >> idx) & 1; }
inline ll gcd(ll a, ll b) { return b == 0 ? a : gcd(b, a % b); }
inline ll lcm(ll a, ll b) { return a * b / gcd(a, b); }
static const __int128 INT128_MAX = static_cast<__int128>(1) << 127;
struct rolling_hash
{
    const static int MAX_LEN;
    int length = 0;
    __int128 hbm;
    __int128 *pow_arr;
    __int128 *arr;
    ll b_prime;
    ll a, b, c;
    template <typename T>
    rolling_hash(const T *data, int len, ll prime = 131, __int128 mod = 9223372036854775783, ll seed = 15247634)
    {
        length = len;
        hbm = mod;
        pow_arr = new __int128[MAX_LEN + 1];
        arr = new __int128[MAX_LEN + 1];
        memset(pow_arr, 0, sizeof(__int128) * (MAX_LEN + 1));
        memset(arr, 0, sizeof(__int128) * (MAX_LEN + 1));
        mt19937 mt_rand(seed);
        a = mt_rand();
        b = mt_rand();
        c = mt_rand();
        pow_arr[0] = 1;
        for (int i = 1; i <= MAX_LEN; i++)
        {
            pow_arr[i] = (pow_arr[i - 1] * prime) % mod;
        }
        for (int i = 1; i <= len; i++)
        {
            arr[i] = (arr[i - 1] + (data[i - 1] * pow_arr[i]) % mod) % mod;
        }
        b_prime = prime;
    }
    static rolling_hash *hash_str(const string &str, ll prime = 131, __int128 mod = 9223372036854775783, ll seed = time(0))
    {
        return new rolling_hash(str.c_str(), str.length(), prime, mod, seed);
    }
    ll hash128(__int128 x) const
    {
        ll low = (ll)x;
        ll high = (ll)(x >> 64);
        return (ll)((a * low + b * high + c) >> 64);
    }
    // zero based index, idx - starting index, len - number of elements.
    ll get_hash(int idx, int len) const
    {
        return hash128(get_hash128(idx, len));
    }
    __int128 get_hash128(int idx, int len) const
    {
        if (idx + len > length)
            len = length - idx;
        return ((((arr[idx + len] - arr[idx]) % hbm + hbm) % hbm) * pow_arr[MAX_LEN - idx]) % hbm;
    }
};
const int rolling_hash::MAX_LEN = 500001;
int hashbrown[500000];
int conveyor[500000];
int main()
{
    unsync

        // This solution implements a rabin karp - rolling hash algorithm to match the string in linear time.
        // The Hashing template used requires a 64 bit compiler and runtime, otherwise, it will fail
        int n,
        m;
    cin >> n >> m;
    for (int i = 0; i < n; i++)
    {
        cin >> conveyor[i];
    }
    for (int i = 0; i < m; i++)
    {
        cin >> hashbrown[i];
    }
    int r_occur = 0;

    auto h1 = new rolling_hash(hashbrown, m, 1000);
    auto h2 = new rolling_hash(conveyor, n, 1000);

    for (int i = 0; i + m <= n; i++)
    {
        if (h1->get_hash128(0, m) == h2->get_hash128(i, m))
            r_occur++;
    }
    cout << r_occur;
    return 0;
}