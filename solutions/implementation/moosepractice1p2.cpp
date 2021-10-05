#include <bits/stdc++.h>

using namespace std;

int main() {
    // nums[i] = number of occurrences of i
    int nums[101] = {0};
    int n;
    cin >> n;
    int temp;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            // update nums for each entry in the grid
            cin >> temp;
            nums[temp]++;
        }
    }
    for (int i = 1; i <= n; i++) {
        cout << nums[i] << endl;
    }
}
