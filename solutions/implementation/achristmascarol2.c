#include <stdio.h>

int main() 
{
    //declare variables, store all months in an array
    int days; 
    int months = 0, years = 0;
    char month[12][10] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    
    scanf("%d", &days); //input
    
    //calculations, 28 days in a month
    months = days/28; //number of months
    days = 28-(days%28 + 4);
    years = 2019-(months/12);
    months = 12-(months%12); //the actual month
    
    printf("%s %d %d", month[months-1], days, years); //output

    return 0;
}
