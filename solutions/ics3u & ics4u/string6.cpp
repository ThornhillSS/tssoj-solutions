//============================================================================
// Name        : string6.cpp
// Author      : Robloxian
// Version     :
// Description : Code that determines whether or not a string contains only digits.
//============================================================================
#include <bits/stdc++.h>
using namespace std;
#define endl '\n';
#define WHILE(n) while(n--)
#define pb push_back
#define LL long long
#define ULL unsigned long long
#define LD long double
#define LLI long long int
#define PI acos(-1)
int main(){
    cin.sync_with_stdio(0);
    cin.tie(0);
    string s; cin >> s;
    if(all_of(s.begin(), s.end(), ::isdigit)){//operates through the entire range of string and checks if all characters are digits or not.
        cout << "yes" << endl; //if the entire string contain only digits print yes
        return 0; // stops the program
    }
    cout << "no" << endl; // prints no 
    

}
