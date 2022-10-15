#include <bits/stdc++.h>
#define endl "\n"
using namespace std;
typedef long long ll;
typedef unsigned int ui;

int main() {
    cin.tie(0);
    cin.sync_with_stdio(0);
    
    ui n;
    cin >> n;
    vector<ll> nums;
    nums.reserve(n);
    
    for(ui i = 0; i < n; i++) {
        ll  num;
        cin >> num;
        // check if element already exists (linear search)
        if(find(nums.begin(), nums.end(), num) != nums.end()) {
            cout << "YES" << endl;        
            return 0;
        }
        nums.push_back(num);
    }

    cout << "NO" << endl;
    
    return 0;
}
