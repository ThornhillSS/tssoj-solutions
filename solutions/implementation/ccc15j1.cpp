#include <iostream>

using namespace std;

int main()
{
    int month, day;
    
    //take input 
    cin >> month >> day;
    
    if(month == 1) // if january
    {
        cout << "Before" << endl;
    }
    else if(month == 2) // if feb
    {
        //need to check days 
        if(day < 18)
        {
            cout << "Before" << endl;
        }
        else if(day == 18)
        {
            cout << "Special" << endl;
        }
        else 
        {
            cout << "After" << endl;
        }
    }
    else 
    {
        cout << "After" << endl;
    }

    return 0;
}
