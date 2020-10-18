#include <bits/stdc++.h>
using namespace std;
int main()
{
    cin.tie(0); cout.tie(0);
    //First, we take the number of addition problems we need to do:
    int N; cin >> N;
    for (int i = 1; i <= N; i++)
    {
        //Secondly, we take the two numbers we're going to add:
        int a, b; cin >> a >> b;
        //Finally, we output the numbers after adding them:
        cout << (a + b) << "\n";
    }
}