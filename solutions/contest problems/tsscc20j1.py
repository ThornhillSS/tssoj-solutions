n = int(input())
arr = input().split()
change = 0
for i in range(n):
    if i%2 == 0 and arr[i] == 'under':
        change += 1 
    elif i%2 == 1 and arr[i] == 'over':
        change += 1 
print(change)
