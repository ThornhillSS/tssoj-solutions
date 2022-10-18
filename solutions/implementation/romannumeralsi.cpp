#include <bits/stdc++.h>
#ifdef NDEBUG
#   pragma GCC optimize("Ofast")
#   pragma GCC optimize("unroll-loops")
#endif
#pragma GCC target("avx,avx2,fma")
#define unsync cin.sync_with_stdio(false); cin.tie(nullptr);
using namespace std;

string convert(int num) {
    // use switch statement to not write many if/else chains
    switch(num) {
        case 1:
            return "I";

        case 2:
            return "II";

        case 3:
            return "III";

        case 4:
            return "IV";

        case 5:
            return "V";

        case 6:
            return "VI";

        case 7:
            return "VII";

        case 8:
            return "VIII";

        case 9:
            return "IX";

        case 10:
            return "X";
    }
}

int main() {
    unsync;

    int num;
    cin >> num;

    cout << convert(num);
}