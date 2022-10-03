n = int(input()) #initializes n and scans it from input
for x in range(n): #loops n times
    a = input().split(" ") #scans a line of input, and splits it into an array a
    print(int(a[0])+int(a[1])) #prints the sum of the first and second index of the array a
