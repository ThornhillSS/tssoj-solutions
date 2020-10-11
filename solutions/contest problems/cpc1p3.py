N = int(input()) #store total number of people
arr = list(map(int, input().split())) #break the line into a list and convert all items into integers
for i in range(1, N+1): #loop through all the people
    print(arr.count(i)) #print the amount of times it appears in the list 
