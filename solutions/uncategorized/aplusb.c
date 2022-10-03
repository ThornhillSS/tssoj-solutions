#include <stdio.h>

int main() { //the main function
    int n; //initializes N which is the number of problems
    scanf("%d\n", &n); //scans input for n

    for (int i = 0; i < n; i++) { //loops n times
        int a, b; //initializes a and b (to add)
        scanf("%d %d\n", &a, &b); //scans input for the variables a and b
        printf("%d\n", a + b); //prints the sum of a and b
    }
}
