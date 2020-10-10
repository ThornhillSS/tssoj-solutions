#import stdin from sys to take faster input
from sys import stdin
input = stdin.readline 

#run a for loop for the amount of 3 by 3 squares
for _ in range(int(input())): 
    sqaure = [] #set an array to store the numbers in every square
    for row in range(3): #append the 3 rows into the array
        sqaure.append(list(map(int, input().split())))
    for i in range(3): #run a for-else loop that runs three times
        if sqaure[i][0]-sqaure[i][1] == sqaure[i][1]-sqaure[i][2]: #check if i-th row is arithmetic
            if sqaure[0][i]-sqaure[1][i] == sqaure[1][i]-sqaure[2][i]: #check if i-th column is arithmetic
                continue #if both conditions pass, move onto next row and column
        print('NO') #otherwise print NO and break
        break
    else: #if for loop never broke, then all rows and columns are arithmetic, so print YES
        print('YES')
