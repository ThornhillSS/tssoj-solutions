n = int(input())
arr = []
for i in range(n):
    arr.append([int(x) for x in input().split()])
    
for i in range(n-1):
    for x in range(n-i-1):
        arr[i][x] += arr[n-x-1][n-i-1]
for i in range(n):
    print(' '.join(map(str, arr[i][0:n-i])))
