#include <bits/stdc++.h>
using namespace std;
const int MM = 105;
int A[MM];
int main()
{
    cin.tie(0);
    //First, we take the number of elements we have in the array and those elements:
    int N; cin >> N;
    for (int i = 1; i <= N; i++) cin >> A[i];
    //Secondly, take the queries:
    int Q; cin >> Q;
    for (int i = 1; i <= Q; i++)
    {
        int a, b, sum = 0; cin >> a >> b;
        //Process each query by adding all the numbers in the range [a, b]:
        for (int i = a; i <= b; i++) sum += A[i];
        //Finally, output the result:
        cout << sum << "\n";
    }
}